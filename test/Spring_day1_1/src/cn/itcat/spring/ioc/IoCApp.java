package cn.itcat.spring.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class IoCApp {
	public static void main(String[] args) {
		/*
		//原始格式
		UserService service = new UserService();
		service.fn();
		*/
		/*
		//Spring格式
		//获取Bean需要使用Spring的工厂类
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
		//获取Bean
		UserService service = (UserService) ctx.getBean("userService");
		//执行操作
		service.fn();
		*/
		/*
		//文件系统获取上下文
		ApplicationContext ctx = new FileSystemXmlApplicationContext("applicationContext.xml");
		UserService service = (UserService) ctx.getBean("userService");
		service.fn();
		*/
		
		//BeanFactory获取Bean
		Resource res = new ClassPathResource("applicationContext2.xml");
		BeanFactory bf = new XmlBeanFactory(res);
		//UserService service = (UserService) bf.getBean("userService");
		//service.fn();
		
	}
}
