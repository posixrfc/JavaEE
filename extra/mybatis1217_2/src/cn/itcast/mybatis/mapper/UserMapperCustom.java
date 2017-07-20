package cn.itcast.mybatis.mapper;

import java.util.List;

import cn.itcast.mybatis.po.QueryVo;
import cn.itcast.mybatis.po.User;


/**
 * 
 * <p>Title: UserMapperCustom</p>
 * <p>Description:mapper接口 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-17下午3:12:26
 * @version 1.0
 */
public interface UserMapperCustom {
	
	//查询用户列表
	public List<User> findUserList(QueryVo queryVo) throws Exception;
	
	//查询用户列表 总数
	public int findUserCount(QueryVo queryVo) throws Exception;
	
	//查询用户列表 使用resultMap
	//List中的user是resultMap定义中的type(最终映射的java对象)
	public List<User> findUserListResultMap(QueryVo queryVo) throws Exception;
	
	
}
