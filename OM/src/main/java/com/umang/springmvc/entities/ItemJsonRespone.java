package com.umang.springmvc.entities;

import java.util.Map;

public class ItemJsonRespone {

	 private Item item;
	   private boolean validated;
	   private Map<String, String> errorMessages;
	   
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}
}
