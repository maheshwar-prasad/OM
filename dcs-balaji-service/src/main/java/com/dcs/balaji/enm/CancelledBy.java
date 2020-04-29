package com.dcs.balaji.enm;

public enum CancelledBy {
	C("Customer"), S("Saller");

	String type;

	private CancelledBy(String type) {
		this.type = type;
	}

	public String type() {
		return type;
	}
}
