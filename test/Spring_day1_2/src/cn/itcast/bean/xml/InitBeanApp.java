package cn.itcast.bean.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class InitBeanApp {
	//bean初始化
	public void beanInit(){
		//获取Spring的应用上下文对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		//获取Bean,使用配置的Bean的id或name
		Bean1 bean = (Bean1) ctx.getBean("bean1");
		bean.test();
		*/
		/*
		//使用静态工厂初始化Bean的获取
		Bean2 bean = (Bean2) ctx.getBean("bean2");
		bean.test();
		*/
		
		/*
		Bean3InstFactory factory  = new Bean3InstFactory();
		System.out.println(factory.getInst());
		*/
		/*
		//使用实例工厂初始化Bean的获取
		Bean3 bean = (Bean3) ctx.getBean("bean3");
		bean.test();
		*/
	}
	
	//延迟Bean作用域
	public void beanScope(){
		//获取Spring的应用上下文对象
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		//Bean的作用域
		Bean1 bean1 = (Bean1) ctx.getBean("bean4");
		Bean1 bean2 = (Bean1) ctx.getBean("bean4");
		System.out.println(bean1);
		System.out.println(bean2);
	}
	//生命周期
	public void lifecycle(){
		//ApplicationContext不提供关闭容器的操作
		//使用ClassPathXmlApplicationContext可以进行容器的关闭
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ctx.getBean("bean5");
		ctx.close();
	}
	//构造器注入
	public void constructor(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean6 bean = (Bean6) ctx.getBean("bean6");
		bean.test();
	}
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Bean10 bean = (Bean10) ctx.getBean("bean10");
		bean.test();
	}
}
