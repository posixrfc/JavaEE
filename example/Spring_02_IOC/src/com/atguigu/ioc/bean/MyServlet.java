package com.atguigu.ioc.bean;

public class MyServlet {
	
	public MyServlet() {
		System.out.println("MyServlet对象创建了！");
	}
	
	//应该在IOC容器创建对象之后调用
	public void myInit() {
		System.out.println("myInit...");
	}
	
	//IOC容器关闭时调用
	public void myDestroy() {
		System.out.println("myDestroy...");
	}

}
