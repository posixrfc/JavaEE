package com.atguigu.validation.action;

import com.opensymphony.xwork2.ActionSupport;

public class ValidationAction03 extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private String email;
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("email="+email);
		
		return SUCCESS;
	}

}
