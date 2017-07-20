package junit.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.hello.bean.Student;

public class HibernateTest {
	
	@Test
	public void test06() {
		//实验5：验证执行HQL查询前需要执行flush()操作
		Student student = (Student) session.get(Student.class, 1);
		
		System.out.println("stuName="+student.getStuName());
		
		//MySQL默认的隔离级别是：可重复读，所以两次打印看不到数据的修改
		//需要将默认隔离级别修改为读已提交才能够看到效果
		session.refresh(student);
		
		System.out.println("stuName="+student.getStuName());
		
	}
	
	@Test
	public void test05() {
		//实验5：验证执行HQL查询前需要执行flush()操作
		Student student = (Student) session.get(Student.class, 1);
		
		//如果修改缓存中的某个对象的属性，则Session会自动将对象属性的修改“推送”到数据库中
		student.setStuName("TomGood");
		
		//执行HQL查询
		//1.声明一个HQL查询语句
		String hql = "From Student";
		
		//2.根据HQL查询语句创建Query对象
		Query query = session.createQuery(hql);
		
		//3.调用Query对象的方法返回查询结果
		List<Student> list = query.list();
		for (Student stu : list) {
			System.out.println(stu);
		}
		
	}
	
	@Test
	public void test04() {
		//实验4：手动调用flush()方法
		Student student = (Student) session.get(Student.class, 1);
		
		//如果修改缓存中的某个对象的属性，则Session会自动将对象属性的修改“推送”到数据库中
		student.setStuName("Tom");
		
		//手动调用flush()方法也会导致发送UPDATE语句
		session.flush();
		
		System.out.println("after my flush...");
		
	}
	
	@Test
	public void test02() {
		//实验2：修改持久化对象的属性
		Student student = (Student) session.get(Student.class, 1);
		
		//如果修改缓存中的某个对象的属性，则Session会自动将对象属性的修改“推送”到数据库中
		student.setStuName("TomHappy");
	}
	
	@Test
	public void test01() {
		//实验1：两次加载OID相同的对象
		Student student = (Student) session.get(Student.class, 1);
		System.out.println(student);
		
		//第二次加载OID为1的Student对象并没有发送SQL语句
		//说明这个对象并不是从数据库中取出的，而是从缓存中读取的
		student = (Student) session.get(Student.class, 1);
		System.out.println(student);
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
