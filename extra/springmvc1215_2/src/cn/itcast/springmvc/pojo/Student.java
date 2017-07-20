package cn.itcast.springmvc.pojo;

import java.util.Date;

/**
 * 
 * <p>
 * Title: Student
 * </p>
 * <p>
 * Description:学生信息类
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2014-12-15上午11:09:40
 * @version 1.0
 */
public class Student {
	
	public Student() {
	}
	public Student(String name) {
		this.name = name;
	}

	private String id;//id
	private String name;// 姓名
	private Integer age;// 年龄
	private Date birthday;// 生日
	private String address;// 地址
	//用户状态
	private Boolean userstate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", birthday="
				+ birthday + ", address=" + address + "]";
	}
	public Boolean getUserstate() {
		return userstate;
	}
	public void setUserstate(Boolean userstate) {
		this.userstate = userstate;
	}
	
	

}
