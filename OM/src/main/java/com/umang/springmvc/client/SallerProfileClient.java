package com.umang.springmvc.client;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.FileUploadResponse;
import com.umang.springmvc.model.SallerProfileDto;
import com.umang.springmvc.model.SallerProfileResponse;
import com.umang.springmvc.model.SallerProfileResponses;

public class SallerProfileClient {

	static final String FIND_BY_ID = "/sales/saller/find/{ID}";

	static final String FIND_ALL_SORTED = "/sales/saller/find-all-sorted/{SORT-BY}/{SORT-ORDER}";

	static final String TERMS = "/sales/saller/term";

	static final String UPDATE = "/sales/saller/update";

	public SallerProfileResponse findById(int id, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SallerProfileResponse.class);
	}

	public SallerProfileResponses findAllSorted(String sort_by, SortOrder sortOrder, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SallerProfileResponses.class);
	}

	public FileUploadResponse postTerms(int id, File terms, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.postFile(id, terms, TERMS, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), FileUploadResponse.class);
	}

	public SallerProfileResponse update(SallerProfileDto body, Integer routing)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE, routing);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), SallerProfileResponse.class);
	}
}
