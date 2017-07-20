package com.atguigu.online.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

public class OnlineAction implements ParameterAware, SessionAware, ApplicationAware{

	private Map<String, Object> appMap;
	private Map<String, Object> sessMap;
	private Map<String, String[]> paramMap;
	
	public String logout() {
		
		//目标1：让Session失效
		SessionMap sm = (SessionMap) sessMap;
		sm.invalidate();
		
		//目标2：让当前在线人数-1
		//1.获取当前的在线人数
		Integer onlineNum = (Integer) appMap.get("onlineNum");
		
		//2.如果当前在线人数不为空，且不小于0，则-1
		if(onlineNum != null && onlineNum > 0) {
			onlineNum--;
			
			//3.重新保存到Application域中
			appMap.put("onlineNum", onlineNum);
		}
		
		return "success";
	}
	
	public String login() {
		
		//从请求参数中获取用户名字符串
		String userName = paramMap.get("userName")[0];
		if(userName != null) {
			//目标1：如果用户名不为空，则将用户名保存到Session域中，表示用于已经登录
			sessMap.put("loginUser", userName);
			
			//目标2：如果用户名不为空，则将Application域中保存的在线人数+1
			//1.尝试获取当前在线人数
			Integer onlineNum = (Integer) appMap.get("onlineNum");
			
			//2.判断当前在线人数数据是否存在
			if(onlineNum == null) {
				//3.如果为空，则将1保存到Application域中
				appMap.put("onlineNum", 1);
			}else{
				//4.如果不为空，则在原有基础上+1
				onlineNum++;
				
				//5.将+1后的在线人数保存到Application域中
				appMap.put("onlineNum", onlineNum);
			}
		}
		
		return "success";
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.appMap = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessMap = arg0;
	}

	@Override
	public void setParameters(Map<String, String[]> arg0) {
		this.paramMap = arg0;
	}

}
