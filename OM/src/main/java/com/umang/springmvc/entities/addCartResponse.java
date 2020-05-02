package com.umang.springmvc.entities;

import java.util.List;

import com.umang.springmvc.model.AddCart;

public class addCartResponse {
	private String status;
	private String message;
	private List<AddCart>  addcartData;
	private int count;
	private Double totalamount;
	private AppUser user;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<AddCart> getAddcartData() {
		return addcartData;
	}
	public void setAddcartData(List<AddCart> addcartData) {
		this.addcartData = addcartData;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(Double totalamount) {
		this.totalamount = totalamount;
	}
	public AppUser getUser() {
		return user;
	}
	public void setUser(AppUser user) {
		this.user = user;
	}

	
	

}
