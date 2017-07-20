package com.atguigu.hello.bean;

import java.sql.Blob;

public class BigUser {
	
	private Integer userId;
	private String describ;
	private Blob picture;
	
	public BigUser() {
		// TODO Auto-generated constructor stub
	}

	public BigUser(Integer userId, String describ, Blob picture) {
		super();
		this.userId = userId;
		this.describ = describ;
		this.picture = picture;
	}

	@Override
	public String toString() {
		return "BigUser [userId=" + userId + ", describ=" + describ
				+ ", picture=" + picture + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDescrib() {
		return describ;
	}

	public void setDescrib(String describ) {
		this.describ = describ;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	
}
