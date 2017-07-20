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
		session.createQuery("From Employee e Where e.salary>=40 and e.salary<=6000").setCacheable(true).list();
		Iterator<Employee> iterate = session.createQuery("From Employee e Where e.salary>=30 and e.salary<=5000").iterate();
		while (iterate.hasNext()) {
			Employee employee = (Employee) iterate.next();
			System.out.println(employee.getEmpId()+" "+employee.getSalary());
		}
	}
	@Test
	public void test03() {
		String hql = "From Employee e where e.salary>90";
		List<Employee> list = session.createQuery(hql).setCacheable(true).list();
		System.out.println(list.size());
		
		Employee employee = (Employee) session.get(Employee.class, 3);
		employee.setTelephone("1380000123");
		
		list = session.createQuery(hql).setCacheable(true).list();
		System.out.println(list.size());
	}
	@Test
	public void test02() {
		Department department = (Department) session.get(Department.class, 4);
		System.out.println(department.getEmpSet().size());
		
		transaction.commit();
		session.close();
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		department = (Department) session.get(Department.class, 4);
		System.out.println(department.getEmpSet().size());
	}
	@Test
	public void test01() {
		Department department = (Department) session.get(Department.class, 4);
		System.out.println(department.getDeptName());
		
		transaction.commit();
		session.close();
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		department = (Department) session.get(Department.class, 4);
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