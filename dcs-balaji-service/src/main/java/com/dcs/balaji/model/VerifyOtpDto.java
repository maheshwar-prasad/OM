package com.dcs.balaji.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "verify_otp_result")
@JsonPropertyOrder
@ApiModel(description = "A response class responde back to request")
public class VerifyOtpDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1788230016571069406L;

	private boolean result;

	private boolean regRequired;

	private boolean alreadyRegistered;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public boolean isRegRequired() {
		return regRequired;
	}

	public void setRegRequired(boolean regRequired) {
		this.regRequired = regRequired;
	}

	public boolean isAlreadyRegistered() {
		return alreadyRegistered;
	}

	public void setAlreadyRegistered(boolean alreadyRegistered) {
		this.alreadyRegistered = alreadyRegistered;
	}

}
