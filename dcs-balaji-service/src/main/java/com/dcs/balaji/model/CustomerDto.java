package com.dcs.balaji.model;

import java.io.Serializable;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.dcs.balaji.entity.Customer;
import com.dcs.common.constant.CommonConstant;
import com.dcs.validation.annotation.Validate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import io.swagger.annotations.ApiModel;

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
@ApiModel(description = "A response class responde back to request")
public class CustomerDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7708056439011238247L;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("shop_name")
	@Validate(min = 2, max = 100, nullable = false, column = "shop_name")
	private String shopName;

	@JsonProperty("gst_no")
	@Validate(min = 10, max = 20, nullable = false, column = "gst_no", regex = CommonConstant.RegexPatternConstant.GST_REGEX)
	private String gstNo;

	@JsonProperty("plot_no")
	@Validate(max = 100, column = "plot_no")
	private String plotNo;

	@JsonProperty("road_name")
	@Validate(max = 100, column = "road_name")
	private String roadName;

	@JsonProperty("area")
	@Validate(max = 100, column = "area")
	private String area;

	@JsonProperty("pincode")
	@Validate(min = 6, max = 6, nullable = false, column = "pincode", regex = CommonConstant.RegexPatternConstant.PINCODE_PATTERN)
	private String pincode;

	@JsonProperty("address_line1")
	@Validate(min = 5, max = 200, nullable = false, column = "address_line1")
	private String addressLine1;

	@JsonProperty("address_line2")
	@Validate(max = 200, column = "address_line1")
	private String addressLine2;

	@JsonProperty("land_mark")
	@Validate(max = 100, column = "land_mark")
	private String landMark;

	@JsonProperty("shop_phone")
	@Validate(max = 15, column = "shop_phone")
	private String shopPhone;

	@JsonProperty("state_name")
	@Validate(min = 2, max = 100, nullable = false, column = "state_name")
	private String stateName;

	@JsonProperty("state_gst_code")
	@Validate(min = 2, max = 3, nullable = false, column = "state_gst_code")
	private String stateGstCode;

	@JsonProperty("city")
	@Validate(min = 2, max = 50, nullable = false, column = "city")
	private String city;

	@JsonProperty("shop_image")
	private String shopImage;

	@JsonProperty("person_name")
	@Validate(min = 1, max = 100, nullable = false, column = "person_name")
	private String personName;

	@JsonProperty("person_image")
	private String personImage;

	@JsonProperty("email")
	@Validate(min = 10, max = 100, nullable = false, column = "email")
	private String email;

	@JsonProperty("mob")
	@Validate(min = 10, max = 10, nullable = false, column = "mob", regex = CommonConstant.RegexPatternConstant.MOBILE_PATTERN)
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

	public Customer entity() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(this, Customer.class);
	}

}
