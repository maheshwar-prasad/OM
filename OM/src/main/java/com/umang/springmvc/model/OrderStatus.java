package com.umang.springmvc.model;

public enum OrderStatus {
	R("Rejected"), P("Pending"), A("Approved"), D("Delivered");

	String type;

	private OrderStatus(String type) {
		this.type = type;
	}

	public String type() {
		return type;
	}
}
