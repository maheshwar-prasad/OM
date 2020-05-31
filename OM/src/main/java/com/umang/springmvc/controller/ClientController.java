package com.umang.springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.client.ItemCategoryClient;
import com.umang.springmvc.client.ItemsClient;
import com.umang.springmvc.client.OfferClient;
import com.umang.springmvc.client.OrdersClient;
import com.umang.springmvc.client.SalesOrderClient;
import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.client.StockClient;
import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.entities.CommonConstant;
import com.umang.springmvc.model.CancelOrder;
import com.umang.springmvc.model.CategoryDto;
import com.umang.springmvc.model.FileUploadResponse;
import com.umang.springmvc.model.ItemsCategoryResponse;
import com.umang.springmvc.model.ItemsCategoryResponses;
import com.umang.springmvc.model.ItemsDto;
import com.umang.springmvc.model.ItemsResponse;
import com.umang.springmvc.model.ItemsResponses;
import com.umang.springmvc.model.OfferDto;
import com.umang.springmvc.model.OfferResponse;
import com.umang.springmvc.model.OfferType;
import com.umang.springmvc.model.OrderStatus;
import com.umang.springmvc.model.SalesOrderDto;
import com.umang.springmvc.model.SalesOrderResponse;
import com.umang.springmvc.model.SalesOrderResponses;
import com.umang.springmvc.model.StockDto;
import com.umang.springmvc.model.StockForm;
import com.umang.springmvc.model.StockResponses;
import com.umang.springmvc.webservices.EmpRestURIConstants;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;

@Controller
public class ClientController {
	/**
	 * @author Maheshwar.Prasad
	 **/
	@Autowired
	ManuscriptService manuscriptService;
	@Autowired
	ContactDAO contactDao;
	AESCryptUtils encription = new AESCryptUtils();
	private static final Logger logger = LogManager.getLogger(ManuscriptServiceImpl.class);
	OrdersClient orderClient = new OrdersClient();
	private ItemCategoryClient itemCatClient = new ItemCategoryClient();
	private ItemsClient itemClient = new ItemsClient();
	private OfferClient offerClient = new OfferClient();
	SalesOrderClient salesOrderClient = new SalesOrderClient();
	private StockClient stockClient = new StockClient();

	@RequestMapping(value = { "/clientdashboard" }, method = RequestMethod.GET)
	public String dashboard(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");

		List<SalesOrderDto> finalRecentArtifactList = new ArrayList<>();
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null,
				(user == null ? null : user.getRouting()));
		model.put("orderSize", orderResponses.getData().size());
		finalRecentArtifactList = orderResponses.getData().stream().limit(6).collect(Collectors.toList());
		model.put("orderList", finalRecentArtifactList);
		return "clientdashboard";
	}

	@RequestMapping(value = { "/createClient" }, method = RequestMethod.GET)
	public ModelAndView apiItems(ModelMap model) {
		logger.info("**********************88");
		return new ModelAndView("createClient", "create", "");

	}

	@RequestMapping(value = { "/clientmember" }, method = RequestMethod.GET)
	public ModelAndView member(ModelMap model) {
		logger.info("**********  Member************");
		return new ModelAndView("clientmember", "clientmember", "");
	}

	@RequestMapping(value = { "/clientitemTypeList" }, method = RequestMethod.GET)
	public ModelAndView itemTypeList(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsCategoryResponses categoryResponses = itemCatClient.findAllSorted("category_name", SortOrder.ASC,
				(user == null ? null : user.getRouting()));
		List<CategoryDto> categoryDtos = categoryResponses.getData();
		return new ModelAndView("clientitemTypeList", "itemTypeList", categoryDtos);
	}

	@RequestMapping(value = { "/clientItems" }, method = RequestMethod.GET)
	public ModelAndView clientItems(ModelMap model, HttpServletRequest request) {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsResponses itemlist = manuscriptService.getItemDetailList("item_name", SortOrder.ASC,
				(user == null ? null : user.getRouting()));
		List<ItemsDto> itemsList = itemlist.getData();
		return new ModelAndView("clientItems", "itemList", itemsList);
	}

	@RequestMapping(value = "/categoryPage", method = RequestMethod.GET)
	public ModelAndView itemType(ModelMap model) {
		return new ModelAndView("categoryPage", "category", new CategoryDto());
	}

	@RequestMapping(value = "/saveCategory", method = RequestMethod.POST)
	public ModelAndView saveItemType(ModelMap model, @Valid @ModelAttribute CategoryDto category,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsCategoryResponse res = itemCatClient.save(category, (user == null ? null : user.getRouting()));
		if (res.getStatusCode().equals(CommonConstant.SUCCESS))
			return new ModelAndView("redirect:clientitemTypeList");
		else
			return new ModelAndView("categoryPage", "category", new CategoryDto());
	}

	@RequestMapping(value = { "/clientItemCreate" }, method = RequestMethod.GET)
	public ModelAndView itemCreate(ModelMap model, @ModelAttribute("item") ItemsDto item, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsCategoryResponses categoryResponses = itemCatClient.findAllSorted("category_name", SortOrder.ASC,
				(user == null ? null : user.getRouting()));
		List<CategoryDto> categoryDtos = categoryResponses.getData();
		return new ModelAndView("clientItemCreate", "types", categoryDtos);
	}

	@RequestMapping(value = { "/clientSaveItem" }, method = RequestMethod.POST)
	public ModelAndView itemSave(ModelMap model, @RequestParam("types") Integer type,
			@RequestParam("description") String description, @RequestParam("itemName") String itemName,
			@RequestParam("mrp") Double mrp, @RequestParam("pack") String pack,
			@RequestParam(value = "display-order", required = false, defaultValue = "1") Integer displayOrder,
			@RequestParam(value = "offer-type") OfferType offerType,
			@RequestParam(value = "offer-effective-date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date offerEffectiveDate,
			@RequestParam(value = "offer-till-date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date offerTillDate,
			@RequestParam(value = "free") Integer free, @RequestParam(value = "offerUnits") Integer offerUnits,
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
			return new ModelAndView("clientItemCreate", "ItemsResponses", categoryDtos);
		}
		if (itemResponse.getMessage().equals("success")) {
			return new ModelAndView("redirect:clientItems");
		} else {
			return new ModelAndView("clientItemCreate");
		}
	}

	@RequestMapping(value = EmpRestURIConstants.CLIENT_EDIT_ITEM, method = RequestMethod.GET)
	public ModelAndView editItem(ModelMap model, @PathVariable("itemid") int itemid, HttpServletRequest request) {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		logger.info(" editItem *********************");
		try {
			model.put("types",
					itemCatClient
							.findAllSorted("category_name", SortOrder.ASC, (user == null ? null : user.getRouting()))
							.getData());
			ItemsDto itemdto = itemClient.findById(itemid, (user == null ? null : user.getRouting())).getData();
			model.addAttribute("offerTill", dateConvertion(itemdto.getOfferTill().toString()));
			model.addAttribute("offerEffectedBy", dateConvertion(itemdto.getOfferEffectedBy().toString()));
			return new ModelAndView("clientEditItems", "item",
					itemClient.findById(itemid, (user == null ? null : user.getRouting())).getData());
		} catch (Exception e) {
			return new ModelAndView("redirect:/clientItems/editItem/" + itemid + "");
		}

	}

	@RequestMapping(value = { "/clientEditSaveItem" }, method = RequestMethod.POST)
	public ModelAndView saveEditItem(ModelMap model, @RequestParam("itemId") Integer id,
			@RequestParam("types") Integer type, @RequestParam("description") String description,
			@RequestParam("itemName") String itemName, @RequestParam("mrp") Double mrp,
			@RequestParam("pack") String pack,
			@RequestParam(value = "display-order", required = false, defaultValue = "1") Integer displayOrder,
			@RequestParam(value = "offer-type") OfferType offerType,
			@RequestParam(value = "offer-effective-date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date offerEffectiveDate,
			@RequestParam(value = "offer-till-date", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date offerTillDate,
			@RequestParam(value = "free") Integer free, @RequestParam(value = "offerUnits") Integer offerUnits,
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
			itemsDto.setId(id);
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
			itemResponse = itemClient.update(itemsDto, (user == null ? null : user.getRouting()));
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail");
			return new ModelAndView("clientItemCreate", "ItemsResponses", categoryDtos);
		}
		if (itemResponse.getMessage().equals("success")) {
			return new ModelAndView("redirect:clientItems");
		} else {
			return new ModelAndView("clientItemCreate");
		}
	}

	/**
	 * Offer Section
	 */
	@RequestMapping(value = { "/clientOffer" }, method = RequestMethod.GET)
	public ModelAndView offer(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsResponses itemlist = itemClient.findAllSorted("item_name", SortOrder.ASC,
				(user == null ? null : user.getRouting()));
		List<ItemsDto> itemsList = itemlist.getData();
		model.put("itemlist", itemsList);
		return new ModelAndView("clientOffer", "offer", new OfferDto());
	}

	@RequestMapping(value = { "/clientSaveOffer" }, method = RequestMethod.POST)
	public ModelAndView saveOffer(ModelMap model, @ModelAttribute OfferDto offer, HttpServletRequest request) {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		try {
			OfferResponse offerResponse = offerClient.save(offer, (user == null ? null : user.getRouting()));
			ItemsResponses itemlist = itemClient.findAllSorted("item_name", SortOrder.ASC,
					(user == null ? null : user.getRouting()));
			List<ItemsDto> itemsList = itemlist.getData();
			model.put("status", "success");
			model.put("itemlist", itemsList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail");
			return new ModelAndView("redirect:clientSaveOffer");
		}

		return new ModelAndView("redirect:clientOffer");
	}

	@RequestMapping(value = { "/clientUpdateOffer" }, method = RequestMethod.POST)
	public ModelAndView updateOffer(ModelMap model, @ModelAttribute OfferDto offer, HttpServletRequest request) {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		try {
			OfferResponse offerResponse = offerClient.update(offer, (user == null ? null : user.getRouting()));
			ItemsResponses itemlist = itemClient.findAllSorted("item_name", SortOrder.ASC,
					(user == null ? null : user.getRouting()));
			List<ItemsDto> itemsList = itemlist.getData();
			model.put("status", "success");
			model.put("itemlist", itemsList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail");
		}

		return new ModelAndView("redirect:clientOffers");
	}

	@RequestMapping(value = { "/clientOffers" }, method = RequestMethod.GET)
	public ModelAndView offers(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		model.put("offer_list", offerClient
				.findAllSorted("offer_name", SortOrder.ASC, (user == null ? null : user.getRouting())).getData());
		return new ModelAndView("clientOfferList", "offer", new OfferDto());
	}

	@RequestMapping(value = { "/clientdelete-offer" }, method = RequestMethod.GET)
	public ModelAndView deleteOffer(ModelMap model, @RequestParam("id") Integer id, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		offerClient.delete(id, (user == null ? null : user.getRouting()));
		model.put("offer_list", offerClient
				.findAllSorted("offer_name", SortOrder.ASC, (user == null ? null : user.getRouting())).getData());
		return new ModelAndView("clientOfferList", "offer", new OfferDto());
	}

	@RequestMapping(value = { "/clientget-offer" }, method = RequestMethod.GET)
	public ModelAndView offer(ModelMap model, @RequestParam("id") Integer id, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsResponses itemlist = itemClient.findAllSorted("item_name", SortOrder.ASC,
				(user == null ? null : user.getRouting()));
		OfferDto dto = offerClient.findById(id, (user == null ? null : user.getRouting())).getData();
		List<ItemsDto> itemsList = itemlist.getData();
		model.put("itemlist", itemsList);
		model.put("selected", dto.getItemsDto().getId());
		model.put("fromDate", new SimpleDateFormat("dd/MM/yyyy").format(dto.getDurationFrom()));
		model.put("toDate", new SimpleDateFormat("dd/MM/yyyy").format(dto.getDurationFrom()));
		return new ModelAndView("clientUpdateOffer", "offer", dto);
	}

	/**
	 * Order Section
	 */
	@RequestMapping(value = { "/clientOrder" }, method = RequestMethod.GET)
	public ModelAndView order(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null,
				(user == null ? null : user.getRouting()));
		return new ModelAndView("clientOrder", "orderList", orderResponses.getData());

	}

	@RequestMapping(value = { "/clientOrderDetails" }, method = RequestMethod.GET)
	public ModelAndView orderDetails(ModelMap model, @RequestParam("order-number") String orderNumber,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null,
				(user == null ? null : user.getRouting()));
		List<SalesOrderDto> dtos = orderResponses.getData();
		model.put("orderDetail",
				dtos.parallelStream().filter(ORD -> ORD.getOrderNumber().equals(orderNumber)).findFirst().get());

		return new ModelAndView("clientOrderDetails", "salesOrder", new SalesOrderDto());

	}

	@RequestMapping(value = { "/clientCancelOrder" }, method = RequestMethod.GET)
	public ModelAndView cancelOrder(ModelMap model, @RequestParam("order-number") String orderNumber,
			@RequestParam(value = "remarks", required = false, defaultValue = "Cancelled") String remarks,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		CancelOrder cancelOrder = new CancelOrder();
		cancelOrder.setOrderNo(orderNumber);
		cancelOrder.setRemarks(remarks);
		SalesOrderResponse res = orderClient.cancelOrder(cancelOrder, (user == null ? null : user.getRouting()));
		model.put("orderDetail", res.getData());
		return new ModelAndView("clientOrderDetails", "salesOrder", new SalesOrderDto());

	}

	@RequestMapping(value = { "/clientAcceptOrder" }, method = RequestMethod.GET)
	public ModelAndView acceptOrder(ModelMap model, @RequestParam("order-number") String orderNumber,
			@RequestParam(value = "remarks", required = false, defaultValue = "Accepted") String remarks,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null,
				(user == null ? null : user.getRouting()));
		List<SalesOrderDto> dtos = orderResponses.getData();
		SalesOrderDto dto = dtos.parallelStream().filter(ORD -> ORD.getOrderNumber().equals(orderNumber)).findFirst()
				.get();
		dto.setAcceptedOn(new Date());
		dto.setRemark(remarks);
		dto.setOrderStatus(OrderStatus.A);
		model.put("orderDetail", salesOrderClient.update(dto, (user == null ? null : user.getRouting())).getData());
		return new ModelAndView("clientOrderDetails", "salesOrder", new SalesOrderDto());

	}

	@RequestMapping(value = { "/clientMarkDelivered" }, method = RequestMethod.GET)
	public ModelAndView markDiliver(ModelMap model, @RequestParam("order-number") String orderNumber,
			@RequestParam(value = "remarks", required = false, defaultValue = "Dilivered") String remarks,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null,
				(user == null ? null : user.getRouting()));
		List<SalesOrderDto> dtos = orderResponses.getData();
		SalesOrderDto dto = dtos.parallelStream().filter(ORD -> ORD.getOrderNumber().equals(orderNumber)).findFirst()
				.get();
		dto.setDeliveredOn(new Date());
		dto.setRemark(remarks);
		dto.setOrderStatus(OrderStatus.D);
		model.put("orderDetail", salesOrderClient.update(dto, (user == null ? null : user.getRouting())).getData());
		return new ModelAndView("clientOrderDetails", "salesOrder", new SalesOrderDto());

	}

	@RequestMapping(value = { "/clientDeleteOrder" }, method = RequestMethod.GET)
	public ModelAndView deleteOrder(ModelMap model, @RequestParam("order-number") String orderNumber,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null,
				(user == null ? null : user.getRouting()));
		List<SalesOrderDto> dtos = orderResponses.getData();
		SalesOrderDto dto = dtos.parallelStream().filter(ORD -> ORD.getOrderNumber().equals(orderNumber)).findFirst()
				.get();
		salesOrderClient.delete(dto.getId(), (user == null ? null : user.getRouting()));
		return new ModelAndView("redirect:clientOrder");

	}

	/**
	 * Stock Section
	 */
	@RequestMapping(value = { "/clientStock" }, method = RequestMethod.GET)
	public ModelAndView stocks(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		StockResponses res = stockClient.findAllSorted("qty", SortOrder.ASC, (user == null ? null : user.getRouting()));
		return new ModelAndView("clientStock", "stocks", res.getData());

	}

	@RequestMapping(value = { "/clientCreatStock" }, method = RequestMethod.GET)
	public ModelAndView creatStock(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		StockResponses res = stockClient.findAllSorted("qty", SortOrder.ASC, (user == null ? null : user.getRouting()));
		ItemsResponses itemlist = manuscriptService.getItemDetailList("item_name", SortOrder.ASC,
				(user == null ? null : user.getRouting()));
		List<StockDto> stockDtos = new ArrayList<>();
		List<ItemsDto> itemsDtos = itemlist.getData();
		List<StockDto> availables = res.getData();
		for (ItemsDto item : itemsDtos) {
			StockDto stockDto = new StockDto();
			stockDto.setDto(item);
			stockDto.setQty(0);
			for (StockDto dto : availables) {
				if (dto.getDto().equals(item)) {
					stockDto.setQty(dto.getQty());
					break;
				}

			}
			stockDtos.add(stockDto);
		}

		model.put("stocks", stockDtos);
		return new ModelAndView("clientCreatStock", "stockForm", new StockForm());
	}

	@RequestMapping(value = { "/clientSaveStock" }, method = RequestMethod.POST)
	public ModelAndView saveStock(ModelMap model, @ModelAttribute StockForm stockForm, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		StockResponses response = stockClient.updateAll(Arrays.asList(stockForm.getStock()),
				(user == null ? null : user.getRouting()));
		if (response.getStatusCode().equals(CommonConstant.SUCCESS))
			return new ModelAndView("redirect:clientStock");
		else {
			ItemsResponses itemlist = manuscriptService.getItemDetailList("item_name", SortOrder.ASC,
					(user == null ? null : user.getRouting()));
			model.put("itemlist", itemlist.getData());
			model.put("status", "Fail");
			return new ModelAndView("clientCreatStock", "stock", new StockDto());
		}
	}

	@RequestMapping(value = "/clientSaveItemType", method = RequestMethod.POST)
	public ModelAndView clientSaveItemType(ModelMap model, @Valid @ModelAttribute CategoryDto category,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		ItemsCategoryResponse res = itemCatClient.save(category, (user == null ? null : user.getRouting()));
		if (res.getStatusCode().equals(CommonConstant.SUCCESS))
			return new ModelAndView("redirect:clientitemTypeList");
		else
			return new ModelAndView("category", "category", new CategoryDto());
	}

	public String dateConvertion(String inputDateStringinIST) {
		String input = inputDateStringinIST;// "Sat May 30 00:00:00 IST 2020";
		DateTimeFormatter f = DateTimeFormatter.ofPattern("E MMM dd HH:mm:ss z uuuu").withLocale(Locale.US);
		ZonedDateTime zdt = ZonedDateTime.parse(input, f);
		LocalDate ld = zdt.toLocalDate();
		DateTimeFormatter fLocalDate = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String output = ld.format(fLocalDate);
		return output;
	}
}
