package cn.itcast.javaee.springmvc.app02;

import java.util.UUID;

/**
 * 员工
 * @author AdminTC
 */
public class Emp {
	private String id;//编号
	private String username;//姓名
	private Double salary;//薪水
	public Emp(){}
	public Emp(String username, Double salary) {
		this.username = username;
		this.salary = salary;
	}
	public String getId() {
		return UUID.randomUUID().toString();
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
