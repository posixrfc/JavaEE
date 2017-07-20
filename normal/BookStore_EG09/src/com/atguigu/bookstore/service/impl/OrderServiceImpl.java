package com.atguigu.bookstore.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Cart;
import com.atguigu.bookstore.bean.CartItem;
import com.atguigu.bookstore.bean.Order;
import com.atguigu.bookstore.bean.OrderItem;
import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.OrderDao;
import com.atguigu.bookstore.dao.OrderItemDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import com.atguigu.bookstore.dao.impl.OrderDaoImpl;
import com.atguigu.bookstore.dao.impl.OrderItemDaoImpl;
import com.atguigu.bookstore.service.OrderService;
import com.atguigu.bookstore.utils.JDBCUtils;

/**
 * 订单业务的实现类
 * @author lilichao
 *
 */
public class OrderServiceImpl implements OrderService {
	
	private OrderDao orderDao = new OrderDaoImpl();
	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	private BookDao bookDao = new BookDaoImpl();

	@Override
	public String createOrder(Cart cart, User user) {
		
		/**
		 * 创建订单实际上就是向数据库中插入一个Order和一些OrderItem
		 */
		//创建一个Oreder对象
		//生成订单号
		String orderId = System.currentTimeMillis()+""+user.getId();
		//设置订单状态,未发货
		int state = 0;
		//商品的总数
		int totalCount = cart.getTotalCount();
		//商品的总金额
		double totalAmount = cart.getTotalAmount();
		//创建Order对象
		Order order = new Order(orderId, new Date(), totalCount, totalAmount, state, user.getId());
		//将Order对象插入进数据库
		orderDao.saveOrder(order);
		
		
		
		//创建订单项
		List<CartItem> cartItems = cart.getCartItems();
		
		//创建一个二维数组,用来保存orderItem的数据
		Object[][] itemParams = new Object[cartItems.size()][];
		Object[][] bookParams = new Object[cartItems.size()][];
		//创建一个索引
		int index = 0;
		
		//遍历cartItems
		for (CartItem cartItem : cartItems) {
			//图书的数量
			int count = cartItem.getCount();
			//图书的金额
			double amount = cartItem.getAmount();
			//获取图书的对象
			Book book = cartItem.getBook();
			//创建OrderItem
			//OrderItem orderItem = new OrderItem(null, count, amount, book.getId(), orderId);
			//将OrderItem插入到数据库
			//orderItemDao.saveOrderItem(orderItem);
			
			//(count , amount ,book_id ,order_id
			itemParams[index] = new Object[]{count,amount,book.getId(),orderId};
			
			
			
			//修改book销量及库存
			int sales = book.getSales()+count;
			int stock = book.getStock()-count;
			//book.setSales(sales);
			//book.setStock(stock);
			//提交图书的修改
			//bookDao.updateBook(book);
			
			//sales=? , stock=?  WHERE id=?";
			bookParams[index] = new Object[]{sales,stock,book.getId()};
			
			//让index自增
			index++;
		}
		
		//批量插入orderItem
		orderItemDao.batchSaveOrderItem(itemParams);
		//批量修改图书的库存
		bookDao.batchUpdateSalesAndStock(bookParams);
		
		//添加成功以后清空购物车
		cart.clear();
		
		
		return orderId;
	}

	@Override
	public List<Order> getOrderList() {
		return orderDao.getOrderList();
	}

	@Override
	public List<Order> getOrderListByUserId(String userId) {
		List<Order> list = orderDao.getOrderListByUserId(userId);
		
		for (Order order : list) {
			
			//获取当前order对应的OredrItems
			List<OrderItem> orderItems = orderItemDao.getOrderItemByOrderId(order.getId());
			
			//将orderItems 设置进order
			order.setOrderItems(orderItems);
		}
		
		return list;
	}

	@Override
	public int updateOrderState(String orderId, String state) {
		return orderDao.updateOrderState(orderId, state);
	}

}
