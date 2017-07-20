package com.atguigu.bookstore.service.impl;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.dao.UserDao;
import com.atguigu.bookstore.dao.impl.UserDaoImpl;
import com.atguigu.bookstore.service.UserService;

public class UserServiceImpl implements UserService {
	
	//创建一个UserDao对象
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(User user) {
		return userDao.getUserByUserNameAndPassword(user);
	}

	@Override
	public boolean regist(User user) {
		
		int count = userDao.saveUser(user);
		
		return count>0;
	}

	@Override
	public boolean checkUsername(String username) {
		
		User user = userDao.getUserByUsername(username);
		//如果user为null，返回true代表可用，否则返回false代表不可用
		return user==null;
	}

}
