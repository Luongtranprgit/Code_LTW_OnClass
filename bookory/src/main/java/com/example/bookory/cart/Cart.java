package com.example.bookory.cart;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cart")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="bookid")
	private int bookid;
	@Column(name="userid")
	private int userid;
	@Column(name="quantity")
	private int quantity;
	@Column(name="status")
	private String status;
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public int getBookid() {
		return bookid;
	}
	public int getQuantity() {
		return quantity;
	}
	public String getStatus() {
		return status;
	}
	public int getUserid() {
		return userid;
	}
	
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
