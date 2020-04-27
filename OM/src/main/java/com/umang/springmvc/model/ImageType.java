package com.umang.springmvc.model;

public enum ImageType {

	SI("Shop Image"), CI("Customer Image"), II("Item Image");

	String type;

	private ImageType(String type) {
		this.type = type;
	}

	public String type() {
		return type;
	}
}
