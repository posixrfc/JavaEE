package com.atguigu.orm.review.bean;

/**
 * 多的一端
 * @author Creathin
 *
 */
public class Employee {
	
	private Integer empId;
	private String empName;
	private Department department;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(Integer empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
	}

	public Employee(Integer empId, String empName, Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + "]";
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
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

}
