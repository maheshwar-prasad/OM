package com.dcs.balaji.model;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.dcs.balaji.entity.Category;
import com.dcs.validation.annotation.Validate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "item_categoty")
@JsonPropertyOrder
@ApiModel(description = "A response class responde back to request")
public class CategoryDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8574531934829888272L;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("category_name")
	@Validate(min = 3, max = 100, nullable = false, column = "category_name")
	private String categoryName;

	@JsonProperty("display_order")
	private Integer displayOrder;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public Category entity() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(this, Category.class);
	}

}
