package junit.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.ioc.bean.Book;
import com.atguigu.ioc.component.UserAction;

public class IOCTest {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
	
	@Test
	public void test24() {
		//实验24：基于XML的自动装配
		UserAction userAction = (UserAction) ioc.getBean("userAction");
		userAction.save();
	}
	
	@Test
	public void test23() throws SQLException {
		//实验23：引用外部属性文件★
		DataSource dataSource = ioc.getBean(DataSource.class);
		Connection connection = dataSource.getConnection();
		System.out.println(connection);
	}
	
	@Test
	public void test22() {
		//实验22[补充]：测试bean的后置处理器
		
	}
	
	@Test
	public void test21() {
		//实验22：创建带有生命周期方法的bean
		ConfigurableApplicationContext lifeIOC = (ConfigurableApplicationContext) ioc;
		lifeIOC.close();
	}
	
	@Test
	public void test20() {
		System.out.println("IOC容器已经创建完毕了");
		//实验21：测试bean的作用域，分别创建单实例和多实例的bean★
		Object bean01 = ioc.getBean("struts2Action");
		Object bean02 = ioc.getBean("struts2Action");
		
		System.out.println(bean01 == bean02);
	}
	
	@Test
	public void test19() {
		
//		Object bean = ioc.getBean("templateBook");
//		System.out.println(bean);
		Object bean = ioc.getBean("templateSub");
		System.out.println(bean);
	}
	
	@Test
	public void test18() {
		//实验18：通过继承实现bean配置信息的重用
		Object parentBook = ioc.getBean("parentBook");
		Object subBook = ioc.getBean("subBook");
		System.out.println(parentBook);
		System.out.println(subBook);
	}
	
	@Test
	public void test17() {
		//实验17：配置FactoryBean★
		Object bean = ioc.getBean("myFactoryBeanBook");
		System.out.println(bean);
	}

	@Test
	public void test16() {
		//实验16：配置通过实例工厂方法创建的bean
		Object object = ioc.getBean("book16");
		System.out.println(object);
	}
	
	@Test
	public void test15() {
		//实验15：配置通过静态工厂方法创建的bean
		Book book = (Book) ioc.getBean("book15");
		System.out.println(book);
	}

}
