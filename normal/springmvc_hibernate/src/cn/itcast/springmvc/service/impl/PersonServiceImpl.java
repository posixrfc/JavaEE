package cn.itcast.springmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.springmvc.dao.PersonDao;
import cn.itcast.springmvc.model.Person;
import cn.itcast.springmvc.service.PersonService;
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonDao personDao;
	
	@Override
	public void save(Person p) {
		personDao.save(p);
	}

}
