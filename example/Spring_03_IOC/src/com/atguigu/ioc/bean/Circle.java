package com.atguigu.ioc.bean;

public class Circle {
	
	private double length;
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getLength() {
		return length;
	}

	@Override
	public String toString() {
		return "Circle [length=" + length + "]";
	}

}
