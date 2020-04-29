package com.dcs.balaji.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "customer_offer")
@JsonPropertyOrder
@ApiModel(description = "A response class responde back to request")
public class CustomerOffer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5426898418113540050L;

	private String offer;

	public CustomerOffer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerOffer(String offer) {
		super();
		this.offer = offer;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

}
