package junit.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.atguigu.bookstore.bean.Order;
import com.atguigu.bookstore.dao.OrderDao;
import com.atguigu.bookstore.dao.impl.OrderDaoImpl;

public class TestOrderDao {

	OrderDao orderDao = new OrderDaoImpl();
	
	@Test
	public void testSaveOrder() {
		//生成一个订单号
		String id = System.currentTimeMillis()+""+4;
		Order order = new Order(id, new Date(), 10, 20, 0, 4);
		//保存订单
		orderDao.saveOrder(order);
	}

	@Test
	public void testGetOrderList() {
		
		List<Order> list = orderDao.getOrderList();
		
		System.out.println(list);
	}

	@Test
	public void testGetOrderListByUserId() {
		List<Order> list = orderDao.getOrderListByUserId("4");
		System.out.println(list);
	}

	@Test
	public void testUpdateOrderState() {
		orderDao.updateOrderState("14391733758514", "1");
	}

}
