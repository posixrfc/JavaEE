package com.atguigu.mapping.bean;

import java.util.Date;

/**
 * emp_name,salary,birthday,telephone,dept_id_fk
 * @author Administrator
 *
 */
public class Employee {
	
	private Integer empId;
	private String empName;
	private double salary;
	private Date birthday;
	private String telephone;
	private Department department;
	
	public Employee() {}

	public Employee(String empName, double salary) {
		super();
		this.empName = empName;
		this.salary = salary;
	}

	public Employee(Integer empId, String empName, double salary,
			Date birthday, String telephone, Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.birthday = birthday;
		this.telephone = telephone;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", salary=" + salary + ", birthday=" + birthday
				+ ", telephone=" + telephone + ", department=" + department
				+ "]";
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
