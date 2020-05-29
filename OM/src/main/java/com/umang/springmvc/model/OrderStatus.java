package com.umang.springmvc.model;

public enum OrderStatus {
	C("Cancelled"), R("Rejected"), P("Pending"), A("Accepted"), D("Delivered");

	String type;

	private OrderStatus(String type) {
		this.type = type;
	}

	public String type() {
		return type;
	}
}
