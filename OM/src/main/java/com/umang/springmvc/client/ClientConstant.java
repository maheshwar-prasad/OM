package com.umang.springmvc.client;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public interface ClientConstant {

	String BASE_PATH = "http://localhost:8119";

	String SEARCH_TEXT = "{TEXT}";

	String PAGE = "{PAGE}";

	String SIZE = "{SIZE}";

	String SORT_BY = "{SORT-BY}";

	String SORT_ORDER = "{SORT-ORDER}";

	String IMAGE_KEY = "{IMAGE-KEY}";

	String ID = "{ID}";

	String IDS = "{IDS}";

	String MOB = "{MOB}";

	String IMAGE = "image";

	static RestTemplate getTemplate() {
		return new RestTemplate();
	}

	static ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}

	static String active(Integer id, String ACTIVE_API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		ACTIVE_API = ACTIVE_API.replace(ID, id.toString());
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + ACTIVE_API, HttpMethod.PUT, http_entity,
				String.class);
		return response.getBody();
	}

	static String activeAll(Set<Integer> ID, String ACTIVE_ALL_API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		String all_id = ID.parallelStream().map(I -> I.toString()).collect(Collectors.joining(","));
		ACTIVE_ALL_API = ACTIVE_ALL_API.replace(IDS, all_id);
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + ACTIVE_ALL_API, HttpMethod.PUT,
				http_entity, String.class);
		return response.getBody();
	}

	static String deactive(Integer id, String DEACTIVE_API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		DEACTIVE_API = DEACTIVE_API.replace(ID, id.toString());
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + DEACTIVE_API, HttpMethod.DELETE,
				http_entity, String.class);
		return response.getBody();
	}

	static String deactiveAll(Set<Integer> ID, String DEACTIVE_ALL_API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		String all_id = ID.parallelStream().map(I -> I.toString()).collect(Collectors.joining(","));
		DEACTIVE_ALL_API = DEACTIVE_ALL_API.replace(IDS, all_id);
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + DEACTIVE_ALL_API, HttpMethod.DELETE,
				http_entity, String.class);
		return response.getBody();
	}

	static String delete(Integer id, String DELETE_API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		DELETE_API = DELETE_API.replace(ID, id.toString());
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + DELETE_API, HttpMethod.DELETE, http_entity,
				String.class);
		return response.getBody();
	}

	static String deleteAll(Set<Integer> ID, String DELETE_ALL_API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		String all_id = ID.parallelStream().map(I -> I.toString()).collect(Collectors.joining(","));
		DELETE_ALL_API = DELETE_ALL_API.replace(IDS, all_id);
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + DELETE_ALL_API, HttpMethod.DELETE,
				http_entity, String.class);
		return response.getBody();
	}

	static InputStream getImage(String image_key, String IMAGE_API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Accept", MediaType.APPLICATION_OCTET_STREAM_VALUE);
		IMAGE_API = IMAGE_API.replace(IMAGE_KEY, image_key);
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<byte[]> response = getTemplate().exchange(BASE_PATH + IMAGE_API, HttpMethod.GET, http_entity,
				byte[].class);
		return new ByteArrayInputStream(response.getBody());
	}

	static String findAllByValue(int page, int size, String sort_by, SortOrder sortOrder, String API)
			throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		API = API.replace(PAGE, "" + page).replace(SIZE, "" + size).replace(SORT_BY, sort_by).replace(SORT_ORDER,
				sortOrder.name());
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.GET, http_entity,
				String.class);
		return response.getBody();
	}

	static String findAllSortedByValue(String sort_by, SortOrder sortOrder, String API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		API = API.replace(SORT_BY, sort_by).replace(SORT_ORDER, sortOrder.name());
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.GET, http_entity,
				String.class);
		return response.getBody();
	}

	static String findAllSorted(String sort_by, SortOrder sortOrder, String API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		API = API.replace(SORT_BY, sort_by).replace(SORT_ORDER, sortOrder.name());
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.GET, http_entity,
				String.class);
		return response.getBody();
	}

	static String findAll(int page, int size, String sort_by, SortOrder sortOrder, String API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		API = API.replace(PAGE, "" + page).replace(SIZE, "" + size).replace(SORT_BY, sort_by).replace(SORT_ORDER,
				sortOrder.name());
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.GET, http_entity,
				String.class);
		return response.getBody();
	}

	static String findById(int id, String API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		API = API.replace(ID, "" + id);
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.GET, http_entity,
				String.class);
		return response.getBody();
	}

	static String postImage(int id, File image, String API) throws RuntimeException, IOException {
		MultiValueMap<String, Object> bodyMap = new LinkedMultiValueMap<>();
		bodyMap.add(IMAGE, getFileResource(image));
		bodyMap.add("ID", id);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);

		HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(bodyMap, headers);

		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.POST, requestEntity,
				String.class);
		return response.getBody();
	}

	static String save(String body, String API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> http_entity = new HttpEntity<String>(body, headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.POST, http_entity,
				String.class);
		return response.getBody();
	}

	static String saveAll(String body, String API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> http_entity = new HttpEntity<String>(body, headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.POST, http_entity,
				String.class);
		return response.getBody();
	}

	static String search(String search_text, String API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		API = API.replace(SEARCH_TEXT, search_text);
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.GET, http_entity,
				String.class);
		return response.getBody();
	}

	static String getOtp(String mob, String API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		API = API.replace(MOB, mob);
		HttpEntity<String> http_entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.GET, http_entity,
				String.class);
		return response.getBody();
	}

	static String get(String API, Map<String, String> headers) throws RuntimeException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		if (headers != null)
			headers.forEach((K, V) -> header.add(K, V));

		HttpEntity<String> http_entity = new HttpEntity<String>(header);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.GET, http_entity,
				String.class);
		return response.getBody();
	}

	static String put(String body, String API, Map<String, String> headers) throws RuntimeException {
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		if (headers != null)
			headers.forEach((K, V) -> header.add(K, V));
		HttpEntity<String> http_entity = new HttpEntity<String>(body, header);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.PUT, http_entity,
				String.class);
		return response.getBody();
	}

	static String update(String body, String API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> http_entity = new HttpEntity<String>(body, headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.PUT, http_entity,
				String.class);
		return response.getBody();
	}

	static String updateAll(String body, String API) throws RuntimeException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<String> http_entity = new HttpEntity<String>(body, headers);
		ResponseEntity<String> response = getTemplate().exchange(BASE_PATH + API, HttpMethod.PUT, http_entity,
				String.class);
		return response.getBody();
	}

	static Resource getFileResource(File file) throws IOException {
		return new FileSystemResource(file);
	}

}
