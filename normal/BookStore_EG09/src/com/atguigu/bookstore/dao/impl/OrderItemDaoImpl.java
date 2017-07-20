package com.atguigu.bookstore.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.OrderItem;
import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements
		OrderItemDao {

	@Override
	public int saveOrderItem(OrderItem orderItem) {

		String sql = "INSERT INTO bs_order_item (count , amount ,book_id ,order_id) "
				+ "VALUES(?,?,?,?)";

		return this.update(sql, orderItem.getCount(), orderItem.getAmount(),
				orderItem.getBookId(), orderItem.getOrderId());
	}

	@Override
	public void batchSaveOrderItem(Object[][] params) {

		String sql = "INSERT INTO bs_order_item (count , amount ,book_id ,order_id) "
				+ "VALUES(?,?,?,?)";

		this.batchUpdate(sql, params);

	}

	@Override
	public List<OrderItem> getOrderItemByOrderId(String orderId) {

		/*
		 * 我们需要一条sql查询所有的OrderItem和book的信息，这种方式不可取 String sql =
		 * "SELECT * FORM bs_order_item WHERE order_id =?";
		 * this.getBeanList(sql, orderId);
		 */

		String sql = "SELECT "
				+ "o.id , o.count , o.amount , o.book_id ,  "
				+ "b.title , b.author , b.price  , b.img_path "
				+ "FROM bs_order_item o , bs_book b "
				+ "WHERE o.book_id = b.id "
				+ "AND o.order_id=?";
		
		//查询一个Map的list
		List<Map<String, Object>> list = this.getMapList(sql, orderId);
		
		//创建一个集合用来保存orderItem
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		
		for (Map<String, Object> map : list) {
			/**
			 * {img_path=/static/img/default.jpg, 
			 * amount=27.2, 
			 * id=2, 
			 * author=东野圭吾, 
			 * title=解忧杂货店, 
			 * price=27.2, 
			 * count=1, 
			 * book_id=10}
			 */
			
			//图片地址
			String imgPath = (String) map.get("img_path");
			//单种类图书的数量
			double amount = (double) map.get("amount");
			//OrderItem的id
			int itemId = (int) map.get("id");
			//图书的作者
			String author = (String) map.get("author");
			//书名
			String title = (String) map.get("title");
			//单价
			double price = (double) map.get("price");
			//图书的数量
			int count = (int) map.get("count");
			//图书的id
			int bookId= (int) map.get("book_id");
			
			//创建OrderITem对象
			OrderItem orderItem = new OrderItem(itemId, count, amount, bookId, orderId);
			//创建一个book对象
			Book book = new Book(bookId, title, author, price, 0, 0, imgPath);
			//将book设置进orderItem
			orderItem.setBook(book);
			//将OrderItem添加到List中
			orderItems.add(orderItem);
			
		}
		
		return orderItems;
	}

}
