package com.umang.springmvc.client;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.OrdersResponses;
import com.umang.springmvc.model.SalesOrderResponse;
import com.umang.springmvc.model.SalesOrderResponses;

public class SalesOrderClient {
	
	static final String FIND_ALL_SORTED = "/sales/sales-order/find-all-sorted/{SORT-BY}/{SORT-ORDER}";
	
	public SalesOrderResponses findAllSorted(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SalesOrderResponses.class);
	}
}
