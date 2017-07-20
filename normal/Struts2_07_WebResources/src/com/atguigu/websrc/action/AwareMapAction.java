package com.atguigu.websrc.action;
import java.util.Map;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
public class AwareMapAction implements RequestAware,SessionAware,ApplicationAware,ParameterAware{
	private Map<String, String[]> parameters;
	private Map<String, Object> application;
	private Map<String, Object> session;
	private Map<String, Object> request;
	public String testXxxAware() {
		System.out.println("------parameters--------" + parameters);
		System.out.println("------application--------" + application);
		System.out.println("------session--------" + session);
		System.out.println("------request--------" + request);	
		return "success";
	}
	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
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
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}
}