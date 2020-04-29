package com.dcs.balaji.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "otp_list")
public class OtpList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -171172041815610397L;

	private Integer id;

	private Integer otp;

	private String mob;

	private boolean expiried;

	private Date updatedOn = new Date();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "otp", nullable = false, length = 6)
	public Integer getOtp() {
		return otp;
	}

	public void setOtp(Integer otp) {
		this.otp = otp;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	@Column(name = "expiried", nullable = false)
	public boolean isExpiried() {
		return expiried;
	}

	public void setExpiried(boolean expiried) {
		this.expiried = expiried;
	}

	@Column(name = "updated_on", nullable = false)
	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public OtpList withUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
		return this;
	}
}
