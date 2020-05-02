package com.umang.springmvc.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.OfferDto;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.OfferResponse;
import com.umang.springmvc.model.OfferResponses;

public class OfferClient {
	static final String SAVE_API = "/sales/offer/save";

	static final String SAVE_ALL_API = "/sales/offer/save-all";

	static final String SEARCH = "/sales/offer/search/{TEXT}";

	static final String UPDATE = "/sales/offer/update";

	static final String UPDATE_ALL = "/sales/offer/update-all";

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

	public OfferResponse deactive(Integer id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactive(id, DEACTIVE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponse.class);
	}

	public OfferResponses deactiveAll(Set<Integer> ID)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactiveAll(ID, DEACTIVE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
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

	public OfferResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);

	}

	public OfferResponses findAllSortedByValue(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);

	}

	public OfferResponses findAllSorted(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
	}

	public OfferResponses getOffer(String mob, String email)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		Map<String, String> header = new HashMap<>();
		header.put("CUST-MOB", mob);
		header.put("CUST-EMAIL", email);
		String res = ClientConstant.get(GET_OFFER, header);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
	}

	public OfferResponses findAll(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);

	}

	public OfferResponse findById(int id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponse.class);
	}

	public OfferResponse save(OfferDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_API);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponse.class);
	}

	public OfferResponses saveAll(List<OfferDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.saveAll(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_ALL_API);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
	}

	public OfferResponses search(String search_text)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.search(search_text, SEARCH);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
	}

	public OfferResponse update(OfferDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponse.class);
	}

	public OfferResponses updateAll(List<OfferDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), OfferResponses.class);
	}

}
