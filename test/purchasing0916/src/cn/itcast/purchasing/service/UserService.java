package cn.itcast.purchasing.service;

import cn.itcast.purchasing.po.PurSysUser;
import cn.itcast.purchasing.vo.ActiveUser;

public interface UserService {
	
	public PurSysUser findUserByUserId(String userId)throws Exception;
	
	public ActiveUser checkUser(String userId,String pwd) throws Exception;
}