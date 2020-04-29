package com.dcs.balaji.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.dcs.balaji.model.CategoryDto;
import com.dcs.datasource.annotation.Searchable;

@Entity
@Table(name = "category", uniqueConstraints = { @UniqueConstraint(columnNames = { "category_name" }) })
@DynamicUpdate
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1830222104909248537L;

	private Integer id;

	@Searchable
	private String categoryName;

	private Integer displayOrder;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Integer id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "category_name", nullable = false, length = 100)
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

	@Transient
	public CategoryDto model() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(this, CategoryDto.class);
	}

}
