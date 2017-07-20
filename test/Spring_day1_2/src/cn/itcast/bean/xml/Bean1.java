package cn.itcast.bean.xml;
//测试Bean的初始化范式
public class Bean1 {
	public Bean1(){
		//System.out.println("bean1 init...");
	}
	public void test(){
		System.out.println("bean1 running....");
	}
	
	//定义一个方法，在Bean创建时，执行
	public void init(){
		System.out.println("创建时干点坏事");
	}
	//定义一个方法,在Bean销毁时，执行
	public void destory(){
		System.out.println("销毁时干点坏事....................");
	}
}
