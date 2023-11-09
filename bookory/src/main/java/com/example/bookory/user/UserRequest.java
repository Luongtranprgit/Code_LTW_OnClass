package com.example.bookory.user;

public class UserRequest {
	private String pass;
	private String username;
	private String email;
	public UserRequest(String name, String email, String pass) {
		this.pass = pass;
		this.username = name;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getPass() {
		return pass;
	}
}
