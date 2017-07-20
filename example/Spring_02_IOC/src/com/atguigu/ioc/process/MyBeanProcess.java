package com.atguigu.ioc.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanProcess implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		
		//1.当前方法调用的时机：在bean初始化方法之前调用
		System.out.println("postProcessBefore...");
		
		//2.传入的参数：bean就是IOC容器创建的对象，beanName就是bean的id值
		System.out.println("bean="+bean+" beanName="+beanName);
		
		//3.返回值：用户从IOC容器中获取bean时，得到的就是当前方法的返回值
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		
		//方法调用的时机：在bean初始化方法之后调用
		System.out.println("postProcessAfter...");
		
		return bean;
	}

}
