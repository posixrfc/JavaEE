package com.atguigu.orm.bean;

import java.util.Set;

public class Customer {
	
	private Integer customerId;
	private String customerName;
	
	private Set<Order> orders;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer customerId, String customerName, Set<Order> orders) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName="
				+ customerName + "]";
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
