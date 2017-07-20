package com.atguigu.orm.bean;

public class Teacher {
	
	private Integer teacherId;
	private String teacherName;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(Integer teacherId, String teacherName) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName="
				+ teacherName + "]";
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
}
