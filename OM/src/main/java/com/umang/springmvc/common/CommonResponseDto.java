package com.umang.springmvc.common;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2532072682093773596L;

	@JsonProperty("status_code")
	private String statusCode;

	@JsonProperty("message")
	private String message;

	@JsonProperty("data")
	private List<CustomerDto> data;

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

	public List<CustomerDto> getData() {
		return data;
	}

	public void setData(List<CustomerDto> data) {
		this.data = data;
	}

	

}
