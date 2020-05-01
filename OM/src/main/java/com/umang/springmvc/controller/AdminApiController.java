package com.umang.springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.client.ItemCategoryClient;
import com.umang.springmvc.client.ItemsClient;
import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.CommonConstant;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.model.CategoryDto;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.FileUploadResponse;
import com.umang.springmvc.model.ItemsCategoryResponse;
import com.umang.springmvc.model.ItemsCategoryResponses;
import com.umang.springmvc.model.ItemsDto;
import com.umang.springmvc.model.ItemsResponse;
import com.umang.springmvc.model.ItemsResponses;
import com.umang.springmvc.model.OfferDto;
import com.umang.springmvc.model.OfferType;
import com.umang.springmvc.webservices.EmpRestURIConstants;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;

@Controller
public class AdminApiController {
	/**
	 * @author Maheshwar.Prasad
	 **/
	@Autowired
	ManuscriptService manuscriptService;
	@Autowired
	ContactDAO contactDao;
	AESCryptUtils encription = new AESCryptUtils();
	private static final Logger logger = LogManager.getLogger(ManuscriptServiceImpl.class);

	private ItemsClient ItemClient = new ItemsClient();

	private ItemCategoryClient itemCatClient = new ItemCategoryClient();

	@RequestMapping(value = { "/apiItems" }, method = RequestMethod.GET)
	public ModelAndView apiItems(ModelMap model) {
		ItemsResponses itemlist = manuscriptService.getItemDetailList("item_name", SortOrder.ASC);
		List<ItemsDto> itemsList = itemlist.getData();
		return new ModelAndView("apiItems", "itemList", itemsList);
	}

	@RequestMapping(value = { "/saveItem" }, method = RequestMethod.POST)
	public ModelAndView itemSave(ModelMap model, @RequestParam("types") Integer type,
			@RequestParam("description") String description, @RequestParam("itemName") String itemName,
			@RequestParam("mrp") Double mrp, @RequestParam("pack") String pack,
			@RequestParam(value = "display-order", required = false, defaultValue = "1") Integer displayOrder,
			@RequestParam(value = "offer-type", required = false, defaultValue = "FU") OfferType offerType,
			@RequestParam(value = "offer-effective-date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date offerEffectiveDate,
			@RequestParam(value = "offer-till-date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date offerTillDate,
			@RequestParam(value = "free", required = false, defaultValue = "1") Integer free,
			@RequestParam("unitPrice") Double unitPrice, @RequestParam("status") Boolean status,
			@RequestParam("file") MultipartFile file)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		ItemsResponse itemResponse = null;
		File item_file = new File(file.getOriginalFilename());
		ItemsCategoryResponses categoryResponses = itemCatClient.findAllSorted("category_name", SortOrder.ASC);
		List<CategoryDto> categoryDtos = categoryResponses.getData();
		try (FileOutputStream fileOutputStream = new FileOutputStream(item_file)) {
			fileOutputStream.write(file.getBytes());
			ItemsDto itemsDto = new ItemsDto();
			itemsDto.setActive(status);
			itemsDto.setDescription(description);
			itemsDto.setDisplayOrder(displayOrder);
			itemsDto.setFree(free);
			itemsDto.setItemName(itemName);
			itemsDto.setMrp(mrp);
			itemsDto.setOfferEffectedBy(offerEffectiveDate == null ? new Date() : offerEffectiveDate);
			itemsDto.setOfferTill(offerTillDate == null ? new Date() : offerTillDate);
			itemsDto.setOfferType(offerType);
			itemsDto.setOfferUnits(10);
			itemsDto.setPack(pack);
			itemsDto.setUnitPrice(unitPrice);
			itemsDto.setProductCat(new CategoryDto(type));
			itemResponse = ItemClient.save(itemsDto);
			FileUploadResponse fileRes = ItemClient.postItemImage(itemResponse.getData().getId(), item_file);
			System.out.println(fileRes);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail");
			return new ModelAndView("itemCreate", "ItemsResponses", categoryDtos);
		}
		if (itemResponse.getMessage().equals("success")) {
			return new ModelAndView("redirect:apiItems");
		} else {
			return new ModelAndView("itemCreate");
		}
	}

	@RequestMapping(value = EmpRestURIConstants.DELETE_ITEM, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Item deleteItem(ModelMap model, @PathVariable("id") int id) {
		Item item = new Item();
		try {
			DeleteResponse response = ItemClient.delete(id);
			if (response.getStatusCode().equals(CommonConstant.SUCCESS)) {
				item.setStatus("Success");
			} else {
				item.setStatus("Fail");
			}

		} catch (Exception e) {
			item.setStatus("Fail");
			return item;
		}
		return item;
	}

	@RequestMapping(value = { "/offer" }, method = RequestMethod.GET)
	public ModelAndView offer(ModelMap model, @ModelAttribute ItemsDto item) {

		ItemsResponses itemlist = null;
		itemlist = manuscriptService.getItemDetailList("item_name", SortOrder.ASC);

		return new ModelAndView("offer", "itemList", itemlist);
	}

	@RequestMapping(value = { "/saveOffer" }, method = RequestMethod.POST)
	public @ResponseBody OfferDto saveOffer(ModelMap model, @RequestBody OfferDto offer) {
		try {
			System.out.println("Offer Name : " + offer.getOfferName());
			ItemsResponse itemlist = manuscriptService.getItemByItemId(offer.getItemsDto().getId(), SortOrder.ASC);
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			// Parsing the given String to Date object
			Date from = offer.getDurationFrom();
			Date to = offer.getDurationTo();
			OfferDto offerDto = new OfferDto();
			offerDto.setActive(false);
			offerDto.setOfferName(offer.getOfferName());
			offerDto.setDurationFrom(from);
			offerDto.setDurationTo(to);
			offerDto.setGift(offer.getGift());
			offerDto.setPurchase(offer.getPurchase());
			offerDto.setItemsDto(itemlist.getData());

			System.out.println(from);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail");
			// iteamValue.setStatus("Fail");
			return offer;
			// e.printStackTrace();
		}

		return offer;
	}

	@RequestMapping(value = "/itemType", method = RequestMethod.GET)
	public ModelAndView itemType(ModelMap model) {
		return new ModelAndView("itemType", "category", new CategoryDto());
	}

	@RequestMapping(value = "/saveItemType", method = RequestMethod.POST)
	public ModelAndView saveItemType(ModelMap model, @Valid @ModelAttribute CategoryDto category)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		ItemsCategoryResponse res = itemCatClient.save(category);
		if (res.getStatusCode().equals(CommonConstant.SUCCESS))
			return new ModelAndView("redirect:itemTypeList");
		else
			return new ModelAndView("itemType", "category", new CategoryDto());
	}
}
