package com.atguigu.hello.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.Test;

import com.atguigu.hello.bean.Student;

public class HibernateTest {

	@Test
	public void helloWorld() {
//		①创建SessionFactory对象
		//[1]创建封装了Hibernate配置信息的Configuration对象
		//如果Hibernate配置文件使用了默认的文件名，则调用无参的configure()方法即可
		Configuration configure = new Configuration().configure();
		
		//[2]创建用于注册配置信息的ServiceRegistry对象
		//(1)创建ServiceRegistryBuilder对象
		ServiceRegistryBuilder builder = new ServiceRegistryBuilder();
		
		//(2)让ServiceRegistryBuilder对象接受Configuration对象中封装的配置信息
		builder.applySettings(configure.getProperties());
		
		//(3)使用ServiceRegistryBuilder对象构建ServiceRegistry对象
		ServiceRegistry serviceRegistry = builder.buildServiceRegistry();
		
		//[3]使用Configuration对象创建SessionFactory对象
		SessionFactory factory = configure.buildSessionFactory(serviceRegistry);
		//Hibernate在创建SessionFactory对象时，会自动根据hbm映射文件创建数据库表
		System.out.println(factory);
		
//		②通过SessionFactory对象开启一个Hibernate和数据库之间的会话，也就是创建Session对象
		Session session = factory.openSession();
		
//		③通过Session对象开启事务——Hibernate建议将所有数据库操作都纳入到事务的管理中，哪怕仅仅是一个查询操作
		Transaction transaction = session.beginTransaction();
		
//		④创建Student对象
		Student student = new Student(null, "Kate", 20, new Date());
		
//		⑤将Student对象保存到数据库中
		session.save(student);
		
//		⑥提交事务
		transaction.commit();
		
//		⑦关闭Hibernate和数据库之间的会话，即关闭Session对象
		session.close();
		
//		⑧关闭SessionFactory
		factory.close();
	}

}
