package com.umang.springmvc.client;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.FileUploadResponse;
import com.umang.springmvc.model.OfferDto;
import com.umang.springmvc.model.OfferResponse;
import com.umang.springmvc.model.OfferResponses;

public class OfferClient {
	static final String SAVE_API = "/sales/offer/save";

	static final String SAVE_ALL_API = "/sales/offer/save-all";

	static final String SEARCH = "/sales/offer/search/{TEXT}";

	static final String UPDATE = "/sales/offer/update";

	static final String UPDATE_ALL = "/sales/offer/update-all";

	static final String IMAGE = "/sales/offer/image";

	static final String FIND_BY_ID = "/sales/offer/find/{ID}";

	static final String FIND_ALL = "/sales/offer/find-all/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED = "/sales/offer/find-all-sorted/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_SORTED_BY_VALUE = "/sales/offer/find-all-sorted-by-value/{SORT-BY}/{SORT-ORDER}";

	static final String FIND_ALL_BY_VALUE = "/sales/offer/find-all-by-value/{PAGE}/{SIZE}/{SORT-BY}/{SORT-ORDER}";

	static final String GET_OFFER = "/sales/offer/get-offer";

	static final String DELETE = "/sales/offer/delete/{ID}";

	static final String DELETE_ALL = "/sales/offer/delete-all/{IDS}";

	static final String DEACTIVE = "/sales/offer/deactive/{ID}";

	static final String DEACTIVE_ALL = "/sales/offer/deactive-all/{IDS}";

	public OfferResponse deactive(Integer id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactive(id, DEACTIVE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponse.class);
	}

	public OfferResponses deactiveAll(Set<Integer> ID, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactiveAll(ID, DEACTIVE_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
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

	public OfferResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);

	}

	public OfferResponses findAllSortedByValue(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);

	}

	public OfferResponses findAllSorted(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
	}

	public OfferResponses getOffer(String mob, String email, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		Map<String, String> header = new HashMap<>();
		header.put("CUST-MOB", mob);
		header.put("CUST-EMAIL", email);
		String res = ClientConstant.get(GET_OFFER, header, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
	}

	public OfferResponses findAll(int page, int size, String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);

	}

	public OfferResponse findById(int id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponse.class);
	}

	public OfferResponse save(OfferDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_API, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponse.class);
	}

	public OfferResponses saveAll(List<OfferDto> body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.saveAll(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_ALL_API,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
	}

	public OfferResponses search(String search_text, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.search(search_text, SEARCH, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
	}

	public OfferResponse update(OfferDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponse.class);
	}

	public OfferResponses updateAll(List<OfferDto> body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL,
				routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
	}

	public FileUploadResponse postItemImage(int id, File image, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.postImage(id, image, IMAGE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), FileUploadResponse.class);
	}

}
