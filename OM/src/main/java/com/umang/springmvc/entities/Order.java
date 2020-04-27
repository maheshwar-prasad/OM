package com.umang.springmvc.entities;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable{

	/**
	 * @author Maheshwar.Prasad
	 */
	private static final long serialVersionUID = -4664474926279281979L;
	
	private long id;
	private String itemName;
	private String orderNo;
	private String status;
	private String category;
	private String quantity;
	private long itemId;
	private String amount;
	private String rate;
	private String pack;
	private String discount;
	private String delAddress;
	private List<Item> orderItemData;
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
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRate() {
		return rate;
	}
	public void setRate(String rate) {
		this.rate = rate;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getDiscount() {
		return discount;
	}
	public void setDiscount(String discount) {
		this.discount = discount;
	}
	public String getDelAddress() {
		return delAddress;
	}
	public void setDelAddress(String delAddress) {
		this.delAddress = delAddress;
	}
	public List<Item> getOrderItemData() {
		return orderItemData;
	}
	public void setOrderItemData(List<Item> orderItemData) {
		this.orderItemData = orderItemData;
	}
	
	

}
