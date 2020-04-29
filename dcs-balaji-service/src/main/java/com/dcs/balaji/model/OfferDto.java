package com.dcs.balaji.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.dcs.balaji.enm.PurchaseType;
import com.dcs.balaji.entity.Offer;
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
@JacksonXmlRootElement(localName = "offer_dto")
@JsonPropertyOrder
@ApiModel(description = "A response class responde back to request")
public class OfferDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8805043944821366380L;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("offer_name")
	@Validate(min = 5, max = 100, nullable = false, column = "offer_name")
	private String offerName;

	@JsonProperty("items")
	private ItemsDto itemsDto;

	@JsonProperty("purchase_type")
	@NotNull
	private PurchaseType type;

	@JsonProperty("gift")
	@NotNull
	private Integer gift;

	@JsonProperty("on_purchase_off")
	@NotNull
	private Integer purchase;

	@JsonProperty("duration_from")
	@NotNull
	private Date durationFrom;

	@JsonProperty("duration_to")
	@NotNull
	private Date durationTo;

	@JsonProperty("duration")
	private String duration;

	@JsonProperty("active")
	private boolean active;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOfferName() {
		return offerName;
	}

	public void setOfferName(String offerName) {
		this.offerName = offerName;
	}

	public ItemsDto getItemsDto() {
		return itemsDto;
	}

	public void setItemsDto(ItemsDto itemsDto) {
		this.itemsDto = itemsDto;
	}

	public PurchaseType getType() {
		return type;
	}

	public void setType(PurchaseType type) {
		this.type = type;
	}

	public Integer getGift() {
		return gift;
	}

	public void setGift(Integer gift) {
		this.gift = gift;
	}

	public Integer getPurchase() {
		return purchase;
	}

	public void setPurchase(Integer purchase) {
		this.purchase = purchase;
	}

	public Date getDurationFrom() {
		return durationFrom;
	}

	public void setDurationFrom(Date durationFrom) {
		this.durationFrom = durationFrom;
	}

	public Date getDurationTo() {
		return durationTo;
	}

	public void setDurationTo(Date durationTo) {
		this.durationTo = durationTo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Offer model() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Offer offer = new Offer();
		offer.setItems(this.itemsDto.entity());
		mapper.map(this, offer);
		return offer;
	}

}
