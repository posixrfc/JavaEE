package com.atguigu.formtag.bean;

public class User {
	
	private String userName;
	private String userPwd;
	private String describ;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String userPwd, String describ) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.describ = describ;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getDescrib() {
		return describ;
	}

	public void setDescrib(String describ) {
		this.describ = describ;
	}
	
}
