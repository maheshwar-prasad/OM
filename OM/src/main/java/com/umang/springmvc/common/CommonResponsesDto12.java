package com.umang.springmvc.common;

import java.util.List;

import com.umang.springmvc.item.entities.ItemsDto;

public class CommonResponsesDto12 {
	
	private int page;
	private String status_code;
	private String message;
	private List<ItemsDto> data;

	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getStatus_code() {
		return status_code;
	}
	public void setStatus_code(String status_code) {
		this.status_code = status_code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ItemsDto> getData() {
		return data;
	}
	public void setData(List<ItemsDto> data) {
		this.data = data;
	}
}
