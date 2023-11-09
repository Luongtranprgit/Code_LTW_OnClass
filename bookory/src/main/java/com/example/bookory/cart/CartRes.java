package com.example.bookory.cart;

public class CartRes {
	private int id;
	private String title;
	private String slug;
	private String author;
	private float price;
	private int quantity;
	public CartRes() {
		// TODO Auto-generated constructor stub
	}
	public String getAuthor() {
		return author;
	}
	public int getId() {
		return id;
	}
	public float getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getSlug() {
		return slug;
	}
	public String getTitle() {
		return title;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setSlug(String slug) {
		this.slug = slug;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
