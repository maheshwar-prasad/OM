package com.umang.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.client.OrdersClient;
import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.common.CommonResponseDto;
import com.umang.springmvc.common.CommonResponseItemDto;
import com.umang.springmvc.common.CommonResponsesDto12;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.entities.ManuscriptDetail;
import com.umang.springmvc.entities.ManuscriptHeadofPrint;
import com.umang.springmvc.model.CustomerDto;
import com.umang.springmvc.model.CustomerResponse;
import com.umang.springmvc.model.CustomerResponses;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.ItemsDto;
import com.umang.springmvc.model.SalesOrderDto;
import com.umang.springmvc.model.SalesOrderResponses;
import com.umang.springmvc.webservices.EmpRestURIConstants;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;

@Controller
public class CustomerController {
	/**
	 *@author Maheshwar.Prasad
	 **/
	@Autowired
	 ManuscriptService manuscriptService; 
	@Autowired
	 ContactDAO contactDao;
	 AESCryptUtils encription = new AESCryptUtils();
	 private static final Logger logger = LogManager.getLogger(ManuscriptServiceImpl.class);
	 OrdersClient orderClient = new OrdersClient();
	 @RequestMapping(value = { "/customerdashboard"}, method = RequestMethod.GET)
		public String dashboard(ModelMap model)throws JsonParseException, JsonMappingException, RuntimeException, IOException  {
			List<SalesOrderDto> finalRecentArtifactList = new ArrayList<>();
			SalesOrderResponses orderResponses = orderClient.getSallerOrders(null);
			model.put("orderSize", orderResponses.getData().size());
			finalRecentArtifactList = orderResponses.getData().stream().limit(6).collect(Collectors.toList());
			model.put("orderList", finalRecentArtifactList);
			return "customerdashboard";
		}
	 @RequestMapping(value = { "/apiCustomer"}, method = RequestMethod.GET)
		public ModelAndView customer(ModelMap model) {
			System.out.println("***********Customer List***********");
			CustomerResponses customerResponses= null;
			customerResponses = manuscriptService.getCustomerDetails("shop_name", SortOrder.ASC);
			 return new ModelAndView("apiCustomer", "customerResponses", customerResponses);

			}
	 @RequestMapping(value = { "/apiCustomerCreate"}, method = RequestMethod.GET)
		public ModelAndView apiCustomerCreate(ModelMap model) {
			System.out.println("**********************");
			 return new ModelAndView("apiCustomerCreate", "customer", "");

			}
	@RequestMapping(value = { "/createCustomer"}, method = RequestMethod.GET)
	public ModelAndView apiItems(ModelMap model) {
		System.out.println("**********************88");
		 return new ModelAndView("createCustomer", "create", "");

		}
	@RequestMapping(value = { "/shippingAddress"}, method = RequestMethod.GET)
	public ModelAndView shippingAddress(ModelMap model) {
		System.out.println("**********************88");
		 return new ModelAndView("shippingAddress", "create", "");

		}
	
	@RequestMapping(value = { "/saveCustomer"}, method = RequestMethod.POST)
	public @ResponseBody AppUser  saveCustomer(ModelMap model,@RequestBody AppUser appuser) {
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
			int i= contactDao.insertUserData(user);
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

		}
	@RequestMapping(value = EmpRestURIConstants.DELETE_CUSTOMER, method = RequestMethod.GET,produces="application/json")
	public @ResponseBody Item deleteItem(ModelMap model,@PathVariable("custid") int id) {
		Item item = new Item();
		DeleteResponse response= null;
		try {
			response= manuscriptService.deleteCust(id);
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
	
}
