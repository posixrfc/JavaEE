package com.atguigu.conversion.action;

import com.atguigu.conversion.bean.Employee;

public class ConversionAction05 {
	
	private Employee employee;
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public String execute() {
		
		System.out.println(employee);
		
		return "success";
	}

}
