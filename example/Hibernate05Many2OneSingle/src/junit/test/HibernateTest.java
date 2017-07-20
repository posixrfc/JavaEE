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

import com.atguigu.orm.bean.Order;
import com.atguigu.orm.bean.User;

public class HibernateTest {
	
	@Test
	public void test09() {
		//实验9.尝试删除关联了Order对象的Customer对象
		session.delete(new User(1, "xxx"));
	}
	
	@Test
	public void test08() {
		//实验8.通过持久化状态的Order对象更新Customer对象的属性
		Order order = (Order) session.get(Order.class, 3);
		
		System.out.println("=================");
		
		User user = order.getUser();
		
		user.setUserName("JJJ");
	}
	
	@Test
	public void test07() {
		//实验7.查询User
		User user = (User) session.get(User.class, 1);
		System.out.println(user);
	}
	
	@Test
	public void test03() {
		//实验3.查询Order对象，验证关联的Customer对象是一个代理对象
		//实验5.查询Order对象后关闭Session，再重新开启，获取关联的Customer对象
		//在单向多对一关联关系中，加载多的一端的对象时，默认是延迟加载关联的一的一端对象
		//凡是有延迟加载存在的情况，都有发生懒加载初始化异常的可能
		Order order = (Order) session.get(Order.class, 3);
		System.out.println("orderName="+order.getOrderName());
		
		transaction.commit();
		session.close();
		
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		User user = order.getUser();
		System.out.println("userClass="+user.getClass().getName());
		System.out.println("userId="+user.getUserId());
		System.out.println("userName="+user.getUserName());
		
	}
	
	@Test
	public void test01() {
		//实验1.先保存一个User再保存三个Order对象
		//实验2.先保存三个Order对象再保存一个User对象
		//1.创建对象
		User user = new User();
		user.setUserName("userName02");
		
		Order order01 = new Order();
		order01.setOrderName("order04");
		
		Order order02 = new Order();
		order02.setOrderName("order05");
		
		Order order03 = new Order();
		order03.setOrderName("order06");
		
		//2.设定关联关系
		order01.setUser(user);
		order02.setUser(user);
		order03.setUser(user);
		
		//3.保存
		//如果先保存有外键的一端，则开始的时候外键列置空
		//在保存了没有外键的一端后，再通过UPDATE语句设置外键值
		//此时会额外多出若干条UPDATE语句，从而降低程序性能
		session.save(order01);
		session.save(order02);
		session.save(order03);
		session.save(user);
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
