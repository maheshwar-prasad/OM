package com.umang.springmvc.entities;

import java.io.Serializable;
import java.util.List;

public class ItemListWithCategory implements Serializable {

	/**
	 * @author Maheshwar.Prasad
	 */
	private static final long serialVersionUID = 8158760178012218893L;
	private String status;
	private List<AppItemList> itemData;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<AppItemList> getItemData() {
		return itemData;
	}
	public void setItemData(List<AppItemList> itemData) {
		this.itemData = itemData;
	}
	

}
