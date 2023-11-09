package com.example.bookory.cart;

import java.util.List;

public class Order {
	private String id;
	private List<CartRes> products;
	private float total;
	public Order() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public List<CartRes> getProducts() {
		return products;
	}
	public float getTotal() {
		return total;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setProducts(List<CartRes> products) {
		this.products = products;
	}
	public void setTotal(float total) {
		this.total = total;
	}
}
