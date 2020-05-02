package com.umang.springmvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.common.CommonResponseDto;
import com.umang.springmvc.common.CommonResponseItemDto;
import com.umang.springmvc.common.CommonResponsesDto12;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.entities.ManuscriptDetail;
import com.umang.springmvc.entities.ManuscriptHeadofPrint;
import com.umang.springmvc.entities.addCartResponse;
import com.umang.springmvc.model.AddCart;
import com.umang.springmvc.webservices.EmpRestURIConstants;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;

@Controller
public class UserController {
	/**
	 *@author Maheshwar.Prasad
	 **/
	@Autowired
	 ManuscriptService manuscriptService; 
	@Autowired
	 ContactDAO contactDao;
	 AESCryptUtils encription = new AESCryptUtils();
	 private static final Logger logger = LogManager.getLogger(ManuscriptServiceImpl.class);
	 
	 @RequestMapping(value = EmpRestURIConstants.GET_USRCREATE, method = RequestMethod.GET,produces="application/json")
		public @ResponseBody AppUser createUser(ModelMap model,@PathVariable("mobNo") String mobNo,@PathVariable("userType") String custType,@PathVariable("name") String name,@PathVariable("address") String address) {
			logger.info(" Create User *********************");
			String otp = encription.generaeOTP();
			logger.info("Start getEmployee. id ="+mobNo);
			AppUser user= new AppUser();
			try {
				user.setOTP(otp);
				user.setUsername(mobNo);
				user.setName(name);
				user.setAddress1(address);
				user.setStatus("1");
				user.setPassword(encription.encrypt(mobNo));
				user.setUserType(custType);
				int i= contactDao.insertUserData(user);
				logger.info("Data Inserted SuccessFully :"+i);
				if(i>0) {
					user.setStatus("Success");
				}else {
					user.setStatus("Fail");
				}
			}catch (Exception e) {
				//e.printStackTrace();
				user.setStatus("Fail");
				return user;
			}
			return user;
		} 
	 @RequestMapping(value = EmpRestURIConstants.EDIT_USR, method = RequestMethod.GET)
		public ModelAndView editUser(ModelMap model,@PathVariable("id") int id) {
		 logger.info(" editUser *********************");
			AppUser user= new AppUser();
			try {
				user= contactDao.getUserById(id, "");
			}catch (Exception e) {
				e.printStackTrace();
			}
			//return "createUser";
			return new ModelAndView("createUser", "user", user);
		}
	 @RequestMapping(value = { "/activeUser"}, method = RequestMethod.GET)
		public ModelAndView activeUserList(ModelMap model) {
		 logger.info("activeUser *********************");
			List<AppUser> users = contactDao.userList();
			
			if(null != users && users.size() > 0) {
				
				for (AppUser u : users) {
					System.out.printf("%s \t %s \n", u.getUser_id(), u.getUsername());
				}
			}
			return new ModelAndView("activeUser", "userList", users);
		}
	 // Web User login 
	 @RequestMapping(value ="/webusrLogin", method = RequestMethod.POST,produces="application/json")
		public @ResponseBody addCartResponse webusrLogin(@RequestBody AppUser user ,HttpServletResponse response, HttpServletRequest request,HttpSession session  ) {  
				addCartResponse dataj= new addCartResponse();
				Cookie c[]=request.getCookies(); 
				AddCart addCart = new AddCart();
				String password=encription.encrypt(user.getPassword());
				String username= user.getUsername();
				List<AddCart> cardlist = new ArrayList<AddCart>();
				try {
					AppUser userDetais= contactDao.getUserLogin(user.getEmail(),password);
					if(userDetais.getStatus().equals("Success")) {
						session.setAttribute("user", userDetais);
						cardlist =  contactDao.fetchAllAddValue(addCart.getSessionCode(),userDetais.getUser_id(),"N", addCart.getProductId());
						dataj.setUser(userDetais);
					}else {
						addCart.setSessionCode(c[0].getValue());
						cardlist =  contactDao.fetchAllAddValue(addCart.getSessionCode(),0l,"N", addCart.getProductId());
					}

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
	 
	 // Web User login 
	 @SuppressWarnings("unused")
	@RequestMapping(value ="/webusrReg", method = RequestMethod.POST,produces="application/json")
		public @ResponseBody addCartResponse webusrReg(@RequestBody AppUser user ,HttpServletResponse response, HttpServletRequest request,HttpSession session ) {  
				addCartResponse dataj= new addCartResponse();
				Cookie c[]=request.getCookies(); 
				AddCart addCart = new AddCart();
				String otp = encription.generaeOTP();
				List<AddCart> cardlist = new ArrayList<AddCart>();
				try {
					AppUser userDetail= new AppUser();
					userDetail.setEmail(user.getEmail());
					userDetail.setUsername(user.getUsername());
					userDetail.setName(user.getName());
					userDetail.setStatus("1");
					userDetail.setOTP(otp);
					userDetail.setPhone(user.getPhone());
					userDetail.setPassword(encription.encrypt(user.getPassword()));
					userDetail.setUserType("WebUser");
					AppUser users= contactDao.insertWebUser(userDetail);
						logger.info("Data Inserted SuccessFully :"+users.getUsername());
						if(users != null) {
							session.setAttribute("user", users);
							users.setStatus("Success");
							cardlist =  contactDao.fetchAllAddValue(addCart.getSessionCode(),users.getUser_id(),"N", 0);
							dataj.setUser(users);
						}else {
							users.setStatus("Fail");
							addCart.setSessionCode(c[0].getValue());
							cardlist =  contactDao.fetchAllAddValue(addCart.getSessionCode(),0l,"N", 0);
						}
					
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
}
