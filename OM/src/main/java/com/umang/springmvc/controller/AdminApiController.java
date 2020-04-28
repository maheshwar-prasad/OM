package com.umang.springmvc.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.model.DeleteResponse;
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
	 *@author Maheshwar.Prasad
	 **/
	@Autowired
	 ManuscriptService manuscriptService; 
	@Autowired
	 ContactDAO contactDao;
	 AESCryptUtils encription = new AESCryptUtils();
	 private static final Logger logger = LogManager.getLogger(ManuscriptServiceImpl.class);
	 
	 
	@RequestMapping(value = { "/apiItems"}, method = RequestMethod.GET)
	public ModelAndView apiItems(ModelMap model) {
		
		ItemsResponses itemlist = null;
		List<ItemsDto> itemsList= new ArrayList<>();
		ItemsDto items = null;
		itemlist = manuscriptService.getItemDetailList("item_name", SortOrder.ASC); 
		 for(ItemsDto item:itemlist.getData()) {
			 items =  new ItemsDto();
			 items.setId(item.getId());
			 items.setItemCode(item.getItemCode());
			 items.setItemName(item.getItemName());
			 items.setDescription(item.getDescription());
			 items.setMrp(item.getMrp());
			 items.setDisplayOrder(item.getDisplayOrder());
			 items.setPack(item.getPack());
			 itemsList.add(items);
		 }
		 return new ModelAndView("apiItems", "itemList", itemsList);
		}
	@RequestMapping(value = { "/saveItem"}, method = RequestMethod.POST)
	public ModelAndView itemSave(ModelMap model,@ModelAttribute("itemDto") ItemsDto item,@RequestParam File file) {
		//System.out.println("invoiceList *********************"+file.getAbsolutePath()+"==>"+file.getAbsoluteFile());
		ItemsResponse itemResponse=  null;
		File file1 = new File(item.getItemImage());
		String imagePath = file1.getAbsolutePath();
		System.out.println("==>"+imagePath);
	try {
		item.setActive(true);
		item.setOfferType(OfferType.FU);
		item.setOfferEffectedBy(new Date());
		item.setOfferTill(new Date());
		item.setUpdatedOn(new Date());
		item.setDisplayOrder(1);
		item.setFree(1);
		//item.setOfferUnits(10);
		itemResponse = manuscriptService.getSaveItem(item); 
		
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error","Fail");
			//iteamValue.setStatus("Fail");
			 return new ModelAndView("itemCreate", "ItemsResponses", "");
			//e.printStackTrace();
		}
	if(itemResponse.getMessage().equals("success")) {
		return new ModelAndView("redirect:apiItems");
	}else {
		return new ModelAndView("itemCreate");
	}
	 //return new ModelAndView("itemCreate");
	}
	@RequestMapping(value = EmpRestURIConstants.DELETE_ITEM, method = RequestMethod.GET,produces="application/json")
	public @ResponseBody Item deleteItem(ModelMap model,@PathVariable("id") int id) {
		Item item = new Item();
		DeleteResponse response= null;
		try {
			response= manuscriptService.deleteItem(id);
			int i= 1;//contactDao.deleteItem(id);
			if(i>0) {				
				item.setStatus("Success");
			}else {
				item.setStatus("Fail");
			}
		
		}catch (Exception e) {
			item.setStatus("Fail");
			return item;
		}
		return item;
	}
	
	@RequestMapping(value = { "/offer"}, method = RequestMethod.GET)
	public ModelAndView offer(ModelMap model, @ModelAttribute ItemsDto item) {
		 
		
		 return new ModelAndView("offer", "itemList", "");
		}
	
	@RequestMapping(value = { "/saveOffer"}, method = RequestMethod.POST)
	public ModelAndView saveOffer(ModelMap model,@ModelAttribute("offerDto") OfferDto offer) {
	try {
		 System.out.println( "Offer Name : "+offer.getOfferName());
		//item.setOfferUnits(10);
		//itemResponse = manuscriptService.getSaveItem(item); 
		
		}catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error","Fail");
			//iteamValue.setStatus("Fail");
			 return new ModelAndView("itemCreate", "ItemsResponses", "");
			//e.printStackTrace();
		}
	
	return new ModelAndView("offer");
	}
}
