package com.umang.springmvc.common;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTransformer {
	public ObjectMapper getObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.getDeserializationConfig().without(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		return mapper;
	}

	public <T> T fromJson(String jsonString, Class<T> responseType) throws JsonTransformerException {
		T responseBean = null;
		ObjectMapper mapper = getObjectMapper();// new ObjectMapper();
		try {
			responseBean = mapper.readValue(jsonString, responseType);
		} catch (JsonParseException jsonParseException) {
			throw new JsonTransformerException("Exception for input :" + jsonString + jsonParseException);
		} catch (JsonMappingException jsonMappingException) {
			throw new JsonTransformerException("Exception for input :" + jsonString + jsonMappingException);
		} catch (IOException ioException) {
			throw new JsonTransformerException("Exception for input :" + jsonString + ioException);
		}
		return responseBean;

	}

	public String toJson(Object entity) throws JsonTransformerException {
		String jsonRequest = null;
		ObjectMapper mapper = getObjectMapper();// new ObjectMapper();
		try {
			jsonRequest = mapper.writeValueAsString(entity);
		} catch (JsonGenerationException jsonGenerationException) {
			throw new JsonTransformerException(jsonGenerationException);
		} catch (JsonMappingException jsonMappingException) {
			throw new JsonTransformerException(jsonMappingException);
		} catch (IOException ioException) {
			throw new JsonTransformerException(ioException);
		}
		return jsonRequest;
	}


}
