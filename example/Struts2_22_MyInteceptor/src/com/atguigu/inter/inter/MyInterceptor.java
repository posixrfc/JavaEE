package com.atguigu.inter.inter;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ValidationAware;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MyInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;
	
	private String subject;
	
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		//打印拦截器参数值
		System.out.println("subject="+subject);
		
		//1.获取目标Action对象
		Object action = invocation.getAction();
		System.out.println("目标Action对象："+action);
		
		//2.获取Web资源
		//ActionContext.getContext().getParameters();
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
		Object object = parameters.get("userName");
		String [] paramArr = (String[]) object;
		String userName = paramArr[0];
		
		//3.根据一定的判断条件决定是否执行后续拦截器
		//①判断当前请求参数userName的值是否是Tom2015
		if("Tom2015".equals(userName)) {
			//②如果是则执行后续拦截器
			return invocation.invoke();
			
		}else{
			//③如果不是则return "input"
			if(action instanceof ValidationAware) {
				ValidationAware va = (ValidationAware) action;
				va.addActionError("您输入的用户名不正确！");
			}
			return "input";
		}
	}
}
