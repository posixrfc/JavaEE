package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.ioc.component.action.BookAction;
import com.atguigu.ioc.component.service.BookService;
import com.atguigu.ioc.component.service.OrderService;

public class IOCTest {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
	
	@Test
	public void test02() {
		
		System.out.println("IOC容器已经创建");
		
		BookAction bookAction01 = ioc.getBean(BookAction.class);
		BookAction bookAction02 = ioc.getBean(BookAction.class);
		
		System.out.println(bookAction01 == bookAction02);
	}

	@Test
	public void test01() {
		
		BookService bookService = ioc.getBean(BookService.class);
		bookService.save();
		
		OrderService orderService = ioc.getBean(OrderService.class);
		orderService.save();
		
	}

}
