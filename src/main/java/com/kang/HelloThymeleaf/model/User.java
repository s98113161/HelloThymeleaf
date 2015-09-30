package com.kang.HelloThymeleaf.model;
//checkout
public class User {
	int userId;
	String userName, userRole;
	boolean userEnable;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public boolean isUserEnable() {
		return userEnable;
	}

	public void setUserEnable(boolean userEnable) {
		this.userEnable = userEnable;
	}
}
