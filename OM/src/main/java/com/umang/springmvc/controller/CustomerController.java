package com.umang.springmvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.model.CustomerResponses;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.SalesOrderDto;
import com.umang.springmvc.model.SalesOrderResponses;
import com.umang.springmvc.model.SallerProfileDto;
import com.umang.springmvc.model.SallerProfileResponses;
import com.umang.springmvc.webservices.EmpRestURIConstants;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;

@Controller
public class CustomerController {
	/**
	 * @author Maheshwar.Prasad
	 **/
	@Autowired
	ManuscriptService manuscriptService;
	@Autowired
	ContactDAO contactDao;
	AESCryptUtils encription = new AESCryptUtils();
	private static final Logger logger = LogManager.getLogger(ManuscriptServiceImpl.class);
	OrdersClient orderClient = new OrdersClient();

	@RequestMapping(value = { "/customerdashboard" }, method = RequestMethod.GET)
	public String dashboard(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		List<SalesOrderDto> finalRecentArtifactList = new ArrayList<>();
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null, (user == null ? null : user.getRouting()));
		model.put("orderSize", orderResponses.getData().size());
		finalRecentArtifactList = orderResponses.getData().stream().limit(6).collect(Collectors.toList());
		model.put("orderList", finalRecentArtifactList);
		return "customerdashboard";
	}

	@RequestMapping(value = { "/apiCustomer" }, method = RequestMethod.GET)
	public ModelAndView customer(ModelMap model, HttpServletRequest request) {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		CustomerResponses customerResponses = null;
		customerResponses = manuscriptService.getCustomerDetails("shop_name", SortOrder.ASC, (user == null ? null : user.getRouting()));
		return new ModelAndView("apiCustomer", "customerResponses", customerResponses);

	}

	@RequestMapping(value = { "/apiCustomerCreate" }, method = RequestMethod.GET)
	public ModelAndView apiCustomerCreate(ModelMap model) {
		System.out.println("**********************");
		return new ModelAndView("apiCustomerCreate", "customer", "");

	}

	@RequestMapping(value = { "/createCustomer" }, method = RequestMethod.GET)
	public ModelAndView apiItems(ModelMap model) {
		System.out.println("**********************88");
		return new ModelAndView("createCustomer", "create", "");

	}

	@RequestMapping(value = { "/shippingAddress" }, method = RequestMethod.GET)
	public ModelAndView shippingAddress(ModelMap model) {
		System.out.println("**********************88");
		return new ModelAndView("shippingAddress", "create", "");

	}

	@RequestMapping(value = { "/saveCustomer" }, method = RequestMethod.POST)
	public @ResponseBody AppUser saveCustomer(ModelMap model, @RequestBody AppUser appuser) {
		logger.info(" Create User *********************");
		String otp = encription.generaeOTP();
		logger.info("Start getEmployee. id =" + appuser.getUsername());
		AppUser user = new AppUser();
		try {
			user.setOTP(otp);
			user.setUsername(appuser.getUsername());
			user.setName(appuser.getName());
			user.setAddress1(appuser.getAddress1());
			user.setStatus("1");
			user.setPassword(encription.encrypt(appuser.getUsername()));
			user.setUserType(appuser.getUserType());
			user.setCompanyName(appuser.getCompanyName());
			if(appuser.getUserType().equals("Client")) {
				user.setRouting(8118);	
			}else {
				user.setRouting(8119);
			}
			
			int i = contactDao.insertUserData(user);
			logger.info("Data Inserted SuccessFully :" + i);
			if (i > 0) {
				user.setStatus("Success");
			} else {
				user.setStatus("Record already available");
			}
		} catch (Exception e) {
			user.setStatus("Some Issue");
			return user;
		}
		appuser.setStatus("Success");
		return user;

	}

	@RequestMapping(value = EmpRestURIConstants.DELETE_CUSTOMER, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Item deleteItem(ModelMap model, @PathVariable("custid") int id, HttpServletRequest request) {
		Item item = new Item();
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		DeleteResponse response = null;
		try {
			response = manuscriptService.deleteCust(id, (user == null ? null : user.getRouting()));
			int i = 1;// contactDao.deleteItem(id);
			if (i > 0) {
				item.setStatus("Success");
			} else {
				item.setStatus("Fail");
			}

		} catch (Exception e) {
			item.setStatus("Fail");
			return item;
		}
		return item;
	}

	@RequestMapping(value = { "/member" }, method = RequestMethod.GET)
	public ModelAndView member(ModelMap model) {
		System.out.println("**********  Member************");
		return new ModelAndView("member", "member", "");
	}

	@RequestMapping(value = { "/userPermission" }, method = RequestMethod.GET)
	public ModelAndView userPermission(ModelMap model) {
		System.out.println("**********  userPermission************");
		List<AppUser> users = contactDao.userList();
		return new ModelAndView("userPermission", "userList", users);
	}

	@RequestMapping(value = EmpRestURIConstants.updateUserPermission, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody AppUser createUser(ModelMap model, @PathVariable("userId") String userId,
			@PathVariable("status") String status, @PathVariable("routing") Integer routing) {
		logger.info(" Create User *********************");
		String otp = encription.generaeOTP();
		logger.info("Start User id =" + userId);
		AppUser user = new AppUser();
		try {

			int i = contactDao.updateUserData(Long.parseLong(userId), status, routing);
			logger.info("Data Inserted SuccessFully :" + i);
			if (i > 0) {
				user.setStatus("Success");
			} else {
				user.setStatus("Fail");
			}
		} catch (Exception e) {
			// e.printStackTrace();
			user.setStatus("Fail");
			return user;
		}
		return user;
	}
	@RequestMapping(value = { "/executive" }, method = RequestMethod.GET)
	public ModelAndView executive(ModelMap model) {
		
		return new ModelAndView("executiveList", "executiveList", "");
	}
	@RequestMapping(value = "/createExecutive", method = RequestMethod.GET)
	public ModelAndView createExecutive(HttpServletRequest request, Model model)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		/*AppUser user = (AppUser) request.getSession().getAttribute("user");
		SallerProfileResponses responses = client.findAllSorted("first_name", SortOrder.ASC,
				(user == null ? null : user.getRouting()));
		List<SallerProfileDto> dtos = responses.getData();
		if (user.getUserType().equals("Client"))
			return new ModelAndView("clientprofile", "profile", dtos.size() > 0 ? dtos.get(0) : new SallerProfileDto());
		else
			return new ModelAndView("customerprofile", "profile",
					dtos.size() > 0 ? dtos.get(0) : new SallerProfileDto());
	}*/
		return new ModelAndView("createExecutive", "createExecutive","");
	}
	
	@RequestMapping(value = { "/assignOrder" }, method = RequestMethod.GET)
	public ModelAndView assignOrder(ModelMap model) {
		
		return new ModelAndView("assignOrder", "assignOrder", "");
	}
	@RequestMapping(value = { "/assigneeList" }, method = RequestMethod.GET)
	public ModelAndView assigneeList(ModelMap model) {
		
		return new ModelAndView("assigneeList", "assigneeList", "");
	}
}
