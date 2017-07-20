package cn.itcast.bean.xml;
//setter注入
public class Bean7 {
	private String name;
	private Integer age;
	
	private Bean7Use use;
	public void setUse(Bean7Use use) {
		this.use = use;
	}
	//提供要注入的属性对应的setter方法
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public void test(){
		use.fn();
		System.out.println("bean7:"+name+","+age);
	}
	
}
