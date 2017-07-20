package com.atguigu.login.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private Date today;
	
	public Date getToday() {
		today = new Date();
		return today;
	}
	
	@Override
	public String execute() throws Exception {
		
		return SUCCESS;
	}

}
