package com.atguigu.online.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class OnlineAction extends ActionSupport implements ParameterAware,SessionAware,ApplicationAware{

	private static final long serialVersionUID = 1L;
	
	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, String[]> parameters;
	
	public String login() throws Exception {
		String userName = parameters.get("userName")[0];
		session.put("loginUser", userName);
		Object onlineNumObj = application.get("onlineNum");
		if(onlineNumObj == null) {
			application.put("onlineNum", 1);
		}else{
			Integer onlineNum = (Integer) onlineNumObj;
			onlineNum++;
			application.put("onlineNum", onlineNum);
		}
		return SUCCESS;
	}
	
	public String logout() throws Exception {
		SessionMap sm = (SessionMap) this.session;
		sm.invalidate();
		Object onlineNumObj = application.get("onlineNum");
		if(onlineNumObj != null) {
			Integer onlineNum = (Integer) onlineNumObj;
			onlineNum--;
			application.put("onlineNum", onlineNum);
		}
		return SUCCESS;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}

}
