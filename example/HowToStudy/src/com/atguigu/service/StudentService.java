package com.atguigu.service;

import java.util.ArrayList;
import java.util.List;

import com.atguigu.bean.Student;

public class StudentService {
	
	//为上层Servlet提供数据
	public List<Student> getStuList() {
		
		List<Student> stuList = new ArrayList<Student>();
		
		stuList.add(new Student(1, "Tom"));
		stuList.add(new Student(2, "Kate"));
		stuList.add(new Student(3, "Jerry"));
		
		return stuList;
	}

}
