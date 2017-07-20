package junit.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.Date;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.hello.bean.BigUser;
import com.atguigu.hello.bean.OrderItem;
import com.atguigu.hello.bean.Student;

public class HibernateTest {
	
	@Test
	public void testFormula() {
		/*OrderItem orderItem = new OrderItem(150.5, 10);
		session.save(orderItem);*/
		Object object = session.get(OrderItem.class, 1);
		System.out.println(object);
	}
	
	@Test
	public void testDynamicSave() {
		Student student = new Student();
		student.setAge(35);
		
		session.save(student);
	}
	
	@Test
	public void testUpdate() {
		Student student = (Student) session.get(Student.class, 1);
		student.setStuName("Jerry");
	}
	
	@Test
	public void testBigObject() throws IOException {
		BigUser bigUser = new BigUser();
		bigUser.setDescrib("Today is very happy!");
		
		InputStream in = new FileInputStream("pic7.jpg");
		Blob picture = Hibernate.getLobCreator(session).createBlob(in, in.available());
		bigUser.setPicture(picture);
		
		session.save(bigUser);
	}
	
	@Test
	public void testSave() {
		Student student = new Student(null, "Tom2015", 100, new Date());
		session.save(student);
	}
	
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
	public void createTable() {}

}
