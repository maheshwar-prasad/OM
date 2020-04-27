package com.umang.springmvc.model;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelTypeResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2532072682093773596L;

	@JsonProperty("status_code")
	private String statusCode;

	@JsonProperty("message")
	private String message;

	@JsonProperty("data")
	private Map<CancelledBy, String> data;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<CancelledBy, String> getData() {
		return data;
	}

	public void setData(Map<CancelledBy, String> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CommonResponseDto [statusCode=" + statusCode + ", message=" + message + ", data=" + data + "]";
	}

}
