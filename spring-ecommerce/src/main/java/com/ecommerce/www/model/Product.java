package com.ecommerce.www.model;

public class Product {
	
	private Integer productId;
	private String productName;
	private String productDescription;
	private String productImage;
	private String productPrice;
	private int ProductQuantity;
	
	
	
	public Product() {
	}
	public Product(Integer productId, String productName, String productDescription, String productImage, String productPrice,
			int productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productPrice = productPrice;
		ProductQuantity = productQuantity;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public int getProductQuantity() {
		return ProductQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		ProductQuantity = productQuantity;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDescription=" + productDescription
				+ ", productImage=" + productImage + ", productPrice=" + productPrice + ", ProductQuantity="
				+ ProductQuantity + "]";
	}
	
	

}
