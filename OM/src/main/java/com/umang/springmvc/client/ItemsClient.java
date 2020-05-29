package com.umang.springmvc.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.FileUploadResponse;
import com.umang.springmvc.model.ItemsDto;
import com.umang.springmvc.model.ItemsResponse;
import com.umang.springmvc.model.ItemsResponses;

public class ItemsClient {

	static final String SAVE_API = "/sales/item/save";

	static final String SAVE_ALL_API = "/sales/item/save-all";

	static final String SEARCH = "/sales/item/search/{TEXT}";

	static final String ITEM_IMAGE = "/sales/item/item-image";

	static final String UPDATE = "/sales/item/update";

	static final String UPDATE_ALL = "/sales/item/update-all";

	static final String FIND_BY_ID = "/sales/item/find/{ID}";

	static final String FIND_ALL = "/sales/item/find-all/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED = "/sales/item/find-all-sorted/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED_BY_VALUE = "/sales/item/find-all-sorted-by-value/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_BY_VALUE = "/sales/item/find-all-by-value/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String GET_IMAGE = "/sales/item/download-file/{IMAGE-KEY}";

	static final String DELETE = "/sales/item/delete/{ID}";

	static final String DELETE_ALL = "/sales/item/delete-all/{IDS}";

	static final String DEACTIVE = "/sales/item/deactive/{ID}";

	static final String DEACTIVE_ALL = "/sales/item/deactive-all/{IDS}";

	static final String ACTIVE = "/sales/item/active/{ID}";

	static final String ACTIVE_ALL = "/sales/item/active-all/{IDS}";

	public ItemsResponse active(Integer id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.active(id, ACTIVE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponse.class);
	}

	public ItemsResponses activeAll(Set<Integer> ID, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.activeAll(ID, ACTIVE_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

	public ItemsResponse deactive(Integer id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactive(id, DEACTIVE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponse.class);
	}

	public ItemsResponses deactiveAll(Set<Integer> ID, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactiveAll(ID, DEACTIVE_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

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

	public InputStream getImage(String image_key, Integer routing) throws RuntimeException, IOException {
		return ClientConstant.getImage(image_key, GET_IMAGE, routing);
	}

	public ItemsResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);

	}

	public ItemsResponses findAllSortedByValue(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);

	}

	public ItemsResponses findAllSorted(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

	public ItemsResponses findAll(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);

	}

	public ItemsResponse findById(int id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponse.class);
	}

	public FileUploadResponse postItemImage(int id, File image, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.postImage(id, image, ITEM_IMAGE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), FileUploadResponse.class);
	}

	public ItemsResponse save(ItemsDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_API, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponse.class);
	}

	public ItemsResponses saveAll(List<ItemsDto> body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.saveAll(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_ALL_API,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

	public ItemsResponses search(String search_text, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.search(search_text, SEARCH, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

	public ItemsResponse update(ItemsDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponse.class);
	}

	public ItemsResponses updateAll(List<ItemsDto> body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

}
