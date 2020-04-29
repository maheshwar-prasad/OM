package com.dcs.balaji.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.dcs.balaji.enm.PurchaseType;
import com.dcs.balaji.model.OfferDto;

@Entity
@Table(name = "offer", uniqueConstraints = { @UniqueConstraint(columnNames = { "offer_name" }) })
@DynamicUpdate
public class Offer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4616493134946837796L;

	private Integer id;

	private String offerName;

	private Items items;

	private PurchaseType type;

	private Integer gift;

	private Integer purchase;

	private Date durationFrom;

	private Date durationTo;

	private String duration;

	private boolean active;

	public Offer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Offer(Integer id) {
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

	@Column(name = "offer_name", nullable = false, length = 100)
	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	@ManyToOne
	@JoinColumn(name = "item_id", referencedColumnName = "id")
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "purchase_type", nullable = false, length = 1)
	public PurchaseType getType() {
		return type;
	}

	public void setType(PurchaseType type) {
		this.type = type;
	}

	@Column(name = "gift", nullable = false)
	public Integer getGift() {
		return gift;
	}

	public void setGift(Integer gift) {
		this.gift = gift;
	}

	@Column(name = "purchase", nullable = false)
	public Integer getPurchase() {
		return purchase;
	}

	public void setPurchase(Integer purchase) {
		this.purchase = purchase;
	}

	@Column(name = "duration_from", nullable = false)
	public Date getDurationFrom() {
		return durationFrom;
	}

	public void setDurationFrom(Date durationFrom) {
		this.durationFrom = durationFrom;
	}

	@Column(name = "duration_to", nullable = false)
	public Date getDurationTo() {
		return durationTo;
	}

	public void setDurationTo(Date durationTo) {
		this.durationTo = durationTo;
	}

	@Column(name = "duration", nullable = false)
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Offer withDuration(String duration) {
		this.duration = duration;
		return this;
	}

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Transient
	public OfferDto model() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		OfferDto offer = new OfferDto();
		offer.setItemsDto(this.items.model());
		mapper.map(this, offer);
		return offer;
	}

}
