package junit.test;

import java.util.List;

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
	public void test10() {
		//实验10：使用HQL查询一组Order对象时，初始化batch-size个Customer对象
		List<Order> list = session.createQuery("From Order").list();
		System.out.println("===================");
		for (Order order : list) {
			System.out.println("CustomerName="+order.getCustomer().getCustomerName());
			System.out.println();
		}
	}
	
	@Test
	public void test08() {
		//实验8：获取Order对象后立即加载关联的Customer对象
		//实验9：获取Order对象后通过“迫切左外连接”的方式立即加载关联的Customer对象
		Order order = (Order)session.get(Order.class, 1);
		System.out.println("===========");
		System.out.println("CustomerName="+order.getCustomer().getCustomerName());
	}
	
	@Test
	public void test06() {
		//实验6：通过设置set元素的fetch属性为join使得查询Customer对象时就通过“迫切左外连接”的方式初始化关联的Order集合
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println(customer.getOrders().size());
	}
	
	@Test
	public void test04() {
		//实验4：通过HQL语句查询一组Customer对象，使用batch-size属性指定初始化的数量
		//实验5：通过设置set元素的fetch属性为subselect使用子查询的方式初始化所有Order集合
		//实验7：测试fetch=join对Query对象的list()方法无效
		List<Customer> list = session.createQuery("From Customer").list();
		System.out.println("================");
		for (Customer customer : list) {
			System.out.println("orderSize="+customer.getOrders().size());
			System.out.println();
		}
	}
	
	@Test
	public void test03() {
		//实验3：获取Customer对象后，获取关联的Order对象集合的长度，让发送的SQL语句使用count()函数完成
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println("================");
		System.out.println("orderSize="+customer.getOrders().size());
		System.out.println("================");
		Order order = customer.getOrders().iterator().next();
		System.out.println("orderName="+order.getOrderName());
	}
	
	@Test
	public void test02() {
		//实验2：获取Customer对象时立即加载关联的Order对象集合
		Customer customer = (Customer) session.get(Customer.class, 1);
		System.out.println("================");
		System.out.println("orderSize="+customer.getOrders().size());
	}
	
	@Test
	public void test01() {
		//实验1：使用load()方法立即加载Customer对象
		Customer customer = (Customer) session.load(Customer.class, 1);
		System.out.println("=====================");
		System.out.println("customerName="+customer.getCustomerName());
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
