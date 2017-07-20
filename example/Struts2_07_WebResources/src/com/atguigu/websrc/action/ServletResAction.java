package com.atguigu.websrc.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class ServletResAction {
	
	public String testServletActionContext() {
		
		//通过ServletActionContext获取原生的Web资源对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		ServletContext servletContext = ServletActionContext.getServletContext();
		
		System.out.println(request);
		System.out.println(session);
		System.out.println(servletContext);
		
		return "success";
	}

}
