package com.atguigu.inter.action;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("userName="+userName);
		
		return SUCCESS;
	}

}
