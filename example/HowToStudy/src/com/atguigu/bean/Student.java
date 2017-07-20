package com.atguigu.bean;

public class Student {
	
	private Integer stuId;
	private String stuName;
	
	public Student() {
		
	}

	public Student(Integer stuId, String stuName) {
		super();
		this.stuId = stuId;
		this.stuName = stuName;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + "]";
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
	
}
