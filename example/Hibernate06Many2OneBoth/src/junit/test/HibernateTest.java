package junit.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.orm.bean.Customer;
import com.atguigu.orm.bean.Order;

public class HibernateTest {
	
	@Test
	public void test07() {
		//实验7.在set元素内设置order-by="列名 排序方式"对集合进行排序
		Customer customer = (Customer) session.get(Customer.class, 4);
		Set<Order> orders = customer.getOrders();
		for (Order order : orders) {
			System.out.println("orderName="+order.getOrderName());
		}
	}
	
	@Test
	public void test06() {
		//实验6.在set元素内设置cascade="save-update"属性实现级联保存
		Customer customer = new Customer();
		customer.setCustomerName("customer05");
		
		Order order01 = new Order(null, "order07", customer);
		Order order02 = new Order(null, "order08", customer);
		Order order03 = new Order(null, "order09", customer);
		
		Set<Order> orderSet = new HashSet<Order>();
		orderSet.add(order01);
		orderSet.add(order02);
		orderSet.add(order03);
		
		customer.setOrders(orderSet);
		
		//级联保存：只保存Customer，同时保存与Customer相关联的Order对象
		session.save(customer);
		
	}
	
	@Test
	public void test05() {
		//实验5.在set元素内设置cascade="delete"属性实现级联删除
		//删除一个游离状态的Customer对象时，如果inverse="true"则有可能发生外键约束失败问题，
		//如果inverser="false"则将关联的Order记录外键置空
//		Customer customer = new Customer();
//		customer.setCustomerId(2);
		
		//如果删除的是一个持久化状态的Customer，则Hibernate会先查询关联的Orders集合
		//将当前与Customer关联的Order对象全部删除，再删除Customer对象
		//说明设置cascad="delete"实际上只是通过Hibernate实现了级联删除，而不是数据库层面的
		Customer customer = (Customer) session.get(Customer.class, 2);
		session.delete(customer);
	}
	
	@Test
	public void test04() {
		//实验4.查询Customer对象，关注是否加载了关联的Order集合
		//懒加载：默认情况下加载Customer对象，不会立即加载关联的Order集合
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println("==================================");
		
//		凡是有懒加载的地方，都有可能发生懒加载初始化异常
//		transaction.commit();
//		session.close();
//		
//		session = factory.openSession();
//		transaction = session.beginTransaction();
		
		Set<Order> orders = customer.getOrders();
		//System.out.println("ordersSize="+orders.size());
		System.out.println("==================================");
		
//		for (Order order : orders) {
//			System.out.println(order);
//		}
		
		System.out.println("是否包含="+orders.contains(new Order(null, "GoodOrder", customer)));
	}
	
	@Test
	public void test01() {
		//实验1.先保存一个Customer再保存三个Order对象
		Customer customer = new Customer();
		customer.setCustomerName("cust01");
		
		Order order01 = new Order(null, "order01", customer);
		Order order02 = new Order(null, "order02", customer);
		Order order03 = new Order(null, "order03", customer);
		
		//为Customer对象设定Order集合的关联关系
		Set<Order> orders = new HashSet<Order>();
		orders.add(order01);
		orders.add(order02);
		orders.add(order03);
		customer.setOrders(orders);
		
		session.save(order01);
		session.save(order02);
		session.save(order03);
		session.save(customer);
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
