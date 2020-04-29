package com.dcs.balaji.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.dcs.balaji.enm.CancelledBy;
import com.dcs.balaji.enm.OrderStatus;
import com.dcs.balaji.model.SalesOrderDto;

@Entity
@Table(name = "sales_orders", uniqueConstraints = { @UniqueConstraint(columnNames = { "order_number" }) })
@DynamicUpdate
public class SalesOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8152262306101704506L;

	private Integer id;

	private String orderNumber;

	private Double totalAmount;

	private Date orderDate;

	private OrderStatus orderStatus;

	private Date rejectedOn;

	private Date acceptedOn;

	private Date deliveredOn;

	private String remark;

	private CancelledBy cancelledBy;

	private Customer customer;

	private Consignee consignee;

	private Set<Orders> orders;

	public SalesOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalesOrder(Integer id) {
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

	@Column(name = "order_number", nullable = false, length = 20, updatable = false)
	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public SalesOrder withOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
		return this;
	}

	@Column(name = "total_amount", nullable = false)
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Column(name = "order_date", nullable = false, updatable = false)
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "order_status", nullable = false)
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "rejected_on")
	public Date getRejectedOn() {
		return rejectedOn;
	}

	public void setRejectedOn(Date rejectedOn) {
		this.rejectedOn = rejectedOn;
	}

	@Column(name = "accepted_on")
	public Date getAcceptedOn() {
		return acceptedOn;
	}

	public void setAcceptedOn(Date acceptedOn) {
		this.acceptedOn = acceptedOn;
	}

	@Column(name = "delivered_on")
	public Date getDeliveredOn() {
		return deliveredOn;
	}

	public void setDeliveredOn(Date deliveredOn) {
		this.deliveredOn = deliveredOn;
	}

	@Column(name = "remark", length = 200)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "cancelled_by")
	public CancelledBy getCancelledBy() {
		return cancelledBy;
	}

	public void setCancelledBy(CancelledBy cancelledBy) {
		this.cancelledBy = cancelledBy;
	}

	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne
	@JoinColumn(name = "consignee_id", referencedColumnName = "id")
	public Consignee getConsignee() {
		return consignee;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "sales_order_id")
	@Cascade(CascadeType.ALL)
	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	@Transient
	public SalesOrderDto model() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		SalesOrderDto order = new SalesOrderDto();
		Customer customer = this.getCustomer();
		Consignee consignee = this.getConsignee();
		if (customer != null)
			order.setCustomerDto(customer.model());
		if (consignee != null)
			order.setConsigneeDto(consignee.model());
		Set<Orders> orders = this.getOrders();
		if (orders != null)
			order.setOrdersDtos(orders.parallelStream().map(O -> O.model()).collect(Collectors.toSet()));
		mapper.map(this, order);
		return order;
	}

}
