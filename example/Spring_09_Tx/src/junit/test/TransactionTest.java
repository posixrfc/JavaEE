package junit.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.tx.component.dao.BookShopDao;
import com.atguigu.tx.component.service.BookShopService;
import com.atguigu.tx.component.service.MultTransactionService;

/**
UPDATE book_stock SET stock=1000;
UPDATE account SET balance=1000;
 * @author Creathin
 *
 */
public class TransactionTest {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("transaction.xml");
	
	@Test
	public void testMultiTx() {
		MultTransactionService service = ioc.getBean(MultTransactionService.class);
		service.multiTransaction();
	}
	
	@Test
	public void testUpdatePrice() {
		BookShopDao bookShopDao = ioc.getBean(BookShopDao.class);
		bookShopDao.updatePrice("ISBN-001", 1000);
	}
	
	@Test
	public void testPurChase() {
		BookShopService bookShopService = ioc.getBean(BookShopService.class);
		bookShopService.purchase("Jerry", "ISBN-001");
	}
	
	@Test
	public void testUpdateBalance() {
		BookShopDao bookShopDao = ioc.getBean(BookShopDao.class);
		bookShopDao.updateBalanceByUserNamePrice("Jerry", 100);
	}
	
	@Test
	public void testUpdateStock() {
		BookShopDao bookShopDao = ioc.getBean(BookShopDao.class);
		bookShopDao.updateBookStockByISBN("ISBN-002");
	}
	
	@Test
	public void testFindPrice() {
		BookShopDao bookShopDao = ioc.getBean(BookShopDao.class);
		int price = bookShopDao.findBookPriceByISBN("ISBN-003");
		System.out.println(price);
	}

	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ioc.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}

}
