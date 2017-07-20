package junit.test;

import org.junit.Test;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Cart;
import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import com.atguigu.bookstore.service.OrderService;
import com.atguigu.bookstore.service.impl.OrderServiceImpl;

public class TestOrderService {

	OrderService orderService = new OrderServiceImpl();
	BookDao bookDao = new BookDaoImpl();
	
	@Test
	public void testCreateOrder() {
		
		//创建一个购物车对象
		Cart cart = new Cart();
		
		//获取一本图书
		Book book = bookDao.getBookById("10");
		
		//将book添加到购物车中
		cart.addBook2Cart(book);
		
		//创建一个User对象
		User user = new User();
		user.setId(4);
		
		//生成订单
		String orderId = orderService.createOrder(cart, user);
		
		System.out.println(orderId);
		
		
	}

}
