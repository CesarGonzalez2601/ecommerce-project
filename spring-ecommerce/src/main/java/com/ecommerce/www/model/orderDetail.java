package com.ecommerce.www.model;

public class orderDetail {

	private Integer detailId;
	private String orderName;
	private double orderQantity;
	private double orderPrice;
	private double orderTotal;
	
	public orderDetail() {
	}
	
	

	public orderDetail(Integer detailId, String orderName, double orderQantity, double orderPrice, double orderTotal) {
		super();
		this.detailId = detailId;
		this.orderName = orderName;
		this.orderQantity = orderQantity;
		this.orderPrice = orderPrice;
		this.orderTotal = orderTotal;
	}



	public Integer getDetailId() {
		return detailId;
	}

	public void setDetailId(Integer detailId) {
		this.detailId = detailId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public double getOrderQantity() {
		return orderQantity;
	}

	public void setOrderQantity(double orderQantity) {
		this.orderQantity = orderQantity;
	}

	public double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
	
}
