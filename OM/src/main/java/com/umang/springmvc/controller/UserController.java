package com.umang.springmvc.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
}
