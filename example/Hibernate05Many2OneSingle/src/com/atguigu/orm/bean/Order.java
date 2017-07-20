package com.atguigu.orm.bean;

public class Order {
	
	private Integer orderId;
	private String orderName;
	
	//作为单向多对一关联关系中的“多”的一端，需要包含“一”的一端的对象的引用
	private User user;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}

	public Order(Integer orderId, String orderName, User user) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName
				+ ", user=" + user + "]";
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
