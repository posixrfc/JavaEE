package com.atguigu.bookstore.dao;

import java.util.List;

import com.atguigu.bookstore.bean.OrderItem;

/**
 * 操作订单项的DAO
 * @author lilichao
 *
 */
public interface OrderItemDao {

	/**
	 * 向数据库中插入一个订单项
	 * @param orderItem
	 * @return
	 */
	int saveOrderItem(OrderItem orderItem);
	
	/**
	 * 批量向数据库中插入数据
	 * @param params
	 */
	void batchSaveOrderItem(Object[][] params);
	
	/**
	 * 根据订单号获取所有的订单项
	 * @param orderId
	 * @return
	 */
	List<OrderItem> getOrderItemByOrderId(String orderId);
}
