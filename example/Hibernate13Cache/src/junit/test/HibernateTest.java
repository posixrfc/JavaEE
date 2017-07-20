package junit.test;

import java.util.Iterator;
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

import com.atguigu.mapping.bean.Department;
import com.atguigu.mapping.bean.Employee;

public class HibernateTest {
	
	@Test
	public void test04() {
		//实验5：测试Query.iterate()方法
		//1.iterate()方法仅查询目标持久化类的OID这一个字段，在字段很多的情况下会比较有用
		//2.如果当前二级缓存中已经包含了要查询的数据，则直接从二级缓存中提取
		session.createQuery("From Employee e Where e.salary>=4000 and e.salary<=6000").setCacheable(true).list();
		
		Iterator<Employee> iterate = session.createQuery("From Employee e Where e.salary>=3000 and e.salary<=5000")
											.iterate();
		while (iterate.hasNext()) {
			Employee employee = (Employee) iterate.next();
			System.out.println(employee.getEmpId()+" "+employee.getSalary());
		}
	}
	
	@Test
	public void test03() {
		//实验3：测试查询缓存
		String hql = "From Employee e where e.salary>9000";
		List<Employee> list = session.createQuery(hql).setCacheable(true).list();
		System.out.println(list.size());
		
		//实验4：测试更新时间戳缓存
		Employee employee = (Employee) session.get(Employee.class, 9);
		employee.setTelephone("13800001234");
		
		list = session.createQuery(hql).setCacheable(true).list();
		System.out.println(list.size());
	}
	
	@Test
	public void test02() {
		//实验2：测试集合级别的二级缓存
		Department department = (Department) session.get(Department.class, 1);
		System.out.println(department.getEmpSet().size());
		
		//重新开启Session缓存
		transaction.commit();
		session.close();
		
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		department = (Department) session.get(Department.class, 1);
		System.out.println(department.getEmpSet().size());
	}
	
	@Test
	public void test01() {
		//实验1：测试类级别的二级缓存
		//第一次查询时已经将数据保存到二级缓存中
		Department department = (Department) session.get(Department.class, 1);
		System.out.println(department.getDeptName());
		
		//重新开启Session缓存
		transaction.commit();
		session.close();
		
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		//从二级缓存中获取数据，不必再发送SQL语句
		department = (Department) session.get(Department.class, 1);
		System.out.println(department.getDeptName());
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
