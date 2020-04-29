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

import com.dcs.balaji.enm.OfferType;
import com.dcs.balaji.model.ItemsDto;

@Entity
@Table(name = "items", uniqueConstraints = { @UniqueConstraint(columnNames = { "item_code", "item_name" }),
		@UniqueConstraint(columnNames = { "item_name", "pack" }) })
@DynamicUpdate
public class Items implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6997565774000962483L;

	private Integer id;

	private String itemCode;

	private String itemName;

	private Double unitPrice;

	private Double mrp;

	private String pack;

	private Integer offerUnits;

	private OfferType offerType;

	private Integer free;

	private Date offerTill;

	private Date offerEffectedBy;

	private String itemImage;

	private String description;

	private Integer displayOrder;

	private Category category;

	private boolean active;

	private Date updatedOn = new Date();

	public Items() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Items(Integer id) {
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

	@Column(name = "item_code", nullable = false, length = 20, updatable = false)
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public Items withItemCode(String itemCode) {
		this.itemCode = itemCode;
		return this;
	}

	@Column(name = "item_name", nullable = false, length = 100)
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Column(name = "unit_price", nullable = false)
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "mrp", nullable = false)
	public Double getMrp() {
		return mrp;
	}

	public void setMrp(Double mrp) {
		this.mrp = mrp;
	}

	@Column(name = "pack", nullable = false, length = 50)
	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	@Column(name = "offer_unit")
	public Integer getOfferUnits() {
		return offerUnits;
	}

	public void setOfferUnits(Integer offerUnits) {
		this.offerUnits = offerUnits;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "offer_type")
	public OfferType getOfferType() {
		return offerType;
	}

	public void setOfferType(OfferType offerType) {
		this.offerType = offerType;
	}

	@Column(name = "free")
	public Integer getFree() {
		return free;
	}

	public void setFree(Integer free) {
		this.free = free;
	}

	@Column(name = "offore_till", nullable = false)
	public Date getOfferTill() {
		return offerTill;
	}

	public void setOfferTill(Date offerTill) {
		this.offerTill = offerTill;
	}

	@Column(name = "offore_effected_by", nullable = false)
	public Date getOfferEffectedBy() {
		return offerEffectedBy;
	}

	public void setOfferEffectedBy(Date offerEffectedBy) {
		this.offerEffectedBy = offerEffectedBy;
	}

	@Column(name = "item_image", length = 200)
	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	@Column(name = "description", length = 250)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "display_order")
	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "id")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "active", nullable = false)
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Column(name = "updated_on", nullable = false)
	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Transient
	public ItemsDto model() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ItemsDto dto = new ItemsDto();
		Category category = this.getCategory();
		if (category != null)
			dto.setProductCat(category.model());
		mapper.map(this, dto);
		return dto;
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
		Items other = (Items) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
