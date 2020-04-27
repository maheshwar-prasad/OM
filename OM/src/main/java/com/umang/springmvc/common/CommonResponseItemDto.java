package com.umang.springmvc.common;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonResponseItemDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2532072682093773596L;

	@JsonProperty("status_code")
	private String statusCode;

	@JsonProperty("message")
	private String message;

	@JsonProperty("data")
	private ItemsDto data;

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

	public ItemsDto getData() {
		return data;
	}

	public void setData(ItemsDto data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "CommonResponseItemDto [statusCode=" + statusCode + ", message=" + message + ", data=" + data + "]";
	}

}
