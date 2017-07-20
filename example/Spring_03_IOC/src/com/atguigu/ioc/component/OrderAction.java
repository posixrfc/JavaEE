package com.atguigu.ioc.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class OrderAction {
	
	private OrderService orderService;
	
	@Autowired(required=false)
	private CommonComponent common;
	
	@Autowired
	public void setOrderService(@Qualifier("orderServiceGood") OrderService orderService) {
		this.orderService = orderService;
	}
	
	public void save() {
		orderService.save();
	}

}
