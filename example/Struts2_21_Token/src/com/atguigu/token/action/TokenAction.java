package com.atguigu.token.action;

import com.opensymphony.xwork2.ActionSupport;

public class TokenAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String password;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("userName="+userName+" password="+password);
		
		return SUCCESS;
	}

}
