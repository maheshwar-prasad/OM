package com.dcs.balaji.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.dcs.balaji.model.StockDto;

@Entity
@Table(name = "stock")
@DynamicUpdate
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8149954117905024301L;

	private Items items;

	private Integer qty;

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stock(Items items, Integer qty) {
		super();
		this.items = items;
		this.qty = qty;
	}

	@OneToOne
	@JoinColumn(name = "item_id", nullable = false, referencedColumnName = "id")
	@Id
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Column(name = "qty", nullable = false)
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Transient
	public StockDto model() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		StockDto stock = new StockDto();
		stock.setDto(items.model());
		mapper.map(this, stock);
		return stock;
	}

}
