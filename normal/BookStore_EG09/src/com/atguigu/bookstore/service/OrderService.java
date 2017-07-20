package com.atguigu.bookstore.service;

import java.util.List;

import com.atguigu.bookstore.bean.Cart;
import com.atguigu.bookstore.bean.Order;
import com.atguigu.bookstore.bean.User;

/**
 * 订单相关业务的接口
 * @author lilichao
 *
 */
public interface OrderService {

	/**
	 * 生成一个订单
	 * @param cart
	 * @param user
	 * @return
	 */
	String createOrder(Cart cart , User user);
	
	/**
	 * 获取当前系统中所有的订单
	 * @return
	 */
	List<Order> getOrderList();
	
	/**
	 * 获取当前用户的所有订单
	 * @param userId
	 * @return
	 */
	List<Order> getOrderListByUserId(String userId);
	
	/**
	 * 修改订单的状态
	 * @param orderId
	 * @param state
	 * @return
	 */
	int updateOrderState(String orderId , String state);
}
