package junit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.orm.bean.Boy;
import com.atguigu.orm.bean.Girl;

public class HibernateTest {
	
	@Test
	public void test02() {
		//实验3.查询Boy对象，然后获取Girl对象的属性，留意SQL语句的连接条件是否正确
		Boy boy = (Boy) session.get(Boy.class, 1);
		System.out.println("==============================");
		Girl girl = boy.getGirl();
		System.out.println(girl.getGirlName());
	}
	
	@Test
	public void test01() {
		//实验1.先保存不包含外键的一端
		//实验2.先保存包含外键的一端
		//1.创建对象
		Boy boy = new Boy(null, "Jerry02");
		Girl girl = new Girl(null, "HanMeiMei02");
		
		//2.设定关联关系
		boy.setGirl(girl);
		girl.setBoy(boy);
		
		//3.保存
		//如果先保存有外键的一端，会产生额外的SQL语句
		session.save(girl);
		session.save(boy);
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
