package com.atguigu.ioc.bean;

public class Employee {
	
	private String empName;
	private Department department;
	private double salary;
	private String insteresting;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName, Department department, double salary,
			String insteresting) {
		super();
		this.empName = empName;
		this.department = department;
		this.salary = salary;
		this.insteresting = insteresting;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", department=" + department
				+ ", salary=" + salary + ", insteresting=" + insteresting + "]";
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getInsteresting() {
		return insteresting;
	}

	public void setInsteresting(String insteresting) {
		this.insteresting = insteresting;
	}
	
	public String showMyHoby(String hoby) {
		return "I love "+hoby;
	}
}
