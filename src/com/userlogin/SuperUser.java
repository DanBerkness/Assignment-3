package com.userlogin;

public class SuperUser extends User {
	public SuperUser(String userName, String password, String name) {
		this.setUserName(userName);
		this.setPassword(password);
		this.setName(name);
		this.role = "super_user";
	}
}
