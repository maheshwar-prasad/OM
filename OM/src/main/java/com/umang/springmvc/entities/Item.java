package com.umang.springmvc.entities;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

public class Item implements Serializable {
	
	private static final long serialVersionUID = 4786372353070030255L;
	private long id;
	@NotEmpty(message="Enter itemName.")
	private String itemName;
	@NotEmpty(message="Enter quantity.")
	private String quantity;
	@NotEmpty(message="Enter availableQty.")
	private String availableQty;
	@NotEmpty(message="Enter oldPrice.")
	private String oldPrice;
	@NotEmpty(message="Enter currentPrice.")
	private String currentPrice;
	@NotEmpty(message="Enter pack.")
	private String pack;
	@NotEmpty(message="Enter status.")
	private String status;
	private String imagepath;
	private String type;
	private String typeName;
	private MultipartFile file;
	private String category;
	
	private String created_date;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getAvailableQty() {
		return availableQty;
	}

	public void setAvailableQty(String availableQty) {
		this.availableQty = availableQty;
	}

	public String getOldPrice() {
		return oldPrice;
	}

	public void setOldPrice(String oldPrice) {
		this.oldPrice = oldPrice;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}
