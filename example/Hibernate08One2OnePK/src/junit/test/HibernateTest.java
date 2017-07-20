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
	public void test01() {
		//实验1.先保存自己生成主键的一端
		//实验2.先保存以外键作为主键的一端
		Boy boy = new Boy(null, "Justin");
		Girl girl = new Girl(null, "HanMeiMei03");
		
		boy.setGirl(girl);
		girl.setBoy(boy);
		
		//无论代码的顺序怎样，都会先保存自己生成主键的一端，因为以外键作为主键的一端不能没有主键
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
