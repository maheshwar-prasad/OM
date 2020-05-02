package com.umang.springmvc.model;

public class AddCart {
  private Double price;
  private int productId;
  private String sessionCode;
  private String itemDesc;
  private String itemName;
  private String imagePath;
  private long userId;

  
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getSessionCode() {
	return sessionCode;
}
public void setSessionCode(String sessionCode) {
	this.sessionCode = sessionCode;
}
public String getItemDesc() {
	return itemDesc;
}
public void setItemDesc(String itemDesc) {
	this.itemDesc = itemDesc;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getImagePath() {
	return imagePath;
}
public void setImagePath(String imagePath) {
	this.imagePath = imagePath;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
}
