package com.umang.springmvc.entities;

import org.hibernate.validator.constraints.NotEmpty;

public class ItemType {
	
	   @NotEmpty(message="Enter first name.")
	   private String itemTypeName;
	   
	   private String status;
	   
	   private long id;

	public String getItemTypeName() {
		return itemTypeName;
	}

	public void setItemTypeName(String itemTypeName) {
		this.itemTypeName = itemTypeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	  

}
