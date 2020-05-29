package com.umang.springmvc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.client.OrdersClient;
import com.umang.springmvc.client.SalesOrderClient;
import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.AppUser;
import com.umang.springmvc.model.CancelOrder;
import com.umang.springmvc.model.OrderStatus;
import com.umang.springmvc.model.SalesOrderDto;
import com.umang.springmvc.model.SalesOrderResponses;
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

	SalesOrderClient salesOrderClient = new SalesOrderClient();

	@RequestMapping(value = { "/order" }, method = RequestMethod.GET)
	public ModelAndView order(ModelMap model, HttpServletRequest request)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null, (user == null ? null : user.getRouting()));
		return new ModelAndView("order", "orderList", orderResponses.getData());

	}

	@RequestMapping(value = { "/orderDetails" }, method = RequestMethod.GET)
	public ModelAndView orderDetails(ModelMap model, @RequestParam("order-number") String orderNumber,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null, (user == null ? null : user.getRouting()));
		List<SalesOrderDto> dtos = orderResponses.getData();
		model.put("orderDetail",
				dtos.parallelStream().filter(ORD -> ORD.getOrderNumber().equals(orderNumber)).findFirst().get());

		return new ModelAndView("orderDetails", "salesOrder", new SalesOrderDto());

	}

	@RequestMapping(value = { "/cancelOrder" }, method = RequestMethod.GET)
	public ModelAndView cancelOrder(ModelMap model, @RequestParam("order-number") String orderNumber,
			@RequestParam(value = "remarks", required = false, defaultValue = "Cancelled") String remarks,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		CancelOrder cancelOrder = new CancelOrder();
		cancelOrder.setOrderNo(orderNumber);
		cancelOrder.setRemarks(remarks);

		model.put("orderDetail", orderClient.cancelOrder(cancelOrder, (user == null ? null : user.getRouting())).getData());
		return new ModelAndView("orderDetails", "salesOrder", new SalesOrderDto());

	}

	@RequestMapping(value = { "/acceptOrder" }, method = RequestMethod.GET)
	public ModelAndView acceptOrder(ModelMap model, @RequestParam("order-number") String orderNumber,
			@RequestParam(value = "remarks", required = false, defaultValue = "Accepted") String remarks,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null, (user == null ? null : user.getRouting()));
		List<SalesOrderDto> dtos = orderResponses.getData();
		SalesOrderDto dto = dtos.parallelStream().filter(ORD -> ORD.getOrderNumber().equals(orderNumber)).findFirst()
				.get();
		dto.setAcceptedOn(new Date());
		dto.setRemark(remarks);
		dto.setOrderStatus(OrderStatus.A);
		model.put("orderDetail", salesOrderClient.update(dto, (user == null ? null : user.getRouting())).getData());
		return new ModelAndView("orderDetails", "salesOrder", new SalesOrderDto());

	}

	@RequestMapping(value = { "/markDelivered" }, method = RequestMethod.GET)
	public ModelAndView markDiliver(ModelMap model, @RequestParam("order-number") String orderNumber,
			@RequestParam(value = "remarks", required = false, defaultValue = "Dilivered") String remarks,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null, (user == null ? null : user.getRouting()));
		List<SalesOrderDto> dtos = orderResponses.getData();
		SalesOrderDto dto = dtos.parallelStream().filter(ORD -> ORD.getOrderNumber().equals(orderNumber)).findFirst()
				.get();
		dto.setDeliveredOn(new Date());
		dto.setRemark(remarks);
		dto.setOrderStatus(OrderStatus.D);
		model.put("orderDetail", salesOrderClient.update(dto, (user == null ? null : user.getRouting())).getData());
		return new ModelAndView("orderDetails", "salesOrder", new SalesOrderDto());

	}

	@RequestMapping(value = { "/deleteOrder" }, method = RequestMethod.GET)
	public ModelAndView deleteOrder(ModelMap model, @RequestParam("order-number") String orderNumber,
			HttpServletRequest request) throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		AppUser user = (AppUser) request.getSession().getAttribute("user");
		SalesOrderResponses orderResponses = orderClient.getSallerOrders(null, (user == null ? null : user.getRouting()));
		List<SalesOrderDto> dtos = orderResponses.getData();
		SalesOrderDto dto = dtos.parallelStream().filter(ORD -> ORD.getOrderNumber().equals(orderNumber)).findFirst()
				.get();
		salesOrderClient.delete(dto.getId(), (user == null ? null : user.getRouting()));
		return new ModelAndView("redirect:order");

	}

}
