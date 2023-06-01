package com.example.feignclient.model;





public class Products {
	Integer productId;
	String name;
	String category;
	String brand;
	double price;
	
	public Products() {
		
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Products(Integer productId, String name, String category, String brand, double price) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", name=" + name + ", category=" + category + ", brand=" + brand
				+ ", price=" + price + "]";
	}
	
	
	
	
	
	

}
