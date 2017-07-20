package com.atguigu.hello.bean;

import java.util.Date;

public class Student {
	
	//OID属性
	private Integer stuId;
	private String stuName;
	private int age;
	private Date birthday;
	
	private String subject;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(Integer stuId, String stuName, int age, Date birthday) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.age = age;
		this.birthday = birthday;
	}

	public Student(Integer stuId, String stuName, int age, Date birthday,
			String subject) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
		this.age = age;
		this.birthday = birthday;
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", age="
				+ age + ", birthday=" + birthday + "]";
	}

	public Integer getStuId() {
		return stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
