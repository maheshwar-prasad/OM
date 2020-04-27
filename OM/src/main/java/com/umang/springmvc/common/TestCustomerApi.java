package com.umang.springmvc.common;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TestCustomerApi {

	static final String CUSTOMER_PUSH_API = "http://localhost:8119/sales/customer/save";

	static final String CUSTOMER_FIND_API = "http://localhost:8119/sales/customer/find-all-sorted/shop_name/ASC";

	public static void main(String[] args) throws Exception {
		TestCustomerApi api = new TestCustomerApi();
		String res = api.callPush();
		ObjectMapper mapper = getObjectMapper();
		CommonResponseDto commonResponseDto = mapper.readValue(res.getBytes(), CommonResponseDto.class);
		System.out.println(commonResponseDto);
	}

	public String callPush() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		CustomerDto dto = new CustomerDto();
		dto.setArea("Area");
		dto.setCity("DEL");
		dto.setEmail("maheshwar@gmail.com");
		dto.setGstNo("17AAPFU0939F1ZV");
		dto.setLandMark("Land Mark");
		dto.setMob("9930132150");
		dto.setPersonName("Maheshwar Ji");
		dto.setPincode("110098");
		dto.setPlotNo("L-45");
		dto.setRoadName("Road Name");
		dto.setShopName("My Shop");
		dto.setShopPhone("0112345676");
		dto.setStateGstCode("17");
		dto.setStateName("DELHI");
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
