package com.atguigu.ioc.component;

import org.springframework.stereotype.Repository;

@Repository(value="beautifulDao")
public class OrderDao {

	public void save() {
		System.out.println("dao save...");
	}

}
