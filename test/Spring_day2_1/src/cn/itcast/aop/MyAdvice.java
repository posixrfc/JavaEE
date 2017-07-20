package cn.itcast.aop;
//通知类
public class MyAdvice {
	//具有共性功能的方法:通知
	public void fn(){
		//共性功能
		System.out.println("aaaaa");
	}
	public void fn2(){
		//共性功能
		System.out.println("cccccc");
	}
}
