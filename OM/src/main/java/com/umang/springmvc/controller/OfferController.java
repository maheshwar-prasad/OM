package com.umang.springmvc.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.client.ItemsClient;
import com.umang.springmvc.client.OfferClient;
import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.model.ItemsDto;
import com.umang.springmvc.model.ItemsResponses;
import com.umang.springmvc.model.OfferDto;
import com.umang.springmvc.model.OfferResponse;

@Controller
public class OfferController {

	private OfferClient offerClient = new OfferClient();

	private ItemsClient ItemClient = new ItemsClient();

	@RequestMapping(value = { "/offer" }, method = RequestMethod.GET)
	public ModelAndView offer(ModelMap model)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		ItemsResponses itemlist = ItemClient.findAllSorted("item_name", SortOrder.ASC);
		List<ItemsDto> itemsList = itemlist.getData();
		model.put("itemlist", itemsList);
		return new ModelAndView("offer", "offer", new OfferDto());
	}

	@RequestMapping(value = { "/saveOffer" }, method = RequestMethod.POST)
	public ModelAndView saveOffer(ModelMap model, @ModelAttribute OfferDto offer) {
		try {
			OfferResponse offerResponse = offerClient.save(offer);
			ItemsResponses itemlist = ItemClient.findAllSorted("item_name", SortOrder.ASC);
			List<ItemsDto> itemsList = itemlist.getData();
			model.put("status", "success");
			model.put("itemlist", itemsList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail");
		}

		return new ModelAndView("redirect:offers");
	}

	@RequestMapping(value = { "/updateOffer" }, method = RequestMethod.POST)
	public ModelAndView updateOffer(ModelMap model, @ModelAttribute OfferDto offer) {
		try {
			OfferResponse offerResponse = offerClient.update(offer);
			ItemsResponses itemlist = ItemClient.findAllSorted("item_name", SortOrder.ASC);
			List<ItemsDto> itemsList = itemlist.getData();
			model.put("status", "success");
			model.put("itemlist", itemsList);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail");
		}

		return new ModelAndView("redirect:offers");
	}

	@RequestMapping(value = { "/offers" }, method = RequestMethod.GET)
	public ModelAndView offers(ModelMap model)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		model.put("offer_list", offerClient.findAllSorted("offer_name", SortOrder.ASC).getData());
		return new ModelAndView("offerList", "offer", new OfferDto());
	}

	@RequestMapping(value = { "/delete-offer" }, method = RequestMethod.GET)
	public ModelAndView deleteOffer(ModelMap model, @RequestParam("id") Integer id)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		offerClient.delete(id);
		model.put("offer_list", offerClient.findAllSorted("offer_name", SortOrder.ASC).getData());
		return new ModelAndView("offerList", "offer", new OfferDto());
	}

	@RequestMapping(value = { "/get-offer" }, method = RequestMethod.GET)
	public ModelAndView offer(ModelMap model, @RequestParam("id") Integer id)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		ItemsResponses itemlist = ItemClient.findAllSorted("item_name", SortOrder.ASC);
		OfferDto dto = offerClient.findById(id).getData();
		List<ItemsDto> itemsList = itemlist.getData();
		model.put("itemlist", itemsList);
		model.put("selected", dto.getItemsDto().getId());
		model.put("fromDate", new SimpleDateFormat("dd/MM/yyyy").format(dto.getDurationFrom()));
		model.put("toDate", new SimpleDateFormat("dd/MM/yyyy").format(dto.getDurationFrom()));
		return new ModelAndView("updateOffer", "offer", dto);
	}

}
