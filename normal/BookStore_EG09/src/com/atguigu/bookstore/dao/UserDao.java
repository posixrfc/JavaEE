package com.atguigu.bookstore.dao;

import com.atguigu.bookstore.bean.User;

/**
 * 用户相关的数据库操作的接口
 * @author lilichao
 *
 */
public interface UserDao {
	
	/**
	 * 根据用户名和密码查询用户
	 * @param user
	 * @return
	 */
	User getUserByUserNameAndPassword(User user);
	
	/**
	 * 向数据库中插入一个用户
	 * @param user
	 * @return
	 */
	int saveUser(User user);
	
	/**
	 *  根据用户名查找用户
	 */
	User getUserByUsername(String username);
	
}
