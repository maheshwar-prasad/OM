package com.dcs.balaji.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * 
 * @author deepakdubey
 * @since 23 JULY 2019
 * @version 1.0
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder
public class InvalidHeaderExceptionResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1634900432123164669L;

	@JsonProperty(value = "code")
	private String errorCode;

	private String message;

	private String description;

	private String url;

	public InvalidHeaderExceptionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidHeaderExceptionResponse(String errorCode, String message, String description, String url) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.description = description;
		this.url = url;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
