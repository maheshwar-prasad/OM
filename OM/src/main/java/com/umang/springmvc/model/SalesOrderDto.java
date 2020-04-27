package com.umang.springmvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//import io.swagger.annotations.ApiModel;

/**
 * 
 * @author deepak
 * @since 19 January 2020
 * @version 1.0
 *
 */
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JacksonXmlRootElement(localName = "sales_orders")
@JsonPropertyOrder
//@ApiModel(description = "A response class responde back to request")
public class SalesOrderDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7418940048311132098L;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("order_number")
	private String orderNumber;

	@JsonProperty("total_amount")
	private Double totalAmount;

	@JsonProperty("order_date")
	private Date orderDate = new Date();

	@JsonProperty("order_status")
	private OrderStatus orderStatus;

	@JsonProperty("rejected_on")
	private Date rejectedOn;

	@JsonProperty("accepted_on")
	private Date acceptedOn;

	@JsonProperty("delivered_on")
	private Date deliveredOn;

	@JsonProperty("remark")
	private String remark;

	@JsonProperty("cancelled_by")
	private CancelledBy cancelledBy;

	@JsonProperty("customer")
	private CustomerDto customerDto;

	private Set<OrdersDto> ordersDtos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getRejectedOn() {
		return rejectedOn;
	}

	public void setRejectedOn(Date rejectedOn) {
		this.rejectedOn = rejectedOn;
	}

	public Date getAcceptedOn() {
		return acceptedOn;
	}

	public void setAcceptedOn(Date acceptedOn) {
		this.acceptedOn = acceptedOn;
	}

	public Date getDeliveredOn() {
		return deliveredOn;
	}

	public void setDeliveredOn(Date deliveredOn) {
		this.deliveredOn = deliveredOn;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public CancelledBy getCancelledBy() {
		return cancelledBy;
	}

	public void setCancelledBy(CancelledBy cancelledBy) {
		this.cancelledBy = cancelledBy;
	}

	public CustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(CustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public Set<OrdersDto> getOrdersDtos() {
		return ordersDtos;
	}

	public void setOrdersDtos(Set<OrdersDto> ordersDtos) {
		this.ordersDtos = ordersDtos;
	}

}
