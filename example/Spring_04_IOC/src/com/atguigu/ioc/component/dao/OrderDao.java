package com.atguigu.ioc.component.dao;

import org.springframework.stereotype.Repository;

import com.atguigu.ioc.component.base.BaseRepository;
import com.atguigu.ioc.component.entity.Order;

@Repository
public class OrderDao extends BaseRepository<Order>{
	
	@Override
	public void save() {
		System.out.println("saved by order dao...");
	}

}
