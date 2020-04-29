package com.dcs.balaji.model;

import java.io.Serializable;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import com.dcs.balaji.enm.OrderStatus;
import com.dcs.balaji.entity.Orders;
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
@JacksonXmlRootElement(localName = "order")
@JsonPropertyOrder
@ApiModel(description = "A response class responde back to request")
public class OrdersDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9075823474279779577L;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("qty")
	private Integer qty;

	@JsonProperty("amount")
	private Double amount;

	@JsonProperty("order_date")
	private Date orderDate;

	@JsonProperty("items")
	private ItemsDto itemsDto;

	@JsonProperty("order_status")
	private OrderStatus orderStatus;

	@JsonProperty("sales_order")
	private SalesOrderDto salesOrderDto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public ItemsDto getItemsDto() {
		return itemsDto;
	}

	public void setItemsDto(ItemsDto itemsDto) {
		this.itemsDto = itemsDto;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public SalesOrderDto getSalesOrderDto() {
		return salesOrderDto;
	}

	public void setSalesOrderDto(SalesOrderDto salesOrderDto) {
		this.salesOrderDto = salesOrderDto;
	}

	public Orders entity() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Orders orders = new Orders();
		if (this.itemsDto != null)
			orders.setItems(this.itemsDto.entity());
		if (this.salesOrderDto != null)
			orders.setSalesOrder(this.salesOrderDto.entity());

		mapper.map(this, orders);

		return orders;
	}

}
