package com.umang.springmvc.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.client.ItemsClient;
import com.umang.springmvc.client.OfferClient;
import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.model.FileUploadResponse;
import com.umang.springmvc.model.OfferDto;
import com.umang.springmvc.model.OfferResponse;
import com.umang.springmvc.model.PurchaseType;

@Controller
public class OfferController {

	private OfferClient offerClient = new OfferClient();

	private ItemsClient ItemClient = new ItemsClient();

	@RequestMapping(value = { "/offer" }, method = RequestMethod.GET)
	public ModelAndView offer(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		Integer routing = (user == null ? null : user.getRouting());
		if (user.getUserType().equalsIgnoreCase("Client"))
			return new ModelAndView("clientOffer", "offer", new OfferDto());
		else
			return new ModelAndView("offer", "offer", new OfferDto());
	}

	@RequestMapping(value = { "/saveOffer" }, method = RequestMethod.POST)
	public ModelAndView saveOffer(ModelMap model, @RequestParam("article") String article,
			@RequestParam("type") PurchaseType type, @RequestParam("purchase") Integer purchase,
			@RequestParam("status") Boolean status,
			@RequestParam(value = "durationFrom", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date durationFrom,
			@RequestParam(value = "durationTo", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date durationTo,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) throws MalformedURLException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		String path = request.getServletContext().getResource("static").getFile();
		File image = new File(path + "/img/item/" + file.getOriginalFilename());
		Integer routing = (user == null ? null : user.getRouting());
		try (FileOutputStream fileOutputStream = new FileOutputStream(image)) {
			fileOutputStream.write(file.getBytes());
			OfferDto offer = new OfferDto();
			offer.setActive(status);
			offer.setArticle(article);
			offer.setDurationFrom(durationFrom);
			offer.setDurationTo(durationTo);
			offer.setPurchase(purchase);
			offer.setType(type);
			OfferResponse response = offerClient.save(offer, routing);
			fileOutputStream.flush();
			FileUploadResponse fileRes = offerClient.postItemImage(response.getData().getId(), image, routing);
			File rename = new File(path + "/img/item/" + fileRes.getData().getFileKey());
			image.renameTo(rename);
			image.delete();
			model.put("status", "success");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail");
		}

		return new ModelAndView("redirect:offers");
	}

	@RequestMapping(value = { "/updateOffer" }, method = RequestMethod.POST)
	public ModelAndView updateOffer(ModelMap model, @RequestParam("id") Integer id,
			@RequestParam("article") String article, @RequestParam("type") PurchaseType type,
			@RequestParam("purchase") Integer purchase, @RequestParam("status") Boolean status,
			@RequestParam(value = "durationFrom", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date durationFrom,
			@RequestParam(value = "durationTo", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date durationTo,
			@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		Integer routing = (user == null ? null : user.getRouting());
		FileOutputStream fileOutputStream = null;
		String path = request.getServletContext().getResource("static").getFile();
		File image = null;
		if (file != null && file.getSize() > 0) {
			image = new File(path + "/img/item/" + file.getOriginalFilename());
			fileOutputStream = new FileOutputStream(image);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.flush();
			offerClient.postItemImage(id, image, routing);
			image.delete();
		}
		try {
			OfferDto offer = new OfferDto();
			offer.setActive(status);
			offer.setArticle(article);
			offer.setDurationFrom(durationFrom);
			offer.setDurationTo(durationTo);
			offer.setPurchase(purchase);
			offer.setType(type);
			OfferResponse response = offerClient.save(offer, routing);
			model.put("status", "success");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "Fail");
		}

		return new ModelAndView("redirect:offers");
	}

	@RequestMapping(value = { "/offers" }, method = RequestMethod.GET)
	public ModelAndView offers(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		model.put("offer_list", offerClient
				.findAllSorted("offer_name", SortOrder.ASC, (user == null ? null : user.getRouting())).getData());
		if (user.getUserType().equalsIgnoreCase("Client"))
			return new ModelAndView("clientOfferList", "offer", new OfferDto());
		else
			return new ModelAndView("offerList", "offer", new OfferDto());
	}

	@RequestMapping(value = { "/delete-offer" }, method = RequestMethod.GET)
	public ModelAndView deleteOffer(ModelMap model, @RequestParam("id") Integer id, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		offerClient.delete(id, (user == null ? null : user.getRouting()));
		model.put("offer_list", offerClient
				.findAllSorted("offer_name", SortOrder.ASC, (user == null ? null : user.getRouting())).getData());
		if (user.getUserType().equalsIgnoreCase("Client"))
			return new ModelAndView("clientOfferList", "offer", new OfferDto());
		else
			return new ModelAndView("offerList", "offer", new OfferDto());
	}

	@RequestMapping(value = { "/get-offer" }, method = RequestMethod.GET)
	public ModelAndView offer(ModelMap model, @RequestParam("id") Integer id, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		OfferDto dto = offerClient.findById(id, (user == null ? null : user.getRouting())).getData();
		model.put("fromDate", new SimpleDateFormat("dd/MM/yyyy").format(dto.getDurationFrom()));
		model.put("toDate", new SimpleDateFormat("dd/MM/yyyy").format(dto.getDurationTo()));
		if (user.getUserType().equalsIgnoreCase("Client"))
			return new ModelAndView("clientUpdateOffer", "offer", dto);
		else
			return new ModelAndView("updateOffer", "offer", dto);
	}

}
