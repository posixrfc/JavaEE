package com.atguigu.conversion.action;

import com.atguigu.conversion.bean.Address;

public class ConversionAction03 {
	
	private Address address;
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String execute() {
		
		System.out.println(address);
		
		return "success";
	}

}
