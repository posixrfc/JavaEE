package com.atguigu.websrc.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

public class ServletAwareAction implements ServletRequestAware, ServletContextAware{

	private ServletContext servletContext;
	private HttpServletRequest request;
	
	public String testServletXxxAware() {
		
		System.out.println(request);
		System.out.println(servletContext);
		
		return "success";
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
