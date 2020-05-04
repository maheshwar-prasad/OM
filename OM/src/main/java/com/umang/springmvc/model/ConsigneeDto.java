package com.umang.springmvc.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "consignee")
@JsonPropertyOrder
public class ConsigneeDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6649130747935060146L;

	@JsonProperty("id")
	private Integer id;

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

	@JsonProperty("consignee_name")
	@NotNull
	private String consigneeName;

	@JsonProperty("consignee_image")
	private String consigneeImage;

	@JsonProperty("email")
	@NotNull
	private String email;

	@JsonProperty("mob")
	@NotNull
	private String mob;

	@JsonProperty("address_line1")
	@NotNull
	private String addressLine1;

	@JsonProperty("address_line2")
	private String addressLine2;

	@JsonProperty("active")
	private boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeImage() {
		return consigneeImage;
	}

	public void setConsigneeImage(String consigneeImage) {
		this.consigneeImage = consigneeImage;
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

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
