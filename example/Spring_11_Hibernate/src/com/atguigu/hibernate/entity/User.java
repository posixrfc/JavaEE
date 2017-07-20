package com.atguigu.hibernate.entity;

public class User {
	
	private Integer userId;
	private int balance;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, int balance) {
		super();
		this.userId = userId;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", balance=" + balance + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
}
