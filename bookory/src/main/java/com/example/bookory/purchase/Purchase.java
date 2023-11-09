package com.example.bookory.purchase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Purchase")
public class Purchase {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="orderid")
	private String orderid;
	@Column(name="status")
	private String status;
	
	public Purchase() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public String getOrderid() {
		return orderid;
	}
	public String getStatus() {
		return status;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
