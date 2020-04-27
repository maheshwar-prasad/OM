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

import com.umang.springmvc.client.OrdersClient;
import com.umang.springmvc.client.SortOrder;
import com.umang.springmvc.common.AESCryptUtils;
import com.umang.springmvc.dao.ContactDAO;
import com.umang.springmvc.entities.Item;
import com.umang.springmvc.model.CancelOrder;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.OrdersDto;
import com.umang.springmvc.model.OrdersResponses;
import com.umang.springmvc.model.SalesOrderResponse;
import com.umang.springmvc.webservices.EmpRestURIConstants;
import com.umang.springmvc.webservices.ManuscriptService;
import com.umang.springmvc.webservices.ManuscriptServiceImpl;

@Controller
public class OrderController {
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
	 
	 @RequestMapping(value = { "/order"}, method = RequestMethod.GET)
		public ModelAndView order(ModelMap model) {
			System.out.println("**********************Order **********************");
			
			OrdersResponses response = null;
			OrdersDto orders= null;
			List<OrdersDto> orderList= new ArrayList<OrdersDto>();
			response= manuscriptService.findAllSorted("item_name", SortOrder.ASC);
			for(OrdersDto order:response.getData()) {
				orders= new OrdersDto();
				orders.setId(order.getId());
				orders.setOrderDate(order.getOrderDate());
				orders.setOrderStatus(order.getOrderStatus());
				orders.setQty(order.getQty());
				orders.setAmount(order.getAmount());
				
				orderList.add(orders);
			}
			return new ModelAndView("order", "orderList", orderList);

			}
	 @RequestMapping(value = EmpRestURIConstants.DELETE_ORDER, method = RequestMethod.GET,produces="application/json")
		public @ResponseBody Item deleteOrder(ModelMap model,@PathVariable("id") int id) {
			Item item = new Item();
			DeleteResponse response= null;
			try {
				response= manuscriptService.deleteOrder(id);
				int i= 1;//contactDao.deleteItem(id);
				if(response.getMessage().equals("success")) {				
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
	 @RequestMapping(value = EmpRestURIConstants.CANCEL_ORDER, method = RequestMethod.GET,produces="application/json")
		public @ResponseBody Item cancelOrder(ModelMap model,@PathVariable("orderNo") String orderNo) {
			Item item = new Item();
			SalesOrderResponse response= null;
			CancelOrder cancelOrder= new CancelOrder();
			cancelOrder.setOrderNo(orderNo);
			cancelOrder.setRemarks("Delete Selected Order due to some Item issue");
			try {
				response= manuscriptService.cancelOrder(cancelOrder);
				int i= 1;//contactDao.deleteItem(id);
				if(response.getMessage().equals("success")) {				
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
