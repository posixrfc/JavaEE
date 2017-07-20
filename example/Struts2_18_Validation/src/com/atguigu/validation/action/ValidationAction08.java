package com.atguigu.validation.action;

import com.opensymphony.xwork2.ActionSupport;

public class ValidationAction08 extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private String userName;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public void validate() {
		if(!"Tom2015".equals(userName)) {
			addFieldError("userName", "用户名必须是Tom2015");
		}
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("userName="+userName);
		
		return SUCCESS;
	}

}
