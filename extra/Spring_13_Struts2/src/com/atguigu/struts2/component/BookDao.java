package com.atguigu.struts2.component;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	
	public String getMessage() {
		return "I love you Spring!";
	}

}
