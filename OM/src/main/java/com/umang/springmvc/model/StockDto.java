package com.umang.springmvc.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "items")
@JsonPropertyOrder
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dto == null) ? 0 : dto.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StockDto other = (StockDto) obj;
		if (dto == null) {
			if (other.dto != null)
				return false;
		} else if (!dto.equals(other.dto))
			return false;
		return true;
	}
	
	

}
