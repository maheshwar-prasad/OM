package com.dcs.balaji.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.dcs.balaji.model.CustomerDto;

@Entity
@Table(name = "customer_profile", uniqueConstraints = { @UniqueConstraint(columnNames = { "shop_name", "gst_no" }),
		@UniqueConstraint(columnNames = { "mob" }) })
@DynamicUpdate
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2946973015832304952L;

	private Integer id;

	private String shopName;

	private String gstNo;

	private String plotNo;

	private String roadName;

	private String area;

	private String pincode;

	private String addressLine1;

	private String addressLine2;

	private String landMark;

	private String shopPhone;

	private String stateName;

	private String stateGstCode;

	private String city;

	private String shopImage;

	private String personName;

	private String personImage;

	private String email;

	private String mob;

	private boolean active;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id) {
		super();
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "shop_name", nullable = false, length = 100)
	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Column(name = "gst_no", nullable = false, length = 20)
	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	@Column(name = "plot_no", length = 100)
	public String getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	@Column(name = "road_name", length = 100)
	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	@Column(name = "area", length = 100)
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "pincode", nullable = false, length = 6)
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Column(name = "address_line1", nullable = false, length = 200)
	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	@Column(name = "address_line2", length = 200)
	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	@Column(name = "land_mark", length = 100)
	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	@Column(name = "shop_phone", length = 15)
	public String getShopPhone() {
		return shopPhone;
	}

	public void setShopPhone(String shopPhone) {
		this.shopPhone = shopPhone;
	}

	@Column(name = "state_name", nullable = false, length = 100)
	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Column(name = "state_gst_code", nullable = false, length = 3)
	public String getStateGstCode() {
		return stateGstCode;
	}

	public void setStateGstCode(String stateGstCode) {
		this.stateGstCode = stateGstCode;
	}

	@Column(name = "city", nullable = false, length = 50)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "shop_image", length = 200)
	public String getShopImage() {
		return shopImage;
	}

	public void setShopImage(String shopImage) {
		this.shopImage = shopImage;
	}

	@Column(name = "person_name", nullable = false, length = 100)
	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	@Column(name = "person_image", length = 200)
	public String getPersonImage() {
		return personImage;
	}

	public void setPersonImage(String personImage) {
		this.personImage = personImage;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "mob", nullable = false, length = 10)
	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Transient
	public CustomerDto model() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(this, CustomerDto.class);
	}

}
