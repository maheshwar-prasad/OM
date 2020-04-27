package com.umang.springmvc.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//import io.swagger.annotations.ApiModel;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "items")
@JsonPropertyOrder
//@ApiModel(description = "A response class responde back to request")
public class StockDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4325671711096584024L;

	@JsonProperty("items")
	@NotNull
	private ItemsDto dto;

	@JsonProperty("qty")
	@NotNull
	private Integer qty;

	public ItemsDto getDto() {
		return dto;
	}

	public void setDto(ItemsDto dto) {
		this.dto = dto;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

}
