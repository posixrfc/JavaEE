package com.atguigu.validation.action;

import com.opensymphony.xwork2.ActionSupport;

public class ValidationAction04 extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private int age;
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("age="+age);
		
		return SUCCESS;
	}

}
