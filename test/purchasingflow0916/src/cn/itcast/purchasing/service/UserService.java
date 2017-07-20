package cn.itcast.purchasing.service;

import cn.itcast.purchasing.po.PurSysUser;
import cn.itcast.purchasing.vo.ActiveUser;

public interface UserService {
	
	//根据用户账号查询用户信息
	public PurSysUser findUserByUserId(String userId)throws Exception;
	
	//用户认证
	public ActiveUser checkUser(String userId,String pwd) throws Exception;
}
