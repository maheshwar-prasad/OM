package com.umang.springmvc.client;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.SalesOrderDto;
import com.umang.springmvc.model.SalesOrderResponse;
import com.umang.springmvc.model.SalesOrderResponses;

public class SalesOrderClient {

	static final String UPDATE = "/sales/sales-order/update";

	static final String UPDATE_ALL = "/sales/sales-order/update-all";

	static final String FIND_BY_ID = "/sales/sales-order/find/{ID}";

	static final String FIND_ALL = "/sales/sales-order/find-all/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED = "/sales/sales-order/find-all-sorted/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED_BY_VALUE = "/sales/sales-order/find-all-sorted-by-value/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_BY_VALUE = "/sales/sales-order/find-all-by-value/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String DELETE = "/sales/sales-order/delete/{ID}";

	static final String DELETE_ALL = "/sales/sales-order/delete-all/{IDS}";

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

	public SalesOrderResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponses.class);

	}

	public SalesOrderResponses findAllSortedByValue(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponses.class);

	}

	public SalesOrderResponses findAllSorted(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponses.class);
	}

	public SalesOrderResponses findAll(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponses.class);

	}

	public SalesOrderResponse findById(int id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponse.class);
	}

	public SalesOrderResponse update(SalesOrderDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponse.class);
	}

	public SalesOrderResponses updateAll(List<SalesOrderDto> body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponses.class);
	}

}
