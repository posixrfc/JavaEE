package junit.test;

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

import com.atguigu.hello.bean.Student;

public class SessionMethodTest {
	
	@Test
	public void test20() {
		//实验20：使用delete()方法删除一个对象后查看OID的情况
		Student student = new Student();
		student.setStuId(5);
		
		session.delete(student);
		
		//默认情况下OID的值还存在，不是null
		/*<!-- 设置指定删除操作的对象的OID置为null -->
		<property name="hibernate.use_identifier_rollback">true</property>*/
		System.out.println("stuId="+student.getStuId());
		
	}
	
	@Test
	public void test19() {
		//实验19：使用delete()方法删除持久化对象
		Object object = session.get(Student.class, 9);
		session.delete(object);
	}
	
	@Test
	public void test18() {
		//★实验18：使用delete()方法删除游离对象
		Student student = new Student();
		student.setStuId(8);
		
		session.delete(student);
		
	}
	
	@Test
	public void test17() {
		//实验17：使用saveOrUpdate()方法对一个有OID的对象执行“保存”操作
		Student student = new Student(108, "Tom2016", 58, new Date());
		
		//可以通过在hbm映射文件中的id标签内指定一个unsaved-value属性，让属性值正好等于Student对象的OID的值
		//这样saveOrUpdate()方法就知道当前Student对象是一个未保存的对象，从而执行保存操作
		session.saveOrUpdate(student);
	}
	
	@Test
	public void test16() {
		//★实验16：测试saveOrUpdate()方法的更新功能
		//小窍门：执行更新操作时当update()方法用
		//默认情况下判断的依据是是否有OID的值
		Student student = new Student(8, "Tom2015AAA", 58, new Date());
		session.saveOrUpdate(student);
	}
	
	@Test
	public void test15() {
		//★实验15：测试saveOrUpdate()方法的保存功能
		//小窍门：执行保存功能时可以当save()方法用
		Student student = new Student(null, "Tom2015", 58, new Date());
		session.saveOrUpdate(student);
	}
	
	@Test
	public void test14() {
		//实验14：使用update()方法更新一个游离对象，但此时Session缓存中已经存在了OID相同的持久化对象
		
		//加载后，缓存中就会有一个OID的值为3的持久化对象
		session.get(Student.class, 3);
		
		Student student = new Student(3, "BBB", 20, new Date());
		
		//游离对象经过update()方法后会转化为持久化状态
		//Session缓存中不允许不同对象的OID的值重复，所以会抛出异常
		session.update(student);
	}
	
	@Test
	public void test13() {
		//实验13：使用update()方法更新一个OID不存在的对象
		Student student = new Student(null, "TomAAA", 18, new Date());
		
		//不允许更新一个没有OID的对象
		session.update(student);
	}
	
	@Test
	public void test12() {
		//实验12：使用update()方法更新一个持久化对象
		Student student = (Student) session.get(Student.class, 1);
		
		student.setStuName("Tom123");
		student.setStuName("Tom456");
		student.setStuName("Tom789");
		
		//如果持久化对象并没有进行修改，则不会发送SQL语句
		//原因：update()方法只是计划发送SQL语句，是否真的发送，还要看flush操作“脏检查”机制检查的结果
		//如果数据有改变则发送，如果没有改变则不发送
		session.update(student);
		
		//脏检查机制不看程序执行过程中数据被修改了多少次，仅关注最终状态是否和快照一致
		student.setStuName("Tom");
	}
	
	@Test
	public void test11() {
		//实验11：使用update()方法更新一个游离对象，但游离对象中的数据和数据库中的一样
		Student student = (Student) session.get(Student.class, 3);
		session.clear();
		
		//为了避免盲目执行数据库底层的触发器，可以在hbm文件的class元素中设置select-before-update="true"
		//作用：在执行更新操作之前先进行查询，如果当前游离对象和数据库中的数据一致则补发送SQL语句
		session.update(student);
	}
	
	@Test
	public void test10() {
		//★实验10：使用update()方法更新一个游离对象
		Student student = new Student(4, "Kate2015", 18, new Date());
		
		//计划发送一条UPDATE语句，在执行flush操作的时候才发送，而不是当时就发送
		session.update(student);
		System.out.println("after update...");
	}
	
	@Test
	public void test09() {
		//★实验9：使用load()方法加载一个对象，然后关闭Session，再开启Session后读取某个属性值
		Student student = (Student) session.load(Student.class, 4);
		System.out.println("stuId="+student.getStuId());
		System.out.println("代理对象的全类名="+student.getClass().getName());
		
		transaction.commit();
		session.close();
		
		session = factory.openSession();
		transaction = session.beginTransaction();
		
		//Session缓存重新开启，已经没有上一次保存的Student对象，所以无法完成懒加载
		//抛出懒加载初始化异常
		//org.hibernate.LazyInitializationException
		System.out.println("stuName="+student.getStuName());
	}
	
	@Test
	public void test08() {
		//★实验8：使用load()方法加载一个对象，然后读取某个属性值
		//懒加载/延迟加载
		//作用：可以让数据尽可能晚的进入内存，在真正需要使用时才加载到内存中，从而在一定程度上节约了内存空间
		//调用load()方法时并没有立即查询数据库，而是返回一个代理对象，这个代理对象中此时仅包含OID的值
		Student student = (Student) session.load(Student.class, 4);
		System.out.println("stuId="+student.getStuId());
		System.out.println("代理对象的全类名="+student.getClass().getName());
		
		//在用到OID以外的其他属性值时，代理对象中没有，必须查询数据库才能够得到，所以这个时候才会去发送SELECT语句查询
		System.out.println("stuName="+student.getStuName());
	}
	
	@Test
	public void test07() {
		//★实验7：使用get()方法加载两个OID相同的对象
		Student student = (Student) session.get(Student.class, 3);
		System.out.println(student);
		
		student = (Student) session.get(Student.class, 3);
		System.out.println(student);
	}
	
	@Test
	public void test06() {
		//实验6：使用get()方法加载一个对象
		Student student = (Student) session.get(Student.class, 3);
		System.out.println(student);
		
		//直接是持久化状态
		student.setStuName("BobGood");
	}
	
	@Test
	public void test05() {
		//实验5：使用persist()方法保存有OID的对象
		//不允许保存一个有OID值的对象
		Student student = new Student(303, "Justin003", 15, new Date());
		session.persist(student);
	}
	
	@Test
	public void test04() {
		//实验4：使用persist()方法保存对象
		Student student = new Student(null, "Justin002", 15, new Date());
		session.persist(student);
	}
	
	@Test
	public void test03() {
		//★实验3：使用save()方法保存对象后修改OID的值
		Student student = new Student(null, "Justin002", 15, new Date());
		session.save(student);
		//执行save()方法后，临时对象会被转化为持久化状态
		//student.setStuName("Justin001");
		//在Session缓存中是通过OID的值唯一标识一个持久化对象，所以持久化对象的OID的值是不允许修改的
		student.setStuId(158);
	}
	
	@Test
	public void test02() {
		//实验2：使用save()方法保存一个指定了OID的对象
		//调用save()方法保存对象时，即使指定了OID的值，也会被无视，底层数据库还是使用指定的方式生成主键的值
		Student student = new Student(105, "Kate", 25, new Date());
		session.save(student);
	}
	
	@Test
	public void test01() {
		//★实验1：使用save()方法保存对象
		Student student = new Student(null, "Bob", 20, new Date());
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
