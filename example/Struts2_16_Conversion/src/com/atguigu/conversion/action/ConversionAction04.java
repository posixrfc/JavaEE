package com.atguigu.conversion.action;

import com.atguigu.conversion.bean.Employee;
import com.opensymphony.xwork2.ModelDriven;

public class ConversionAction04 implements ModelDriven<Employee>{
	
	private Employee employee;

	@Override
	public Employee getModel() {
		this.employee = new Employee();
		return this.employee;
	}
	
	public String execute() {
		System.out.println(employee);
		return "success";
	}

}
