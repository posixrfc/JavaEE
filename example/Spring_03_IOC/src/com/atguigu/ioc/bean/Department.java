package com.atguigu.ioc.bean;

public class Department {
	
	private String managerName;
	private String deptName;

	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(String managerName, String deptName) {
		super();
		this.managerName = managerName;
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [managerName=" + managerName + ", deptName="
				+ deptName + "]";
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

}
