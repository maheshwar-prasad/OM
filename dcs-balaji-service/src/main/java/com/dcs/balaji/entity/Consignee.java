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

import com.dcs.balaji.model.ConsigneeDto;

@Entity
@Table(name = "consignee_profile", uniqueConstraints = { @UniqueConstraint(columnNames = { "mob" }) })
@DynamicUpdate
public class Consignee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6879939595645435648L;

	private Integer id;

	private String plotNo;

	private String roadName;

	private String area;

	private String pincode;

	private String landMark;

	private String consigneeName;

	private String consigneeImage;

	private String email;

	private String mob;

	private String addressLine1;

	private String addressLine2;

	private boolean active;

	public Consignee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Consignee(Integer id) {
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

	@Column(name = "land_mark", length = 100)
	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	@Column(name = "consignee_name", nullable = false, length = 50)
	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	@Column(name = "consignee_image", length = 100)
	public String getConsigneeImage() {
		return consigneeImage;
	}

	public void setConsigneeImage(String consigneeImage) {
		this.consigneeImage = consigneeImage;
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

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Transient
	public ConsigneeDto model() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(this, ConsigneeDto.class);
	}

}
