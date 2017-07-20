package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.User;


/**
 * 
 * <p>Title: UserMapper</p>
 * <p>Description:mapper接口 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-17下午3:12:26
 * @version 1.0
 */
public interface UserMapper {
	
	//根据用户id查询用户信息
	public User findUserById(int id) throws Exception;
	
	//查询用户列表
	public List<User> findUserList(String username)throws Exception;

}
