package com.example.bookory.user;

import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "pass")
	private String pass;
	@Column(name = "userrole")
	private String userrole;
	@Column(name = "avatar")
	private int avatar;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getPass() {
		return pass;
	}

	public String getUsername() {
		return username;
	}

	public int getAvatar() {
		return avatar;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setAvatar(int avatar) {
		this.avatar = avatar;
	}
}
