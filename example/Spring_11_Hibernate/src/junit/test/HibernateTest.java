package junit.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.hibernate.componnent.dao.BookShopDao;
import com.atguigu.hibernate.componnent.service.BookShopService;

public class HibernateTest {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

	@Test
	public void testPurChase() {
		BookShopService service = ioc.getBean(BookShopService.class);
		service.purchase(1, 1);
	}
	
	@Test
	public void testUpdateBalance() {
		BookShopDao bookShopDao = ioc.getBean(BookShopDao.class);
		bookShopDao.updateUserBalance(1, 100);
	}
	
	@Test
	public void testUpdateStock() {
		BookShopDao bookShopDao = ioc.getBean(BookShopDao.class);
		bookShopDao.updateBookStock(1);
	}
	
	@Test
	public void testFindPrice() {
		BookShopDao bookShopDao = ioc.getBean(BookShopDao.class);
		int price = bookShopDao.findPriceById(1);
		System.out.println("price="+price);
	}
	
	@Test
	public void testSessionFactory() {
		SessionFactory factory = ioc.getBean(SessionFactory.class);
		System.out.println(factory);
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ioc.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

}
