package com.umang.springmvc.client;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.ItemsCategoryResponse;
import com.umang.springmvc.model.ItemsCategoryResponses;
import com.umang.springmvc.model.CategoryDto;

public class ItemCategoryClient {

	static final String SAVE_API = "/sales/cattegory/save";

	static final String SAVE_ALL_API = "/sales/cattegory/save-all";

	static final String SEARCH = "/sales/cattegory/search/{TEXT}";

	static final String UPDATE = "/sales/cattegory/update";

	static final String UPDATE_ALL = "/sales/cattegory/update-all";

	static final String FIND_BY_ID = "/sales/cattegory/find/{ID}";

	static final String FIND_ALL = "/sales/cattegory/find-all/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED = "/sales/cattegory/find-all-sorted/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED_BY_VALUE = "/sales/cattegory/find-all-sorted-by-value/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_BY_VALUE = "/sales/cattegory/find-all-by-value/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String DELETE = "/sales/cattegory/delete/{ID}";

	static final String DELETE_ALL = "/sales/cattegory/delete-all/{IDS}";

	static final String DEACTIVE = "/sales/cattegory/deactive/{ID}";

	static final String DEACTIVE_ALL = "/sales/cattegory/deactive-all/{IDS}";

	public ItemsCategoryResponse deactive(Integer id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactive(id, DEACTIVE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponse.class);
	}

	public ItemsCategoryResponses deactiveAll(Set<Integer> ID)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactiveAll(ID, DEACTIVE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponses.class);
	}

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

	public ItemsCategoryResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponses.class);

	}

	public ItemsCategoryResponses findAllSortedByValue(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponses.class);

	}

	public ItemsCategoryResponses findAllSorted(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponses.class);
	}

	public ItemsCategoryResponses findAll(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponses.class);

	}

	public ItemsCategoryResponse findById(int id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponse.class);
	}

	public ItemsCategoryResponse save(CategoryDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_API);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponse.class);
	}

	public ItemsCategoryResponses saveAll(List<CategoryDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.saveAll(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_ALL_API);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponses.class);
	}

	public ItemsCategoryResponses search(String search_text)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.search(search_text, SEARCH);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponses.class);
	}

	public ItemsCategoryResponse update(CategoryDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponse.class);
	}

	public ItemsCategoryResponses updateAll(List<CategoryDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsCategoryResponses.class);
	}

}
