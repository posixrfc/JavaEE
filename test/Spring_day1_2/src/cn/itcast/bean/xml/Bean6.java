package cn.itcast.bean.xml;
//构造器注入
public class Bean6 {
	private String name;
	private Integer age;
	//服务于构造器注入使用
	public Bean6(String name,Integer age){
		this.name = name;
		this.age =age;
	}
	public void test(){
		System.out.println("bean6:"+name+","+age);
	}
}
