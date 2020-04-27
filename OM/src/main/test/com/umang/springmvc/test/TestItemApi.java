package com.umang.springmvc.test;

import java.util.Date;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.umang.springmvc.common.CommonResponseItemDto;
import com.umang.springmvc.common.ItemsDto;
import com.umang.springmvc.common.OfferType;

public class TestItemApi {

	static final String CUSTOMER_PUSH_API = "http://localhost:8119/sales/item/save";

	static final String CUSTOMER_FIND_API = "http://localhost:8119/sales/item/find-all-sorted/0/ASC";

	public static void main(String[] args) throws Exception {
		TestItemApi api = new TestItemApi();
		String res = api.callPush();
		ObjectMapper mapper = getObjectMapper();
		CommonResponseItemDto commonResponseDto = mapper.readValue(res.getBytes(), CommonResponseItemDto.class);
		System.out.println(commonResponseDto);
	}

	public String callPush() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		ItemsDto dto = new ItemsDto();
		dto.setActive(true);
		dto.setDescription("Sunflower oil for healty diet.");
		dto.setDisplayOrder(1);
		dto.setFree(1);
		dto.setItemName("Sunflower oil");
		dto.setMrp(100.0);
		dto.setOfferEffectedBy(new Date());
		dto.setOfferTill(new Date());
		dto.setOfferType(OfferType.FU);
		dto.setOfferUnits(10);
		dto.setPack("1 Ltr.");
		dto.setUnitPrice(90.0);

		ResponseEntity<String> response = null;
		try {
			ObjectMapper mapper = getObjectMapper();
			String serialized = mapper.writeValueAsString(dto);
			HttpEntity<String> requestEntity = new HttpEntity<String>(serialized, headers);
			response = getTemplate().exchange(CUSTOMER_PUSH_API, HttpMethod.POST, requestEntity, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response.getBody();
	}

	public static RestTemplate getTemplate() {
		return new RestTemplate();
	}

	public static ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}
