package com.umang.springmvc.controller;

import java.util.ArrayList;
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
import com.umang.springmvc.entities.JData;
import com.umang.springmvc.entities.ManuscriptDetail;
import com.umang.springmvc.entities.ManuscriptHeadofPrint;
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
			 List<Employee> employeeLst = new ArrayList<Employee>();
			String otp = encription.generaeOTP();
			logger.info("Start getEmployee. ID="+empNo);
			JData dataj= new JData();
			AppUser user= new AppUser();
			System.out.println("****************************"+empNo);
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
				//int i= contactDao.insertUserData(user);
				//System.out.println("Data Inserted SuccessFully :"+i);
			}catch (Exception e) {
				dataj.setStatus("False");
				dataj.setMessage("Fail");
				dataj.setData(user);
			}
			return dataj;
		}
}
