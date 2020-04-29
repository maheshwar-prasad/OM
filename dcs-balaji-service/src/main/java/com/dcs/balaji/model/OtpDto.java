package com.dcs.balaji.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "otp_result")
@JsonPropertyOrder
@ApiModel(description = "A response class responde back to request")
public class OtpDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2332698395916107803L;

	@JsonProperty("otp")
	private Integer otp;

	@JsonProperty("valid_for")
	private Integer validFor = 10;

	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public Integer getValidFor() {
		return validFor;
	}

	public void setValidFor(Integer validFor) {
		this.validFor = validFor;
	}

}
