package com.umang.springmvc.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
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

	public CustomerResponse active(Integer id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.active(id, ACTIVE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponse.class);
	}

	public CustomerResponses activeAll(Set<Integer> ID)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.activeAll(ID, ACTIVE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
	}

	public CustomerResponse deactive(Integer id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactive(id, DEACTIVE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponse.class);
	}

	public CustomerResponses deactiveAll(Set<Integer> ID)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactiveAll(ID, DEACTIVE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
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

	public InputStream getImage(String image_key) throws RuntimeException, IOException {
		return ClientConstant.getImage(image_key, GET_IMAGE);
	}

	public CustomerResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);

	}

	public CustomerResponses findAllSortedByValue(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);

	}

	public CustomerResponses getOtp(String mob)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.getOtp(mob, GET_OTP);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);

	}

	public CustomerResponses findAllSorted(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
	}

	public CustomerResponses findAll(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);

	}

	public CustomerResponse findById(int id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponse.class);
	}

	public FileUploadResponse postShopImage(int id, File image)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.postImage(id, image, SHOP_IMAGE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), FileUploadResponse.class);
	}

	public FileUploadResponse postPersonImage(int id, File image)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.postImage(id, image, PERSON_IMAGE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), FileUploadResponse.class);
	}

	public CustomerResponse save(CustomerDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_API);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponse.class);
	}

	public CustomerResponses saveAll(List<CustomerDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.saveAll(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_ALL_API);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
	}

	public CustomerResponses search(String search_text)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.search(search_text, SEARCH);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
	}

	public CustomerResponse update(CustomerDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponse.class);
	}

	public CustomerResponses updateAll(List<CustomerDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), CustomerResponses.class);
	}

	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setActive(true);
		customerDto.setArea("Area");
		customerDto.setCity("ARA");
		customerDto.setEmail("maheshwarji@gamil.com");
		customerDto.setGstNo("21AAPFU0939F1ZV");
		customerDto.setLandMark("Land Mark");
		customerDto.setMob("9000000653");
		customerDto.setPersonName("Maheshwar Ji");
		customerDto.setPincode("110098");
		customerDto.setPlotNo("Plot Name");
		customerDto.setRoadName("Road Name");
		customerDto.setShopName("Shop Name1");
		customerDto.setShopPhone("0119876543");
		customerDto.setStateGstCode("21");
		customerDto.setStateName("Bihar");

		CustomerDto customerDto1 = new CustomerDto();
		customerDto1.setActive(true);
		customerDto1.setArea("Area");
		customerDto1.setCity("NewDEL");
		customerDto1.setEmail("maheshwarji@gamil.com");
		customerDto1.setGstNo("22AAPFU0939F1ZV");
		customerDto1.setLandMark("Land Mark");
		customerDto1.setMob("9999987922");
		customerDto1.setPersonName("Maheshwar Ji");
		customerDto1.setPincode("110098");
		customerDto1.setPlotNo("Plot Name");
		customerDto1.setRoadName("Road Name");
		customerDto1.setShopName("Shop Name2");
		customerDto1.setShopPhone("0119876543");
		customerDto1.setStateGstCode("22");
		customerDto1.setStateName("Delhi");

		CustomerDto customerDto2 = new CustomerDto();
		customerDto2.setActive(true);
		customerDto2.setArea("Area");
		customerDto2.setCity("RAC");
		customerDto2.setEmail("maheshwarji@gamil.com");
		customerDto2.setGstNo("23AAPFU0939F1ZV");
		customerDto2.setLandMark("Land Mark");
		customerDto2.setMob("9992397654");
		customerDto2.setPersonName("Maheshwar Ji");
		customerDto2.setPincode("110098");
		customerDto2.setPlotNo("Plot Name");
		customerDto2.setRoadName("Road Name");
		customerDto2.setShopName("Shop Name3");
		customerDto2.setShopPhone("0119876543");
		customerDto2.setStateGstCode("23");
		customerDto2.setStateName("JHA");

		CustomerDto customerDto3 = new CustomerDto();
		customerDto3.setActive(true);
		customerDto3.setArea("Area");
		customerDto3.setCity("SWN");
		customerDto3.setEmail("maheshwarji@gamil.com");
		customerDto3.setGstNo("91AAPFU0939F1ZV");
		customerDto3.setLandMark("Land Mark");
		customerDto3.setMob("9999924654");
		customerDto3.setPersonName("Maheshwar Ji");
		customerDto3.setPincode("110098");
		customerDto3.setPlotNo("Plot Name");
		customerDto3.setRoadName("Road Name");
		customerDto3.setShopName("Shop Name4");
		customerDto3.setShopPhone("0119876543");
		customerDto3.setStateGstCode("24");
		customerDto3.setStateName("Bihar");

		List<CustomerDto> save_all_request = new ArrayList<>();
		save_all_request.add(customerDto3);
		save_all_request.add(customerDto2);
		save_all_request.add(customerDto1);

		CustomerClient client = new CustomerClient();

		// Save A Single Object
		System.out.println("Save Response = " + client.save(customerDto));

		// Save A List Of Object
	/*	System.out.println("Save All Response = " + client.saveAll(save_all_request));

		// Active A Single Object by Id
		System.out.println("Active Response  = " + client.active(27));

		// Active Multiple Objects by Id
		// put id from your tables 27,28 is id of my table
		Set<Integer> active_all = new HashSet<>();
		active_all.add(27);
		active_all.add(28);
		System.out.println("Active All Response  = " + client.activeAll(active_all));

		// Deactive single object by id
		// put id from your tables 26 is id of my table
		System.out.println("Deactive Response  = " + client.deactive(27));

		// Deactive multiple objects by ids
		System.out.println("Deactive All Response  = " + client.deactiveAll(active_all));

		// FindAll example
		System.out.println("Find All Response  = " + client.findAll(0, 0, "shop_name", SortOrder.ASC));

		// FindAll in order example
		System.out.println("Find All Response  = " + client.findAllByValue(0, 0, "shop_name", SortOrder.ASC));

		// Find all sorted example
		System.out.println("Find All Response  = " + client.findAllSorted("shop_name", SortOrder.ASC));

		// Find all sorted value example
		System.out.println("Find All Response  = " + client.findAllSortedByValue("shop_name", SortOrder.ASC));

		// find by id example
		// put id from your tables 26 is id of my table
		System.out.println("Find By Id Response  = " + client.findById(26));

		// delete one record by id
		// put id from your tables 26 is id of my table
		System.out.println("Delete Response  = " + client.delete(26));

		// delete multiple records by ids
		System.out.println("Delete Multiple Response  = " + client.deleteAll(active_all));

		// Post Person Image
		File person_image = new File("/home/deepakdubey/Pictures/customer-shipper-13.234.26.26.png");
		System.out.println(client.postPersonImage(31, person_image));

		// Post Shop Image
		File shop_image = new File("/home/deepakdubey/Pictures/images.jpeg");
		System.out.println(client.postShopImage(31, shop_image));

		// Get Uploaded Images
		// This key returned on successful upload
		String image_key = "@IMAGES@231613.232.127.56-server-out-of-space.png";
		InputStream image = client.getImage(image_key);
		System.out.println("success");

		// Get OTP
		System.out.println("Get OTO  = " + client.getOtp("7838217322"));*/

	}

}
