package com.atguigu.mapping.bean;
import java.util.Set;
public class Department {
	private Integer deptId;
	private String deptName;
	private Set<Employee> empSet;
	public Department() {}
	public Department(Integer deptId, String deptName, Set<Employee> empSet) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.empSet = empSet;
	}
	@Override
	public String toString() {
		return "Department [deptId=" + deptId + ", deptName=" + deptName
				+ "]";
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Set<Employee> getEmpSet() {
		return empSet;
	}
	public void setEmpSet(Set<Employee> empSet) {
		this.empSet = empSet;
	}
}