package com.atguigu.bookstore.dao;

import java.util.List;

import com.atguigu.bookstore.bean.Order;

/**
 * 订单操作的接口
 * 
 * @author lilichao
 * 
 */
public interface OrderDao {

	/**
	 * 保存一个订单
	 * @param order
	 * @return
	 */
	int saveOrder(Order order);

	/**
	 * 查询所有的订单，由管理端调用
	 * @return
	 */
	List<Order> getOrderList();

	/**
	 * 根据用户id查询order，由客户端调用
	 * @param userId
	 * @return
	 */
	List<Order> getOrderListByUserId(String userId);

	/**
	 * 根据订单号修改订单的状态
	 * @param orderId
	 * @param state
	 * @return
	 */
	int updateOrderState(String orderId, String state);

}
