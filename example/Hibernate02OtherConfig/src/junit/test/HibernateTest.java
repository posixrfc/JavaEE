package junit.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.Work;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.hello.bean.Student;

public class HibernateTest {
	
	private SessionFactory factory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init() {
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);
		session = factory.openSession();
		transaction = session.beginTransaction();
	}
	
	@After
	public void destroy() {
		transaction.commit();
		session.close();
		factory.close();
	}

	@Test
	public void createTable() {
		
		session.save(new Student(null, "Tom", 25, new Date(), "JavaWeb"));
		
	}
	
	@Test
	public void showC3p0Conn() {
		
		//在Hibernate环境下获取原始的JDBC的Connection对象
		session.doWork(new Work() {
			
			@Override
			public void execute(Connection connection) throws SQLException {
				//按照JDBC的方式执行数据库操作
				//直接获取的数据库连接：com.mysql.jdbc.JDBC4Connection@194fa89f
				//从数据源中获取的数据库连接：com.mchange.v2.c3p0.impl.NewProxyConnection@72db0d07
				System.out.println(connection);
				
			}
		});
		
	}

}
