package junit.test;

import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.ioc.bean.Circle;
import com.atguigu.ioc.bean.Department;
import com.atguigu.ioc.bean.Employee;
import com.atguigu.ioc.component.OrderAction;

public class IOCTest {

	private ApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
	
	@Test
	public void test03() {
		//测试自动装配
		OrderAction orderAction = ioc.getBean(OrderAction.class);
		orderAction.save();
	}
	
	@Test
	public void test02() {
		//获取通过注解配置的bean
		try {
			OrderAction orderAction = ioc.getBean(OrderAction.class);
			System.out.println(orderAction);
		} catch (BeansException e) {
			System.out.println("orderAction没有获取到");
		}
		
		try {
			Object bean = ioc.getBean("beautifulDao");
			System.out.println(bean);
		} catch (BeansException e) {
			System.out.println("dao没有获取到");
		}
		
		try {
			Object bean2 = ioc.getBean("happyService");
			System.out.println(bean2);
		} catch (BeansException e) {
			System.out.println("service没有获取到");
		}
		
		try {
			Object bean3 = ioc.getBean("commonComponent");
			System.out.println(bean3);
		} catch (BeansException e) {
			System.out.println("普通组件没有获取到");
		}
	}
	
	@Test
	public void test01() {
		Employee employee = ioc.getBean(Employee.class);
		System.out.println(employee);
		
		Department department = ioc.getBean(Department.class);
		System.out.println(department);
		
		Circle circle = ioc.getBean(Circle.class);
		System.out.println(circle.getLength());
	}

}
