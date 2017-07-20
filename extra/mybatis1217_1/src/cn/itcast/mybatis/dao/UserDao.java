package cn.itcast.mybatis.dao;

import java.util.List;

import cn.itcast.mybatis.po.User;

/**
 * 
 * <p>Title: UserDao</p>
 * <p>Description: 用户管理dao</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-17下午2:48:11
 * @version 1.0
 */
public interface UserDao {
	
	//根据用户id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//添加用户
	public void insertUser(User user) throws Exception;
	
	//查询用户列表
	public List<User> findUserList()throws Exception;
}
