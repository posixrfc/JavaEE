package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.tx.component.service.BookShopService;

public class TxTest {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("transaction_xml.xml");

	@Test
	public void testTx() {
		BookShopService bookShopService = ioc.getBean(BookShopService.class);
		bookShopService.purchase("Jerry", "ISBN-002");
	}

}
