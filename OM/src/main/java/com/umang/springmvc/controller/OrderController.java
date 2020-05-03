package com.umang.springmvc.controller;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.client.OrdersClient;
import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.model.CancelOrder;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.SalesOrderDto;
import com.umang.springmvc.model.SalesOrderResponse;
import com.umang.springmvc.model.SalesOrderResponses;
import com.umang.springmvc.webservices.EmpRestURIConstants;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;

@Controller
public class OrderController {
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

	@RequestMapping(value = { "/order" }, method = RequestMethod.GET)
	public ModelAndView order(ModelMap model)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null);
		return new ModelAndView("order", "orderList", orderResponses.getData());

	}

	@RequestMapping(value = { "/orderDetails" }, method = RequestMethod.GET)
	public ModelAndView orderDetails(ModelMap model, @RequestParam("order-number") String orderNumber)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null);
		List<SalesOrderDto> dtos = orderResponses.getData();
		model.put("orderDetail",
				dtos.parallelStream().filter(ORD -> ORD.getOrderNumber().equals(orderNumber)).findFirst().get());

		return new ModelAndView("order", "orderList", dtos);

	}

	@RequestMapping(value = EmpRestURIConstants.DELETE_ORDER, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Item deleteOrder(ModelMap model, @PathVariable("id") int id) {
		Item item = new Item();
		DeleteResponse response = null;
		try {
			response = manuscriptService.deleteOrder(id);
			int i = 1;// contactDao.deleteItem(id);
			if (response.getMessage().equals("success")) {
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

	@RequestMapping(value = EmpRestURIConstants.CANCEL_ORDER, method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Item cancelOrder(ModelMap model, @PathVariable("orderNo") String orderNo) {
		Item item = new Item();
		SalesOrderResponse response = null;
		CancelOrder cancelOrder = new CancelOrder();
		cancelOrder.setOrderNo(orderNo);
		cancelOrder.setRemarks("Delete Selected Order due to some Item issue");
		try {
			response = manuscriptService.cancelOrder(cancelOrder);
			int i = 1;// contactDao.deleteItem(id);
			if (response.getMessage().equals("success")) {
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

	@RequestMapping(value = "/qqq", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView shippingAddress(ModelMap model, @PathVariable("orderNo") String orderNo) {

		return new ModelAndView("shippingAddress", "shippingAddress", "");
	}
	/*
	 * @RequestMapping(value = "/shippingAddress", method =
	 * RequestMethod.GET,produces="application/json") public @ResponseBody Item
	 * shippingAddress(ModelMap model,@PathVariable("orderNo") String orderNo) {
	 * Item item = new Item(); SalesOrderResponse response= null; CancelOrder
	 * cancelOrder= new CancelOrder(); cancelOrder.setOrderNo(orderNo);
	 * cancelOrder.setRemarks("Delete Selected Order due to some Item issue"); try {
	 * response= manuscriptService.cancelOrder(cancelOrder); int i=
	 * 1;//contactDao.deleteItem(id); if(response.getMessage().equals("success")) {
	 * item.setStatus("Success"); }else { item.setStatus("Fail"); }
	 * 
	 * }catch (Exception e) { item.setStatus("Fail"); return item; } return item; }
	 */

}
