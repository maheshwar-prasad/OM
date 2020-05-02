package com.umang.springmvc.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ctc.wstx.util.StringUtil;
import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.common.CommonResponseDto;
import com.umang.springmvc.common.CommonResponseItemDto;
import com.umang.springmvc.common.CommonResponsesDto12;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.entities.ItemType;
import com.umang.springmvc.entities.JData;
import com.umang.springmvc.entities.ManuscriptDetail;
import com.umang.springmvc.entities.ManuscriptHeadofPrint;
import com.umang.springmvc.entities.addCartResponse;
import com.umang.springmvc.model.AddCart;
import com.umang.springmvc.model.OfferForm;
import com.umang.springmvc.webservices.EmpRestURIConstants;
import com.umang.springmvc.webservices.Employee;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;

@Controller
public class ApiController {
	/**
	 *@author Maheshwar.Prasad
	 **/
	@Autowired
	 ManuscriptService manuscriptService; 
	@Autowired
	 ContactDAO contactDao;
	 AESCryptUtils encription = new AESCryptUtils();
	 private static final Logger logger = LogManager.getLogger(ManuscriptServiceImpl.class);
	 
	 @RequestMapping(value = EmpRestURIConstants.GET_USR, method = RequestMethod.GET,produces="application/json")
		public @ResponseBody JData getJsonData(@PathVariable("id") String empNo) {
			String otp = encription.generaeOTP();
			logger.info("Start getEmployee. ID="+empNo);
			JData dataj= new JData();
			AppUser user= new AppUser();
			try {
				user= contactDao.getUser(empNo,"");
				if(user == null) {
					user= new AppUser();
					user.setOTP(otp);
					user.setUsername(empNo);
					user.setPassword(encription.encrypt(empNo));
					user.setStatus("1");
					int i= contactDao.insertUserData(user);
					user= new AppUser();
					user= contactDao.getUser(empNo,otp);
				}
				dataj.setStatus("true");
				dataj.setMessage("Success");
				dataj.setData(user);
			}catch (Exception e) {
				dataj.setStatus("False");
				dataj.setMessage("Fail");
				dataj.setData(user);
			}
			return dataj;
		}
	 
	 @RequestMapping(value ="/addCart", method = RequestMethod.POST,produces="application/json")
	public @ResponseBody addCartResponse addcart(@RequestBody AddCart addCart ,HttpServletResponse response, HttpServletRequest request ) {  
			addCartResponse dataj= new addCartResponse();
			Cookie c[]=request.getCookies(); 
			HttpSession objHttpSession = request.getSession(true);
			Object obj =  objHttpSession.getAttribute("user");
			AppUser user= (AppUser)obj;
			try {
				if(user == null) {
					user= new AppUser();
					user.setUser_id(0);
				}
				addCart.setSessionCode(c[0].getValue());
				addCart.setUserId(user.getUser_id());
				int i= contactDao.insertCartData(addCart);
				List<AddCart> cardlist =  contactDao.fetchAllAddValue(addCart.getSessionCode(),user.getUser_id(),"N", addCart.getProductId());
				dataj.setStatus("Success");
				dataj.setMessage("Success");
				dataj.setAddcartData(cardlist);
				dataj.setCount(cardlist.size());
				double total  = 0.0;
				double th=0.0;
				double b= 0.0;
				if(cardlist.size()>0) {
					 for(int j=0; j<cardlist.size(); j++) {
						 th= total;
						 b = cardlist.get(j).getPrice();
						 total  =Double.sum(th,b);  
						
					 }
					 dataj.setTotalamount(total);
				}
			}catch (Exception e) {
				dataj.setStatus("False");
				dataj.setMessage("Fail");
			}
			return dataj;
		}
	 
	 @RequestMapping(value ="/showCart", method = RequestMethod.POST,produces="application/json")
	 public @ResponseBody addCartResponse showcart(ModelMap model  ,HttpServletResponse response, HttpServletRequest request ) {  
			addCartResponse dataj= new addCartResponse();
			HttpSession objHttpSession = request.getSession(true);
			Object obj =  objHttpSession.getAttribute("user");
			AppUser user= (AppUser)obj;
			Cookie c[]=request.getCookies(); 
			AddCart addCart = new AddCart();			
			try {
				addCart.setSessionCode(c[0].getValue());
				if(user != null) {
					dataj.setUser(user);	
				}else {
					user = new AppUser();
					user.setName("Login");
					dataj.setUser(user);		
				}
				List<AddCart> cardlist =  contactDao.fetchAllAddValue(addCart.getSessionCode(),0l,"N",addCart.getProductId());
				dataj.setStatus("Success");
				dataj.setMessage("Success");
				dataj.setAddcartData(cardlist);
				dataj.setCount(cardlist.size());
				double total  = 0.0;
				double th=0.0;
				double b= 0.0;
				if(cardlist.size()>0) {
					 for(int i=0; i<cardlist.size(); i++) {
						 th= total;
						 b = cardlist.get(i).getPrice();
						 total  =Double.sum(th,b);   
						
					 }
					 dataj.setTotalamount(total);
				}
			}catch (Exception e) {
				dataj.setStatus("False");
				dataj.setMessage("Fail");
			}
			return dataj;
		}
	 @RequestMapping(value = EmpRestURIConstants.DELETE_CARD, method = RequestMethod.GET,produces="application/json")
		public @ResponseBody addCartResponse deleteCart(ModelMap model,@PathVariable("cartId") int itemid,HttpServletResponse response, HttpServletRequest request ) {
		 logger.info(" Delete Cart *********************");
		 HttpSession objHttpSession = request.getSession(true);	
		 addCartResponse dataj= new addCartResponse();
			Cookie c[]=request.getCookies(); 
			AddCart addCart = new AddCart();
			Object obj =  objHttpSession.getAttribute("user");
			AppUser user= (AppUser)obj;
			try {
				addCart.setSessionCode(c[0].getValue());
				if(user!= null) {
					dataj.setUser(user);
				}else {
					user= new AppUser();
					user.setName("Login");
					dataj.setUser(user);
					user.setUser_id(0);
				}
				List<AddCart> cardlist =  contactDao.fetchAllAddValue(addCart.getSessionCode(),user.getUser_id(), "Y",itemid);
				dataj.setStatus("Success");
				dataj.setMessage("Success");
				dataj.setAddcartData(cardlist);
				dataj.setCount(cardlist.size());
				double total  = 0.0;
				double th=0.0;
				double b= 0.0;
				if(cardlist.size()>0) {
					 for(int i=0; i<cardlist.size(); i++) {
						 th= total;
						 b = cardlist.get(i).getPrice();
						 total  =Double.sum(th,b);  
						
					 }
					 dataj.setTotalamount(total);
				}
			}catch (Exception e) {
				dataj.setStatus("False");
				dataj.setMessage("Fail");
			}
			return dataj;
		}
	}
