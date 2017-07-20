package com.atguigu.ioc.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderServiceGood")
public class OrderService {
	
	@Autowired
	private OrderDao orderDao;

	public void save() {
		orderDao.save();
	}

}
