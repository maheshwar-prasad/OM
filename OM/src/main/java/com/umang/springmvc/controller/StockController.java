package com.umang.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.umang.springmvc.client.OrdersClient;
import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.model.ItemsDto;
import com.umang.springmvc.model.ItemsResponses;
import com.umang.springmvc.model.OrdersDto;
import com.umang.springmvc.model.OrdersResponses;
import com.umang.springmvc.model.StockDto;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;

@Controller
public class StockController {
	/**
	 *@author Maheshwar.Prasad
	 **/
	@Autowired
	 ManuscriptService manuscriptService; 
	@Autowired
	 ContactDAO contactDao;
	 AESCryptUtils encription = new AESCryptUtils();
	 private static final Logger logger = LogManager.getLogger(ManuscriptServiceImpl.class);
	 OrdersClient client = new OrdersClient();
	// Stock 
		@RequestMapping(value = { "/stock"}, method = RequestMethod.GET)
		public ModelAndView stocks(ModelMap model) {
			
			 return new ModelAndView("stock", "stockList", "stockList");

			}
		
		/*@RequestMapping(value = { "/saveStock"}, method = RequestMethod.POST)
		public @ResponseBody AppUser  saveStock(ModelMap model,@RequestBody AppUser appuser) {
			System.out.println("*************88");
			logger.info(" Create User *********************");
			String otp = encription.generaeOTP();
			logger.info("Start getEmployee. id ="+appuser.getUsername());
			AppUser user= new AppUser();
			try {
				user.setOTP(otp);
				user.setUsername(appuser.getUsername());
				user.setName(appuser.getName());
				user.setAddress1(appuser.getAddress1());
				user.setStatus("1");
				user.setPassword(encription.encrypt(appuser.getUsername()));
				user.setUserType(appuser.getUserType());
				user.setCompanyName(appuser.getCompanyName());
				int i= 0;//contactDao.insertUserData(user);
				logger.info("Data Inserted SuccessFully :"+i);
				if(i>0) {
					user.setStatus("Success");
				}else {
					user.setStatus("Record already available");
				}
			}catch (Exception e) {
				//e.printStackTrace();
				user.setStatus("Some Issue");
				return user;
			}
			appuser.setStatus("Success");
			 return user;

			}*/
		@RequestMapping(value = { "/creatStock"}, method = RequestMethod.GET)
		public ModelAndView creatStock(ModelMap model) {
			ItemsResponses itemlist = null;
			List<ItemsDto> itemsList= new ArrayList<>();
			ItemsDto items = null;
			itemlist = manuscriptService.getItemDetailList("item_name", SortOrder.ASC); 
			if (itemlist != null ) {
				itemlist.getData().stream().forEach(item -> {
					item.setPack("");
					
				});
			}
			 /*for(ItemsDto item:itemlist.getData()) {
				 items =  new ItemsDto();
				 items.setId(item.getId());
				 items.setItemCode(item.getItemCode());
				 items.setItemName(item.getItemName());
				 items.setDescription(item.getDescription());
				 items.setMrp(item.getMrp());
				 items.setDisplayOrder(item.getDisplayOrder());
				 items.setPack(item.getPack());
				 itemsList.add(items);
			 }*/
			 return new ModelAndView("creatStock", "ItemsResponses", itemlist);
		}

		@RequestMapping(value = { "/saveStock"}, method = RequestMethod.POST)
		public ModelAndView saveStock(@ModelAttribute("itemDto") ItemsResponses response) {
			 System.out.println("===>"+response);
			 System.out.println(""+response.getData().size());
			 StockDto stock = null;
			 List<StockDto> stockList= new ArrayList<StockDto>();
			 for(ItemsDto item:response.getData()) {
				 stock= new StockDto();
				 stock.setDto(item);
				 stock.setQty(Integer.parseInt(item.getPack()));
				 stockList.add(stock);
			 }
				//response= manuscriptService.findAllSorted("item_name", SortOrder.ASC);
			 return new ModelAndView("creatStock", "ItemsResponses", response);

			}
}
