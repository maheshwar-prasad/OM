package com.umang.springmvc.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.CancelOrder;
import com.umang.springmvc.model.CancelTypeResponse;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.OrderDto;
import com.umang.springmvc.model.OrderStatus;
import com.umang.springmvc.model.OrdersDto;
import com.umang.springmvc.model.OrdersResponse;
import com.umang.springmvc.model.OrdersResponses;
import com.umang.springmvc.model.OrdersStatusResponse;
import com.umang.springmvc.model.PurchaseOrder;
import com.umang.springmvc.model.SalesOrderResponse;
import com.umang.springmvc.model.SalesOrderResponses;

public class OrdersClient {

	static final String GET_CANCELLATION_TYPES = "/sales/order/get-cancel-by";

	static final String GET_ORDERS_STATUS_TYPES = "/sales/order/get-order-status";

	static final String UPDATE = "/sales/order/update";

	static final String UPDATE_ALL = "/sales/order/update-all";

	static final String FIND_BY_ID = "/sales/order/find/{ID}";

	static final String FIND_ALL = "/sales/order/find-all/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED = "/sales/order/find-all-sorted/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED_BY_VALUE = "/sales/order/find-all-sorted-by-value/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_BY_VALUE = "/sales/order/find-all-by-value/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String DELETE = "/sales/order/delete/{ID}";

	static final String DELETE_ALL = "/sales/order/delete-all/{IDS}";

	static final String CANCEL_ORDER = "/sales/order/saller/cancel-order";

	static final String GET_ORDER = "/sales/order/saller/get-order";

	static final String UPDATE_ORDER = "/sales/order/saller/update-order";

	static final String PUSH_ORDER = "/sales/order/push-order";

	public DeleteResponse delete(Integer id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.delete(id, DELETE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), DeleteResponse.class);
	}

	public DeleteResponse deleteAll(Set<Integer> ID, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deleteAll(ID, DELETE_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), DeleteResponse.class);
	}

	public OrdersResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponses.class);

	}

	public OrdersResponses findAllSortedByValue(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponses.class);

	}

	public OrdersResponses findAllSorted(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponses.class);
	}

	public OrdersResponses findAll(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponses.class);

	}

	public OrdersResponse findById(int id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponse.class);
	}

	public OrdersResponse update(OrdersDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponse.class);
	}

	public OrdersResponses updateAll(List<OrdersDto> body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponses.class);
	}

	public CancelTypeResponse cancelType(Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.get(GET_CANCELLATION_TYPES, null, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CancelTypeResponse.class);
	}

	public OrdersStatusResponse statusType(Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.get(GET_ORDERS_STATUS_TYPES, null, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersStatusResponse.class);
	}

	public SalesOrderResponse pushOrder(List<OrderDto> orders, String CUST_EMAIL, String CUST_MOB, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		Map<String, String> headers = new HashMap<>();
		headers.put("CUST-EMAIL", CUST_EMAIL);
		headers.put("CUST-MOB", CUST_MOB);
		String res = ClientConstant.post(ClientConstant.getObjectMapper().writeValueAsString(orders), PUSH_ORDER,
				headers, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponse.class);
	}

	public SalesOrderResponse cancelOrder(CancelOrder cancelOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(cancelOrder), CANCEL_ORDER,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponse.class);
	}

	public SalesOrderResponses getSallerOrders(OrderStatus orderStatus, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		Map<String, String> headers = new HashMap<>();
		if (orderStatus != null)
			headers.put("ORDER-STATUS", orderStatus.name());
		String res = ClientConstant.get(GET_ORDER, headers, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponses.class);
	}

	public SalesOrderResponse updateOrder(List<PurchaseOrder> order, @NotNull String order_no, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		Map<String, String> headers = new HashMap<>();
		headers.put("ORDER-NO", order_no);
		String res = ClientConstant.put(ClientConstant.getObjectMapper().writeValueAsString(order), UPDATE_ORDER,
				headers, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponse.class);
	}

}
