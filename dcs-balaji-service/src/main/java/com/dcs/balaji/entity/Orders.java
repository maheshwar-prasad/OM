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

import org.hibernate.annotations.DynamicUpdate;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.dcs.balaji.enm.OrderStatus;
import com.dcs.balaji.model.OrdersDto;

@Entity
@Table(name = "orders")
@DynamicUpdate
public class Orders implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2267240233076711092L;

	private Integer id;

	private Integer qty;

	private Double amount;

	private Date orderDate;

	private Items items;

	private OrderStatus orderStatus;

	private SalesOrder salesOrder;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Integer id) {
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

	@Column(name = "qty", nullable = false)
	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	@Column(name = "amount", nullable = false)
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Column(name = "order_date", nullable = false)
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false, referencedColumnName = "id")
	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status", nullable = false)
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@ManyToOne
	@JoinColumn(name = "sales_order_id", referencedColumnName = "id")
	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	public Orders withSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
		return this;
	}

	@Transient
	public OrdersDto model() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		OrdersDto orders = new OrdersDto();
		Items items = this.getItems();
		SalesOrder salesOrder = this.getSalesOrder();
		if (items != null)
			orders.setItemsDto(items.model());
//		if (salesOrder != null)
//			orders.setSalesOrderDto(salesOrder.model());

		mapper.map(this, orders);

		return orders;
	}

}
