package com.umang.springmvc.model;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

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
@JacksonXmlRootElement(localName = "items")
@JsonPropertyOrder
public class ItemsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7991327702045267264L;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("item_code")
	private String itemCode;

	@JsonProperty("item_name")
	@NotNull
	private String itemName;

	@JsonProperty("unit_price")
	@NotNull
	private Double unitPrice;

	@JsonProperty("mrp")
	@NotNull
	private Double mrp;

	@JsonProperty("pack")
	@NotNull
	private String pack;

	@JsonProperty("offer_units")
	private Integer offerUnits;

	@JsonProperty("offer_type")
	private OfferType offerType;

	@JsonProperty("free")
	private Integer free;

	@JsonProperty("offer_till")
	private Date offerTill;

	@JsonProperty("offer_effected_by")
	private Date offerEffectedBy;

	@JsonProperty("item_image")
	private String itemImage;

	@JsonProperty("image_uri")
	private String imageUri;

	@JsonProperty("item_desc")
	private String description;

	@JsonProperty("display_order")
	private Integer displayOrder;

	@JsonProperty("active")
	private boolean active;

	@JsonProperty("updated_on")
	private Date updatedOn = new Date();

	@JsonProperty("product_category")
	private CategoryDto productCat;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public Integer getOfferUnits() {
		return offerUnits;
	}

	public void setOfferUnits(Integer offerUnits) {
		this.offerUnits = offerUnits;
	}

	public OfferType getOfferType() {
		return offerType;
	}

	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}

	public Integer getFree() {
		return free;
	}

	public void setFree(Integer free) {
		this.free = free;
	}

	public Date getOfferTill() {
		return offerTill;
	}

	public void setOfferTill(Date offerTill) {
		this.offerTill = offerTill;
	}

	public Date getOfferEffectedBy() {
		return offerEffectedBy;
	}

	public void setOfferEffectedBy(Date offerEffectedBy) {
		this.offerEffectedBy = offerEffectedBy;
	}

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public CategoryDto getProductCat() {
		return productCat;
	}

	public void setProductCat(CategoryDto productCat) {
		this.productCat = productCat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemsDto other = (ItemsDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
