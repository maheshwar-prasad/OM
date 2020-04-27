package com.umang.springmvc.item.entities;

public class ItemsDto {
	/**
	 * 
	 * @author Maheshwar.Prasad
	 */
	private long id;
	private String item_code;
	private String item_image;
	private String item_name;
	private String offer_effected_by;
	private String offer_till;
	private String offer_type;
	private String pack;
	private String updated_on;
	private int    free;
	private int    display_order;
	private boolean active;
	private int    offer_units;
	private double unit_price;
	private double mrp;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_image() {
		return item_image;
	}
	public void setItem_image(String item_image) {
		this.item_image = item_image;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getOffer_effected_by() {
		return offer_effected_by;
	}
	public void setOffer_effected_by(String offer_effected_by) {
		this.offer_effected_by = offer_effected_by;
	}
	public String getOffer_till() {
		return offer_till;
	}
	public void setOffer_till(String offer_till) {
		this.offer_till = offer_till;
	}
	public String getOffer_type() {
		return offer_type;
	}
	public void setOffer_type(String offer_type) {
		this.offer_type = offer_type;
	}
	public String getPack() {
		return pack;
	}
	public void setPack(String pack) {
		this.pack = pack;
	}
	public String getUpdated_on() {
		return updated_on;
	}
	public void setUpdated_on(String updated_on) {
		this.updated_on = updated_on;
	}
	public int getFree() {
		return free;
	}
	public void setFree(int free) {
		this.free = free;
	}
	public int getDisplay_order() {
		return display_order;
	}
	public void setDisplay_order(int display_order) {
		this.display_order = display_order;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getOffer_units() {
		return offer_units;
	}
	public void setOffer_units(int offer_units) {
		this.offer_units = offer_units;
	}
	public double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	
	
	
}
