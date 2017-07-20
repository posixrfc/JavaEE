package junit.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CRUDTest {

	private ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	@Test
	public void testSessionFactory() {
		SessionFactory sessionFactory = ioc.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ioc.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		
		System.out.println(connection);
	}

}
