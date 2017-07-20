package com.atguigu.mapping.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateDao {
	
	private static SessionFactory factory;
	
	static {
		
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		factory = configuration.buildSessionFactory(serviceRegistry);
		
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}
	
	public void save() {
		Session session = factory.openSession();
		System.out.println(session.hashCode());
	}
	
	public void update() {
		Session session = factory.openSession();
		System.out.println(session.hashCode());
	}
	
	public void save(Session session) {
		System.out.println(session.hashCode());
	}
	
	public void update(Session session) {
		System.out.println(session.hashCode());
	}
	
	public void threadSave() {
		Session session = factory.getCurrentSession();
		System.out.println(session.hashCode());
	}
	
	public void threadUpdate() {
		Session session = factory.getCurrentSession();
		System.out.println(session.hashCode());
	}

}
