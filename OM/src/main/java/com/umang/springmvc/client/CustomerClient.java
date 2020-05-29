package com.umang.springmvc.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.CustomerDto;
import com.umang.springmvc.model.CustomerResponse;
import com.umang.springmvc.model.CustomerResponses;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.FileUploadResponse;

public class CustomerClient {

	static final String SAVE_API = "/sales/customer/save";

	static final String GET_OTP = "/sales/customer/get-otp/{MOB}";

	static final String SAVE_ALL_API = "/sales/customer/save-all";

	static final String SEARCH = "/sales/customer/search/{TEXT}";

	static final String SHOP_IMAGE = "/sales/customer/shop-image";

	static final String UPDATE = "/sales/customer/update";

	static final String UPDATE_ALL = "/sales/customer/update-all";

	static final String PERSON_IMAGE = "/sales/customer/person-image";

	static final String FIND_BY_ID = "/sales/customer/find/{ID}";

	static final String FIND_ALL = "/sales/customer/find-all/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED = "/sales/customer/find-all-sorted/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED_BY_VALUE = "/sales/customer/find-all-sorted-by-value/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_BY_VALUE = "/sales/customer/find-all-by-value/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String GET_IMAGE = "/sales/customer/download-file/{IMAGE-KEY}";

	static final String DELETE = "/sales/customer/delete/{ID}";

	static final String DELETE_ALL = "/sales/customer/delete-all/{IDS}";

	static final String DEACTIVE = "/sales/customer/deactive/{ID}";

	static final String DEACTIVE_ALL = "/sales/customer/deactive-all/{IDS}";

	static final String ACTIVE = "/sales/customer/active/{ID}";

	static final String ACTIVE_ALL = "/sales/customer/active-all/{IDS}";

	public CustomerResponse active(Integer id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.active(id, ACTIVE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponse.class);
	}

	public CustomerResponses activeAll(Set<Integer> ID, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.activeAll(ID, ACTIVE_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
	}

	public CustomerResponse deactive(Integer id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactive(id, DEACTIVE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponse.class);
	}

	public CustomerResponses deactiveAll(Set<Integer> ID, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactiveAll(ID, DEACTIVE_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
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

	public CustomerResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);

	}

	public CustomerResponses findAllSortedByValue(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);

	}

	public CustomerResponses getOtp(String mob, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.getOtp(mob, GET_OTP, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);

	}

	public CustomerResponses findAllSorted(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
	}

	public CustomerResponses findAll(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);

	}

	public CustomerResponse findById(int id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponse.class);
	}

	public FileUploadResponse postShopImage(int id, File image, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.postImage(id, image, SHOP_IMAGE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), FileUploadResponse.class);
	}

	public FileUploadResponse postPersonImage(int id, File image, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.postImage(id, image, PERSON_IMAGE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), FileUploadResponse.class);
	}

	public CustomerResponse save(CustomerDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_API, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponse.class);
	}

	public CustomerResponses saveAll(List<CustomerDto> body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.saveAll(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_ALL_API,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
	}

	public CustomerResponses search(String search_text, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.search(search_text, SEARCH, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
	}

	public CustomerResponse update(CustomerDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponse.class);
	}

	public CustomerResponses updateAll(List<CustomerDto> body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
	}

}
