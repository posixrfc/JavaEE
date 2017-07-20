package junit.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.bookstore.bean.OrderItem;
import com.atguigu.bookstore.dao.OrderItemDao;
import com.atguigu.bookstore.dao.impl.OrderItemDaoImpl;

public class TestOrderItemDao {

	OrderItemDao orderItemDao = new OrderItemDaoImpl();
	
	@Test
	public void testGetOrderItemByOrderId(){
		List<OrderItem> list = orderItemDao.getOrderItemByOrderId("14391765593734");
		
		for (OrderItem orderItem : list) {
			System.out.println(orderItem);
			System.out.println(orderItem.getBook());
		}
	}
	
	@Test
	public void testSaveOrderItem() {
		
		//创建一个OrderItem
		OrderItem orderItem = new OrderItem(null, 1, 20, 10, "14391733758514");
		//将它保存到数据库中
		orderItemDao.saveOrderItem(orderItem);
	}

}
