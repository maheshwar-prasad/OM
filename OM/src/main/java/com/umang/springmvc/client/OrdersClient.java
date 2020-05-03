package com.umang.springmvc.client;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.CancelOrder;
import com.umang.springmvc.model.CancelTypeResponse;
import com.umang.springmvc.model.DeleteResponse;
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

	//static final String FIND_ALL_SORTED = "/sales/sales-order/find-all-sorted/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED_BY_VALUE = "/sales/order/find-all-sorted-by-value/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_BY_VALUE = "/sales/order/find-all-by-value/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String DELETE = "/sales/order/delete/{ID}";

	static final String DELETE_ALL = "/sales/order/delete-all/{IDS}";

	static final String CANCEL_ORDER = "/sales/order/saller/cancel-order";

	static final String GET_ORDER = "/sales/order/saller/get-order";

	static final String UPDATE_ORDER = "/sales/order/saller/update-order";

	public DeleteResponse delete(Integer id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.delete(id, DELETE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), DeleteResponse.class);
	}

	public DeleteResponse deleteAll(Set<Integer> ID)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deleteAll(ID, DELETE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), DeleteResponse.class);
	}

	public OrdersResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponses.class);

	}

	public OrdersResponses findAllSortedByValue(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponses.class);

	}

	public OrdersResponses findAllSorted(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponses.class);
	}

	public OrdersResponses findAll(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponses.class);

	}

	public OrdersResponse findById(int id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponse.class);
	}

	public OrdersResponse update(OrdersDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponse.class);
	}

	public OrdersResponses updateAll(List<OrdersDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersResponses.class);
	}

	public CancelTypeResponse cancelType()
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.get(GET_CANCELLATION_TYPES, null);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CancelTypeResponse.class);
	}

	public OrdersStatusResponse statusType()
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.get(GET_ORDERS_STATUS_TYPES, null);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OrdersStatusResponse.class);
	}

	public SalesOrderResponse cancelOrder(CancelOrder cancelOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(cancelOrder),
				CANCEL_ORDER);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponse.class);
	}

	public SalesOrderResponses getSallerOrders(OrderStatus orderStatus)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		Map<String, String> headers = new HashMap<>();
		if (orderStatus != null)
			headers.put("ORDER-STATUS", orderStatus.name());
		String res = ClientConstant.get(GET_ORDER, headers);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponses.class);
	}

	public SalesOrderResponse updateOrder(List<PurchaseOrder> order, @NotNull String order_no)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		Map<String, String> headers = new HashMap<>();
		headers.put("ORDER-NO", order_no);
		String res = ClientConstant.put(ClientConstant.getObjectMapper().writeValueAsString(order), UPDATE_ORDER,
				headers);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponse.class);
	}

	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {

		OrdersClient client = new OrdersClient();

		// FindAll example
		System.out.println("Find All Response  = " + client.findAll(0, 0, "item_name", SortOrder.ASC));

		// FindAll in order example
		System.out.println("Find All Response  = " + client.findAllByValue(0, 0, "item_name", SortOrder.ASC));

		// Find all sorted example
		System.out.println("Find All Response  = " + client.findAllSorted("item_name", SortOrder.ASC));

		// Find all sorted value example
		System.out.println("Find All Response  = " + client.findAllSortedByValue("item_name", SortOrder.ASC));

		// find by id example
		// put id from your tables 26 is id of my table
		System.out.println("Find By Id Response  = " + client.findById(1));

		// delete one record by id
		// put id from your tables 26 is id of my table
		System.out.println("Delete Response  = " + client.delete(1));

		// delete multiple records by id
		// put id from your tables 26 is id of my table
		System.out.println("Delete Multiple Records = " + client.deleteAll(new HashSet<>(Arrays.asList(1, 2))));

		// Get Cancellation Types
		System.out.println("Cancelation Type Result = " + client.cancelType());

		// Get Status Types
		System.out.println("Status Type Result = " + client.statusType());

		// Get All Orders
		System.out.println("All Orders = " + client.getSallerOrders(null));

	}
}
