package com.ecommerce.www.model;

import java.util.Date;
public class Order {
	
	private Integer orderId;
	private String orderNumber;
	private Date creationDate;
	private Date deliveryDate;
	public Order() {
	}
	public Order(Integer orderId, String orderNumber, Date creationDate, Date deliveryDate) {
		super();
		this.orderId = orderId;
		this.orderNumber = orderNumber;
		this.creationDate = creationDate;
		this.deliveryDate = deliveryDate;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public Date getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNumber=" + orderNumber + ", creationDate=" + creationDate + ", deliveryDate="
				+ deliveryDate + "]";
	}
	
	
	

}
