package cn.itcast.javaee.springmvc.app02;

import java.util.UUID;

/**
 * Ա��
 * @author AdminTC
 */
public class Emp {
	private String id;//���
	private String username;//����
	private Double salary;//нˮ
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
