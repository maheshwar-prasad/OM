package com.umang.springmvc.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//import io.swagger.annotations.ApiModel;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "offers")
@JsonPropertyOrder
//@ApiModel(description = "A response class responde back to request")
public class Offers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6947984510391863453L;

	@JsonProperty("on_purchase_of")
	private Integer onPurchaseOf;

	@JsonProperty("amount_off")
	private Integer amountOff;

	@JsonProperty("free_items")
	private Integer freeItems;

	public Integer getOnPurchaseOf() {
		return onPurchaseOf;
	}

	public void setOnPurchaseOf(Integer onPurchaseOf) {
		this.onPurchaseOf = onPurchaseOf;
	}

	public Integer getAmountOff() {
		return amountOff;
	}

	public void setAmountOff(Integer amountOff) {
		this.amountOff = amountOff;
	}

	public Integer getFreeItems() {
		return freeItems;
	}

	public void setFreeItems(Integer freeItems) {
		this.freeItems = freeItems;
	}

}
