package com.atguigu.interview;

public class Order {
	private String name;
	private int id;
	public Order(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	public Order() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Order [name=" + name + ", id=" + id + "]";
	}
	
}
