package com.umang.springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
import com.umang.springmvc.entities.AppUser;
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

	private ItemsClient itemClient = new ItemsClient();

	private ItemCategoryClient itemCatClient = new ItemCategoryClient();

	@RequestMapping(value = { "/apiItems" }, method = RequestMethod.GET)
	public ModelAndView apiItems(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsResponses itemlist = itemClient.findAllSorted("item_name", SortOrder.ASC, (user == null ? null : user.getRouting()));
		List<ItemsDto> itemsList = itemlist.getData();
		return new ModelAndView("apiItems", "itemList", itemsList);
	}

	@RequestMapping(value = { "/saveItem" }, method = RequestMethod.POST)
	public ModelAndView itemSave(ModelMap model, @RequestParam("types") Integer type,
			@RequestParam("description") String description, @RequestParam("itemName") String itemName,
			@RequestParam("mrp") Double mrp, @RequestParam("pack") String pack,
			@RequestParam(value = "display-order", required = false, defaultValue = "1") Integer displayOrder,
			@RequestParam(value = "offer-type") OfferType offerType,
			@RequestParam(value = "offer-effective-date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date offerEffectiveDate,
			@RequestParam(value = "offer-till-date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date offerTillDate,
			@RequestParam(value = "free") Integer free,@RequestParam(value = "offerUnits") Integer offerUnits ,
			@RequestParam("unitPrice") Double unitPrice, @RequestParam("status") Boolean status,
			@RequestParam("file") MultipartFile file, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsResponse itemResponse = null;
		String path = request.getServletContext().getResource("static").getFile();
		File item_file = new File(path + "/img/item/" + file.getOriginalFilename());
		ItemsCategoryResponses categoryResponses = itemCatClient.findAllSorted("category_name", SortOrder.ASC,
				(user == null ? null : user.getRouting()));
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
			itemsDto.setOfferUnits(offerUnits);
			itemsDto.setPack(pack);
			itemsDto.setUnitPrice(unitPrice);
			itemsDto.setProductCat(new CategoryDto(type));
			itemResponse = itemClient.save(itemsDto, (user == null ? null : user.getRouting()));
			fileOutputStream.flush();
			FileUploadResponse fileRes = itemClient.postItemImage(itemResponse.getData().getId(), item_file,
					(user == null ? null : user.getRouting()));
			File rename = new File(path + "/img/item/" + fileRes.getData().getFileKey());
			item_file.renameTo(rename);
			item_file.delete();
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

	@RequestMapping(value = EmpRestURIConstants.EDIT_ITEM, method = RequestMethod.GET)
	public ModelAndView editItem(ModelMap model, @PathVariable("itemid") int itemid, HttpServletRequest request) {
		logger.info(" editItem *********************");
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		try {
			model.put("types",
					itemCatClient.findAllSorted("category_name", SortOrder.ASC, (user == null ? null : user.getRouting())).getData());
			ItemsDto itemdto = itemClient.findById(itemid, (user == null ? null : user.getRouting())).getData();
			model.addAttribute("offerTill", dateConvertion(itemdto.getOfferTill().toString()));
			model.addAttribute("offerEffectedBy", dateConvertion(itemdto.getOfferEffectedBy().toString()));
			return new ModelAndView("editItems", "item", itemClient.findById(itemid, (user == null ? null : user.getRouting())).getData());
		} catch (Exception e) {
			return new ModelAndView("redirect:/apiItems/editItem/" + itemid + "");
		}
	}

	@RequestMapping(value = { "/saveEditItem" }, method = RequestMethod.POST)
	public ModelAndView saveEditItem(ModelMap model, @RequestParam("itemId") Integer id,
			@RequestParam("types") Integer type, @RequestParam("description") String description,
			@RequestParam("itemName") String itemName, @RequestParam("mrp") Double mrp,
			@RequestParam("pack") String pack,
			@RequestParam(value = "display-order", required = false, defaultValue = "1") Integer displayOrder,
			@RequestParam(value = "offer-type") OfferType offerType,
			@RequestParam(value = "offer-effective-date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date offerEffectiveDate,
			@RequestParam(value = "offer-till-date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date offerTillDate,
			@RequestParam(value = "free") Integer free,@RequestParam(value = "offerUnits") Integer offerUnits ,
			@RequestParam("unitPrice") Double unitPrice, @RequestParam("status") Boolean status,
			@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsResponse itemResponse = null;
		File item_file = null;
		ItemsCategoryResponses categoryResponses = itemCatClient.findAllSorted("category_name", SortOrder.ASC,
				(user == null ? null : user.getRouting()));
		List<CategoryDto> categoryDtos = categoryResponses.getData();
		FileOutputStream fileOutputStream = null;
		String path = request.getServletContext().getResource("static").getFile();
		if (file != null && file.getSize() > 0) {
			item_file = new File(path + "/img/item/" + file.getOriginalFilename());
			fileOutputStream = new FileOutputStream(item_file);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.flush();
			itemClient.postItemImage(id, item_file, (user == null ? null : user.getRouting()));
			item_file.delete();
		}
		try {
			ItemsDto itemsDto = itemClient.findById(id, (user == null ? null : user.getRouting())).getData();
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
			itemResponse = itemClient.update(itemsDto, (user == null ? null : user.getRouting()));
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
	public @ResponseBody Item deleteItem(ModelMap model, @PathVariable("id") int id, HttpServletRequest request) {
		Item item = new Item();
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		try {
			DeleteResponse response = itemClient.delete(id, (user == null ? null : user.getRouting()));
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

	@RequestMapping(value = "/itemType", method = RequestMethod.GET)
	public ModelAndView itemType(ModelMap model) {
		return new ModelAndView("itemType", "category", new CategoryDto());
	}

	@RequestMapping(value = "/saveItemType", method = RequestMethod.POST)
	public ModelAndView saveItemType(ModelMap model, @Valid @ModelAttribute CategoryDto category,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsCategoryResponse res = itemCatClient.save(category, (user == null ? null : user.getRouting()));
		if (res.getStatusCode().equals(CommonConstant.SUCCESS))
			return new ModelAndView("redirect:itemTypeList");
		else
			return new ModelAndView("itemType", "category", new CategoryDto());
	}
	public String dateConvertion(String inputDateStringinIST) {
		 String input = inputDateStringinIST;//"Sat May 30 00:00:00 IST 2020";
			DateTimeFormatter f = DateTimeFormatter.ofPattern( "E MMM dd HH:mm:ss z uuuu" )
			                                       .withLocale( Locale.US );
			ZonedDateTime zdt = ZonedDateTime.parse( input , f );
			LocalDate ld = zdt.toLocalDate();
			DateTimeFormatter fLocalDate = DateTimeFormatter.ofPattern( "dd/MM/uuuu" );
			String output = ld.format( fLocalDate) ;
			return output;
	 }
}
