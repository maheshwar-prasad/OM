package com.umang.springmvc.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * @author deepak
 * @since 19 January 2020
 * @version 1.0
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "saller_profile")
@JsonPropertyOrder
public class SallerProfileDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5606911299086251543L;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("gst_no")
	private String gstNo;

	@JsonProperty("company_name")
	private String companyName;

	@JsonProperty("user_name")
	private Integer userName;

	@JsonProperty("password")
	private String password;

	@JsonProperty("address1")
	private String address1;

	@JsonProperty("address2")
	private String address2;

	@JsonProperty("city_name")
	private String city;

	@JsonProperty("state_name")
	private String stateName;

	@JsonProperty("state_gst_code")
	private String stateGstCode;

	@JsonProperty("pincode")
	private String pincode;

	@JsonProperty("customer_care_no")
	private String ccNo;

	@JsonProperty("email")
	private String email;

	@JsonProperty("terms_key")
	private String termsKey;

	@JsonProperty("terms_uri")
	private String termsUri;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getUserName() {
		return userName;
	}

	public void setUserName(Integer userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCcNo() {
		return ccNo;
	}

	public void setCcNo(String ccNo) {
		this.ccNo = ccNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTermsKey() {
		return termsKey;
	}

	public void setTermsKey(String termsKey) {
		this.termsKey = termsKey;
	}

	public String getTermsUri() {
		return termsUri;
	}

	public void setTermsUri(String termsUri) {
		this.termsUri = termsUri;
	}

}
