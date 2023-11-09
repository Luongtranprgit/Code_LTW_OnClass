package com.example.bookory.comment;

import jakarta.persistence.Column;

public class CommentRes {
	private int id;
	private String userName;
	private int avatar;
	private float rate;
	private String content;
	private String timeUp;
	public CommentRes() {
		// TODO Auto-generated constructor stub
	}
	public void setAvatar(int avatar) {
		this.avatar = avatar;
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
	public void setTimeUp(String timeUp) {
		this.timeUp = timeUp;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getAvatar() {
		return avatar;
	}
	public String getContent() {
		return content;
	}
	public int getId() {
		return id;
	}
	public float getRate() {
		return rate;
	}
	public String getTimeUp() {
		return timeUp;
	}
	public String getUserName() {
		return userName;
	}
}
