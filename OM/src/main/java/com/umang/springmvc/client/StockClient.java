package com.umang.springmvc.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.SallingItemsResponse;
import com.umang.springmvc.model.StockDto;
import com.umang.springmvc.model.StockResponse;
import com.umang.springmvc.model.StockResponses;

public class StockClient {

	static final String SAVE_API = "/sales/stock/save";

	static final String SAVE_ALL_API = "/sales/stock/save-all";

	static final String SEARCH = "/sales/stock/search/{TEXT}";

	static final String UPDATE = "/sales/stock/update";

	static final String UPDATE_ALL = "/sales/stock/update-all";

	static final String FIND_BY_ID = "/sales/stock/find/{ID}";

	static final String GET_ITEMS = "/sales/stock/get-items";

	static final String GET_ITEMS_BY_CAT = "/sales/stock/get-items/{cat-id}";

	static final String FIND_ALL = "/sales/stock/find-all/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED = "/sales/stock/find-all-sorted/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED_BY_VALUE = "/sales/stock/find-all-sorted-by-value/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_BY_VALUE = "/sales/stock/find-all-by-value/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String DELETE = "/sales/stock/delete/{ID}";

	static final String DELETE_ALL = "/sales/stock/delete-all/{IDS}";

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

	public StockResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);

	}

	public StockResponses findAllSortedByValue(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);

	}

	public StockResponses findAllSorted(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);
	}

	public StockResponses findAll(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);

	}

	public StockResponse findById(int id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponse.class);
	}

	public StockResponse save(StockDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_API, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponse.class);
	}

	public StockResponses saveAll(List<StockDto> body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.saveAll(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_ALL_API,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);
	}

	public StockResponses search(String search_text, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.search(search_text, SEARCH, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);
	}

	public StockResponse update(StockDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponse.class);
	}

	public StockResponses updateAll(List<StockDto> body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);
	}

	public SallingItemsResponse get(Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.get(GET_ITEMS, null, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SallingItemsResponse.class);
	}

	public SallingItemsResponse get(Integer cat_id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		Map<String, String> paths = new HashMap<>();
		paths.put(ClientConstant.CAT_ID, cat_id.toString());
		String res = ClientConstant.get(GET_ITEMS_BY_CAT, null, paths, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SallingItemsResponse.class);
	}
}
