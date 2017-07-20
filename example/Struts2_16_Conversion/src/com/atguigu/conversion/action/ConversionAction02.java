package com.atguigu.conversion.action;

import com.atguigu.conversion.bean.Address;

public class ConversionAction02 {
	
	private Address address;
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public String execute() {
		
		System.out.println(address);
		
		return "success";
	}

}
