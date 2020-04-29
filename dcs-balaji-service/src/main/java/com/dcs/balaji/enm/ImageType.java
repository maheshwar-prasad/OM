package com.dcs.balaji.enm;

public enum ImageType {

	SI("Shop Image"), CI("Customer Image"), II("Item Image"), CSI("Consignee Image");

	String type;

	private ImageType(String type) {
		this.type = type;
	}

	public String type() {
		return type;
	}
}
