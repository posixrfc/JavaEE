package cn.itcast.emp.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * 员工 
 * @author AdminTC
 */
public class Emp {
	private String id;//编号
	private String username;//姓名
	private Double salary;//薪水
	private Date hiredate;//入职时间
	public Emp(){}
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
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
}






