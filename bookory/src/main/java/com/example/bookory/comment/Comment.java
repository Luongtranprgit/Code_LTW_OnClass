package com.example.bookory.comment;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="bookid")
	private int bookid;
	@Column(name="userid")
	private int userid;
	@Column(name="rate")
	private float rate;
	@Column(name="content")
	private String content;
	@Column(name="timeup")
	private String timeup;
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public int getBookid() {
		return bookid;
	}
	public String getContent() {
		return content;
	}
	public float getRate() {
		return rate;
	}
	public String getTimeup() {
		return timeup;
	}
	public int getUserid() {
		return userid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
	public void setTimeup(String timeup) {
		this.timeup = timeup;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
}
