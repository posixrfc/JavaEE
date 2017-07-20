package com.atguigu.jpa.test;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.atguigu.jpa.entities.Person;
public class Client{
	public static void main(String[] args){
		//1	先获取EntityManagerFactory会话工厂
		String persistenceUnitName = "jpa001";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		//2	在获得EntityManager
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//3	开启事务
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		//4 进行持久化操作，调用ORM框架的API
		Person person = new Person();
		person.setAge(22);
		person.setBirth(new Date());
		person.setPersonName("lisi");
		person.setSalary(3000.05);
		person.setRegisterTime(new Date());
		
		entityManager.persist(person);
		//5	提交事务
		entityTransaction.commit();
		//6 关闭会话EntityManager
		entityManager.close();
		//7 关闭EntityManagerFactory
		entityManagerFactory.close();
	}
}