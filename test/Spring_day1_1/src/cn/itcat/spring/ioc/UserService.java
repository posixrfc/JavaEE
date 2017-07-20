package cn.itcat.spring.ioc;


public class UserService {
	public UserService(){
		System.out.println("userservice..................................");
	}
	//运行该程序需要为其提供一个字符串的值
	private String name;
	private Integer year;
	public void setName(String name) {
		this.name = name;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public void fn(){
		System.out.println("fn......"+name+","+year);
	}
}
