package com.atguigu.validation.action;

import com.opensymphony.xwork2.ActionSupport;

public class ValidationAction05 extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	private int age;
	private int grade;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("age="+age+" grade="+grade);
		
		return SUCCESS;
	}
	
	public String specialMethod() {
		
		System.out.println("age="+age+" grade="+grade);
		
		return SUCCESS;
	}

}
