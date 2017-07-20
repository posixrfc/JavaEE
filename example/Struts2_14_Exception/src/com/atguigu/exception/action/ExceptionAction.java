package com.atguigu.exception.action;

public class ExceptionAction {
	
	private int num;
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String daoMeiAction() {
		
		int i = 10 / num;
		
		System.out.println("i="+i);
		
		return "success";
	}
	
	public String daoDanAction() {
		
		int i = 10 / num;
		
		System.out.println("i="+i);
		
		return "success";
	}

}
