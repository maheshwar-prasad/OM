package com.umang.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.client.ItemsClient;
import com.umang.springmvc.client.OrdersClient;
import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.client.StockClient;
import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.CommonConstant;
import com.umang.springmvc.model.ItemsDto;
import com.umang.springmvc.model.ItemsResponses;
import com.umang.springmvc.model.StockDto;
import com.umang.springmvc.model.StockForm;
import com.umang.springmvc.model.StockResponses;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;

@Controller
public class StockController {
	/**
	 * @author Maheshwar.Prasad
	 **/
	@Autowired
	ManuscriptService manuscriptService;
	@Autowired
	ContactDAO contactDao;
	AESCryptUtils encription = new AESCryptUtils();
	private static final Logger logger = LogManager.getLogger(ManuscriptServiceImpl.class);

	OrdersClient client = new OrdersClient();

	private StockClient stockClient = new StockClient();

	private ItemsClient ItemClient = new ItemsClient();

	@RequestMapping(value = { "/stock" }, method = RequestMethod.GET)
	public ModelAndView stocks(ModelMap model)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		StockResponses res = stockClient.findAllSorted("qty", SortOrder.ASC);
		return new ModelAndView("stock", "stocks", res.getData());

	}

	@RequestMapping(value = { "/creatStock" }, method = RequestMethod.GET)
	public ModelAndView creatStock(ModelMap model)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		StockResponses res = stockClient.findAllSorted("qty", SortOrder.ASC);
		ItemsResponses itemlist = manuscriptService.getItemDetailList("item_name", SortOrder.ASC);
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
		return new ModelAndView("creatStock", "stockForm", new StockForm());
	}

	@RequestMapping(value = { "/saveStock" }, method = RequestMethod.POST)
	public ModelAndView saveStock(ModelMap model, @ModelAttribute StockForm stockForm)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		StockResponses response = stockClient.updateAll(Arrays.asList(stockForm.getStock()));
		if (response.getStatusCode().equals(CommonConstant.SUCCESS))
			return new ModelAndView("redirect:stock");
		else {
			ItemsResponses itemlist = manuscriptService.getItemDetailList("item_name", SortOrder.ASC);
			model.put("itemlist", itemlist.getData());
			model.put("status", "Fail");
			return new ModelAndView("creatStock", "stock", new StockDto());
		}

	}
}
