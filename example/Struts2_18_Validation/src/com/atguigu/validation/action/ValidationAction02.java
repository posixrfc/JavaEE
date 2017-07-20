package com.atguigu.validation.action;

import com.opensymphony.xwork2.ActionSupport;

public class ValidationAction02 extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private String userPwd;
	private String userPwdAgain;
	
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserPwdAgain() {
		return userPwdAgain;
	}
	public void setUserPwdAgain(String userPwdAgain) {
		this.userPwdAgain = userPwdAgain;
	}
	
	public String execute() {
		
		System.out.println("密码="+userPwd);
		System.out.println("确认密码="+userPwdAgain);
		
		return "success";
	}

}
