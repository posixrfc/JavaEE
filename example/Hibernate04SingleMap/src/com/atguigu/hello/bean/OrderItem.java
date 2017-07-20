package com.atguigu.hello.bean;

public class OrderItem {
	
	private Integer orderItemId;
	
	private double price;
	private int count;
	
	//派生属性：amount应该是由price*count计算得到
	private double amount;
	
	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Integer orderItemId, double price, int count, double amount) {
		super();
		this.orderItemId = orderItemId;
		this.price = price;
		this.count = count;
		this.amount = amount;
	}

	public OrderItem(double price, int count) {
		super();
		this.price = price;
		this.count = count;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", price=" + price
				+ ", count=" + count + ", amount=" + amount + "]";
	}

	public Integer getOrderItemId() {
		return orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
