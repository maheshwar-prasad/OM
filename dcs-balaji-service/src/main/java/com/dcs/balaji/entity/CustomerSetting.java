package com.dcs.balaji.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "customer_setting")
@DynamicUpdate
public class CustomerSetting implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7170484567985610916L;

	private Integer id;

	private boolean regRequired;

	private boolean active;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "reg_required", nullable = false)
	public boolean isRegRequired() {
		return regRequired;
	}

	public void setRegRequired(boolean regRequired) {
		this.regRequired = regRequired;
	}

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
