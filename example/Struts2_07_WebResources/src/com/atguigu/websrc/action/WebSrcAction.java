package com.atguigu.websrc.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

public class WebSrcAction {
	
	public String getRequestMap() {
		//通过ActionContext获取封装request域数据的Map
		ActionContext actionContext = ActionContext.getContext();
		
		//没有形如getRequest()这样的方法
		Object object = actionContext.get("request");
		
		Map<String,Object> reqMap = (Map<String, Object>) object;
		
		reqMap.put("attrName", "attrValue");
		
		return "success";
	}
	
	public String getParamMap() {
		
		//通过ActionContext获取封装请求参数的Map
		ActionContext actionContext = ActionContext.getContext();
		
		Map<String, Object> parameters = actionContext.getParameters();
		
		//真正获取到的数据的类型是String数组类型
		Object object = parameters.get("userName");
		System.out.println(object);
		
		//为了获取实际的请求参数值，需要将object对象的类型转换一下
		String [] paramArr = (String[]) object;
		String userName = paramArr[0];
		System.out.println("userName="+userName);
		
		//能否通过向封装请求参数数据的Map对象中存入值，从而产生新的请求参数呢？
		//测试结果：不可行，但这样做以后也不报错。
		parameters.put("subject", "JavaWeb");
		
		return "success";
	}
	
	public String getSessionMap() {
		
		//通过ActionContext获取封装session域数据的Map
		ActionContext actionContext = ActionContext.getContext();
		
		Map<String, Object> session = actionContext.getSession();
		
		session.put("attrName", "attrValue");
		
		System.out.println(session.getClass().getName());
		
		//还原为真正的实现类类型
		SessionMap<String, Object> sm = (SessionMap<String, Object>) session;
		
		//使Session失效
		sm.invalidate();
		
		return "success";
	}
	
	public String getAppMap() {
		
		//通过ActionContext获取封装application域数据的Map
		//1.获取ActionContext对象
		//ActionContext代表当前Action类所在的上下文环境
		ActionContext actionContext = ActionContext.getContext();
		
		//2.通过ActionContext对象获取封装application域数据的Map
		Map<String, Object> application = actionContext.getApplication();
		
		//3.向Map对象中保存数据，到页面上从application域获取以进行测试
		application.put("attrName", "attrValue");
		
		return "success";
	}

}
