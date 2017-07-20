package com.atguigu.websrc.action;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import com.opensymphony.xwork2.ActionContext;

public class WebSrcAction {
	public String getRequestMap() {
		ActionContext actionContext = ActionContext.getContext();
		Object object = actionContext.get("request");
		@SuppressWarnings("unchecked")
		Map<String,Object> reqMap = (Map<String, Object>) object;
		reqMap.put("attrName", "attrValue");
		return "success";
	}
	public String getParamMap() {	
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> parameters = actionContext.getParameters();	
		Object object = parameters.get("userName");
		String [] paramArr = (String[]) object;
		String userName = paramArr[0];
		System.out.println("userName="+userName);
		parameters.put("subject", "JavaWeb");	
		return "success";
	}
	public String getSessionMap() {	
		ActionContext actionContext = ActionContext.getContext();	
		Map<String, Object> session = actionContext.getSession();	
		session.put("attrName", "attrValue");
		System.out.println("--"+session.getClass().getName());	
		SessionMap<String, Object> sm = (SessionMap<String, Object>) session;	
		return "success";
	}
	public String getAppMap() {
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> application = actionContext.getApplication();
		application.put("attrName", "attrValue");
		return "success";
	}
}