package com.umang.springmvc.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.umang.springmvc.model.DeleteResponse;
import com.umang.springmvc.model.FileUploadResponse;
import com.umang.springmvc.model.ItemsDto;
import com.umang.springmvc.model.ItemsResponse;
import com.umang.springmvc.model.ItemsResponses;
import com.umang.springmvc.model.OfferType;

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

	public ItemsResponse active(Integer id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.active(id, ACTIVE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponse.class);
	}

	public ItemsResponses activeAll(Set<Integer> ID)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.activeAll(ID, ACTIVE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

	public ItemsResponse deactive(Integer id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactive(id, DEACTIVE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponse.class);
	}

	public ItemsResponses deactiveAll(Set<Integer> ID)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.deactiveAll(ID, DEACTIVE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
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

	public ItemsResponses findAllByValue(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllByValue(page, size, sort_by, sortOrder, FIND_ALL_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);

	}

	public ItemsResponses findAllSortedByValue(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSortedByValue(sort_by, sortOrder, FIND_ALL_SORTED_BY_VALUE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);

	}

	public ItemsResponses findAllSorted(String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAllSorted(sort_by, sortOrder, FIND_ALL_SORTED);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

	public ItemsResponses findAll(int page, int size, String sort_by, SortOrder sortOrder)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findAll(page, size, sort_by, sortOrder, FIND_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);

	}

	public ItemsResponse findById(int id)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.findById(id, FIND_BY_ID);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponse.class);
	}

	public FileUploadResponse postItemImage(int id, File image)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.postImage(id, image, ITEM_IMAGE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), FileUploadResponse.class);
	}

	public ItemsResponse save(ItemsDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.save(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_API);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponse.class);
	}

	public ItemsResponses saveAll(List<ItemsDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.saveAll(ClientConstant.getObjectMapper().writeValueAsString(body), SAVE_ALL_API);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

	public ItemsResponses search(String search_text)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.search(search_text, SEARCH);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

	public ItemsResponse update(ItemsDto body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.update(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponse.class);
	}

	public ItemsResponses updateAll(List<ItemsDto> body)
			throws RuntimeException, JsonParseException, JsonMappingException, IOException {
		String res = ClientConstant.updateAll(ClientConstant.getObjectMapper().writeValueAsString(body), UPDATE_ALL);
		return ClientConstant.getObjectMapper().readValue(res.getBytes(), ItemsResponses.class);
	}

	public static void main(String[] args)
			throws JsonParseException, JsonMappingException, RuntimeException, IOException {
		ItemsDto dto = new ItemsDto();
		dto.setActive(true);
		dto.setDescription("Sunflower oil for healty diet.");
		dto.setDisplayOrder(1);
		dto.setFree(1);
		dto.setItemName("Tomato");
		dto.setMrp(100.0);
		dto.setOfferEffectedBy(new Date());
		dto.setOfferTill(new Date());
		dto.setOfferType(OfferType.FU);
		dto.setOfferUnits(10);
		dto.setPack("154 ML.");
		dto.setUnitPrice(90.0);

		ItemsDto dto1 = new ItemsDto();
		dto1.setActive(true);
		dto1.setDescription("Sunflower oil for healty diet.");
		dto1.setDisplayOrder(1);
		dto1.setFree(1);
		dto1.setItemName("Sunflower oil");
		dto1.setMrp(100.0);
		dto1.setOfferEffectedBy(new Date());
		dto1.setOfferTill(new Date());
		dto1.setOfferType(OfferType.FU);
		dto1.setOfferUnits(10);
		dto1.setPack("351 ML.");
		dto1.setUnitPrice(90.0);

		ItemsDto dto2 = new ItemsDto();
		dto2.setActive(true);
		dto2.setDescription("Sunflower oil for healty diet.");
		dto2.setDisplayOrder(1);
		dto2.setFree(1);
		dto2.setItemName("Sunflower oil");
		dto2.setMrp(100.0);
		dto2.setOfferEffectedBy(new Date());
		dto2.setOfferTill(new Date());
		dto2.setOfferType(OfferType.FU);
		dto2.setOfferUnits(10);
		dto2.setPack("251 ML");
		dto2.setUnitPrice(90.0);

		ItemsDto dto3 = new ItemsDto();
		dto3.setActive(true);
		dto3.setDescription("Sunflower oil for healty diet.");
		dto3.setDisplayOrder(1);
		dto3.setFree(1);
		dto3.setItemName("Sunflower oil");
		dto3.setMrp(100.0);
		dto3.setOfferEffectedBy(new Date());
		dto3.setOfferTill(new Date());
		dto3.setOfferType(OfferType.FU);
		dto3.setOfferUnits(10);
		dto3.setPack("451 ML.");
		dto3.setUnitPrice(90.0);

		ItemsDto dto4 = new ItemsDto();
		dto4.setActive(true);
		dto4.setDescription("Sunflower oil for healty diet.");
		dto4.setDisplayOrder(1);
		dto4.setFree(1);
		dto4.setItemName("Sunflower oil");
		dto4.setMrp(100.0);
		dto4.setOfferEffectedBy(new Date());
		dto4.setOfferTill(new Date());
		dto4.setOfferType(OfferType.FU);
		dto4.setOfferUnits(10);
		dto4.setPack("51 Ltr.");
		dto4.setUnitPrice(90.0);

		ItemsDto dto5 = new ItemsDto();
		dto5.setActive(true);
		dto5.setDescription("Sunflower oil for healty diet.");
		dto5.setDisplayOrder(1);
		dto5.setFree(1);
		dto5.setItemName("Sunflower oil");
		dto5.setMrp(100.0);
		dto5.setOfferEffectedBy(new Date());
		dto5.setOfferTill(new Date());
		dto5.setOfferType(OfferType.FU);
		dto5.setOfferUnits(10);
		dto5.setPack("510 ML.");
		dto5.setUnitPrice(90.0);

		List<ItemsDto> save_all_request = new ArrayList<>();
		save_all_request.add(dto1);
		save_all_request.add(dto2);
		save_all_request.add(dto3);
		save_all_request.add(dto4);
		save_all_request.add(dto5);

		ItemsClient client = new ItemsClient();

		// Save A Single Object
		System.out.println("Save Response = " + client.save(dto1));

		// Save A List Of Object
		//System.out.println("Save All Response = " + client.saveAll(save_all_request));

		// Active A Single Object by Id
		//System.out.println("Active Response = " + client.active(1));

		// Active Multiple Objects by Id
		// put id from your tables 27,28 is id of my table
		Set<Integer> active_all = new HashSet<>();
		active_all.add(2);
		active_all.add(3);
		//System.out.println("Active All Response = " + client.activeAll(active_all));

		// Deactive single object by id
		// put id from your tables 26 is id of my table
		//System.out.println("Deactive Response = " + client.deactive(1));

		// Deactive multiple objects by ids
		//System.out.println("Deactive All Response = " + client.deactiveAll(active_all));

		// FindAll example
		/*ItemsResponses itemResponses = client.findAll(0, 0, "item_name", SortOrder.ASC);
		if (itemResponses.getStatusCode().equals("D200")) {
			List<ItemsDto> data = itemResponses.getData();
			data.forEach(D -> System.out.println(data));

		}*/

		// System.out.println("Find All Response = " + client.findAll(0, 0, "item_name",
		// SortOrder.ASC));

		// FindAll in order example
		/*System.out.println("Find All Response  = " + client.findAllByValue(0, 0, "item_name", SortOrder.ASC));

		// Find all sorted example
		System.out.println("Find All Response  = " + client.findAllSorted("item_name", SortOrder.ASC));

		// Find all sorted value example
		System.out.println("Find All Response  = " + client.findAllSortedByValue("item_name", SortOrder.ASC));

		// find by id example
		// put id from your tables 26 is id of my table
		System.out.println("Find By Id Response  = " + client.findById(1));

		// delete one record by id
		// put id from your tables 26 is id of my table
		System.out.println("Delete Response = " + client.delete(1));

		// delete multiple records by ids
		System.out.println("Delete Multiple Response = " + client.deleteAll(active_all));

		// Post Item Image
		File item_image = new File("/home/deepakdubey/Pictures/images.jpeg");
		FileUploadResponse commonResponseDto = client.postItemImage(3, item_image);
		System.out.println(commonResponseDto);
*/
		// Get Uploaded Images
		// This key returned on successful upload
		//InputStream image = client.getImage(commonResponseDto.getData().getFileKey());
		//System.out.println("success");

	}

}
