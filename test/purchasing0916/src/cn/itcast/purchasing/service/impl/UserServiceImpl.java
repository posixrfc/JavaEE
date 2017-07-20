package cn.itcast.purchasing.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import cn.itcast.purchasing.dao.mapper.PurSysUserMapper;
import cn.itcast.purchasing.po.PurSysUser;
import cn.itcast.purchasing.po.PurSysUserExample;
import cn.itcast.purchasing.service.UserService;
import cn.itcast.purchasing.util.MD5;
import cn.itcast.purchasing.vo.ActiveUser;

public class UserServiceImpl implements UserService {

	@Autowired
	private PurSysUserMapper purSysUserMapper;
	
	@Override
	public PurSysUser findUserByUserId(String userId) throws Exception {
		PurSysUserExample purSysUserExample = new PurSysUserExample();
		PurSysUserExample.Criteria criteria = purSysUserExample.createCriteria();
		criteria.andUseridEqualTo(userId);
//		List<PurSysUser> list  = purSysUserMapper.selectByExample(purSysUserExample);
		List<PurSysUser> list  = purSysUserMapper.selectByExample(purSysUserExample);
		if(list!=null && list.size() == 1)
			return list.get(0);
		
		return null;
	}
	@Override
	public ActiveUser checkUser(String userId, String pwd) throws Exception {
		PurSysUser purSysUser = this.findUserByUserId(userId);
		if(purSysUser == null)
			return null;
		
		String pwd_md5 = new MD5().getMD5ofStr(pwd);
		if(!pwd_md5.equalsIgnoreCase(purSysUser.getPwd()))
			return null;
		
		ActiveUser activeUser = new ActiveUser();
		activeUser.setUserid(purSysUser.getId());
		activeUser.setUsername(purSysUser.getUsername());
		return activeUser;
	}
}