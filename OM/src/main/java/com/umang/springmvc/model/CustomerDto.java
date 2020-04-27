package com.umang.springmvc.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//import io.swagger.annotations.ApiModel;

/**
 * 
 * @author deepak
 * @since 19 January 2020
 * @version 1.0
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "customer")
@JsonPropertyOrder
//@ApiModel(description = "A response class responde back to request")
public class CustomerDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7708056439011238247L;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("shop_name")
	@NotNull
	private String shopName;

	@JsonProperty("gst_no")
	@NotNull
	private String gstNo;

	@JsonProperty("plot_no")
	private String plotNo;

	@JsonProperty("road_name")
	private String roadName;

	@JsonProperty("area")
	private String area;

	@JsonProperty("pincode")
	@NotNull
	private String pincode;

	@JsonProperty("land_mark")
	private String landMark;

	@JsonProperty("shop_phone")
	private String shopPhone;

	@JsonProperty("state_name")
	@NotNull
	private String stateName;

	@JsonProperty("state_gst_code")
	@NotNull
	private String stateGstCode;

	@JsonProperty("city")
	@NotNull
	private String city;

	@JsonProperty("shop_image")
	private String shopImage;

	@JsonProperty("person_name")
	@NotNull
	private String personName;

	@JsonProperty("person_image")
	private String personImage;

	@JsonProperty("email")
	@NotNull
	private String email;

	@JsonProperty("mob")
	@NotNull
	private String mob;

	@JsonProperty("active")
	private boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getStateGstCode() {
		return stateGstCode;
	}

	public void setStateGstCode(String stateGstCode) {
		this.stateGstCode = stateGstCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getShopImage() {
		return shopImage;
	}

	public void setShopImage(String shopImage) {
		this.shopImage = shopImage;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getPersonImage() {
		return personImage;
	}

	public void setPersonImage(String personImage) {
		this.personImage = personImage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", shopName=" + shopName + ", gstNo=" + gstNo + ", plotNo=" + plotNo
				+ ", roadName=" + roadName + ", area=" + area + ", pincode=" + pincode + ", landMark=" + landMark
				+ ", shopPhone=" + shopPhone + ", stateName=" + stateName + ", stateGstCode=" + stateGstCode + ", city="
				+ city + ", shopImage=" + shopImage + ", personName=" + personName + ", personImage=" + personImage
				+ ", email=" + email + ", mob=" + mob + ", active=" + active + "]";
	}

}
