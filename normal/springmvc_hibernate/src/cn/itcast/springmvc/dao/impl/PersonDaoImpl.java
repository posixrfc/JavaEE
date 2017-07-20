package cn.itcast.springmvc.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import cn.itcast.springmvc.dao.PersonDao;
import cn.itcast.springmvc.model.Person;
@Repository
public class PersonDaoImpl extends HibernateDaoSupport implements PersonDao {

	@Autowired
	public void setMySessionFactory(SessionFactory sf){
		super.setSessionFactory(sf);
	}
	
	@Override
	public void save(Person p) {
		this.getHibernateTemplate().save(p);
	}

}
