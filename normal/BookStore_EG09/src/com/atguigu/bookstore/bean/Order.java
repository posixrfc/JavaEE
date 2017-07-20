package com.atguigu.bookstore.bean;

import java.util.Date;
import java.util.List;

/**
 * 封装的订单的信息
 * 
 * @author lilichao
 * 
 */
public class Order {

	/**
	 * 订单号 规则：时间戳+用户id
	 */
	private String id;

	/**
	 * 生成订单的时间
	 */
	private Date orderTime;

	/**
	 * 商品总数
	 */
	private int totalCount;

	/**
	 * 商品总金额
	 */
	private double totalAmount;

	/**
	 * 订单的状态 0 : 未发货 1 : 已发货 2 : 交易结束
	 */
	private int state;

	/**
	 * 订单所属用户的ID
	 */
	private int userId;
	
	/**
	 * 创建一个List来保存OrderItem
	 */
	private List<OrderItem> orderItems;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Order(String id, Date orderTime, int totalCount, double totalAmount,
			int state, int userId) {
		super();
		this.id = id;
		this.orderTime = orderTime;
		this.totalCount = totalCount;
		this.totalAmount = totalAmount;
		this.state = state;
		this.userId = userId;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderTime=" + orderTime + ", totalCount="
				+ totalCount + ", totalAmount=" + totalAmount + ", state="
				+ state + ", userId=" + userId + "]";
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

}
