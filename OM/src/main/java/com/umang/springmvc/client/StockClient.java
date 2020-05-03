package com.umang.springmvc.client;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.DeleteResponse;
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

	static final String FIND_ALL = "/sales/stock/find-all/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED = "/sales/stock/find-all-sorted/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED_BY_VALUE = "/sales/stock/find-all-sorted-by-value/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_BY_VALUE = "/sales/stock/find-all-by-value/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String DELETE = "/sales/stock/delete/{ID}";

	static final String DELETE_ALL = "/sales/stock/delete-all/{IDS}";

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

	public StockResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);

	}

	public StockResponses findAllSortedByValue(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);

	}

	public StockResponses findAllSorted(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);
	}

	public StockResponses findAll(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);

	}

	public StockResponse findById(int id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponse.class);
	}

	public StockResponse save(StockDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_API);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponse.class);
	}

	public StockResponses saveAll(List<StockDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.saveAll(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_ALL_API);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);
	}

	public StockResponses search(String search_text)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.search(search_text, SEARCH);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);
	}

	public StockResponse update(StockDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponse.class);
	}

	public StockResponses updateAll(List<StockDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), StockResponses.class);
	}
}
