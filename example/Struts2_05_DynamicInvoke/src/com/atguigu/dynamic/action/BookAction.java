package com.atguigu.dynamic.action;

public class BookAction {
	
	//action请求本来要访问的方法
	public String save() {
		System.out.println("save...");
		return "success";
	}
	
	//动态方法调用后执行的方法
	public String update() {
		System.out.println("update...");
		return "success";
	}

}
