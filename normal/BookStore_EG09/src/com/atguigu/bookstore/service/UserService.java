package com.atguigu.bookstore.service;

import com.atguigu.bookstore.bean.User;

/**
 * 处理用户相关业务的Service
 * @author lilichao
 *
 */
public interface UserService {
	
	/**
	 * 用户登录的方法
	 * @param user
	 * @return
	 */
	User login(User user);
	
	/**
	 * 用户注册的方法
	 * @param user
	 * @return
	 */
	boolean regist(User user);
	
	/**
	 * 检查用户名是否存在，存在返回false 不存在返回一个true
	 * @param username
	 * @return
	 */
	boolean checkUsername(String username);

}
