package com.userlogin;

public class User {
	private String userName;
	private String password;
	private String name;
	private String role;
	
	public User(String[] details) {
		this.userName = details[0];
		this.password = details[1];
		this.name = details[2];
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User() {}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
