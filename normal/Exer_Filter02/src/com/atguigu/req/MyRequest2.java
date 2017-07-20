package com.atguigu.req;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MyRequest2 extends HttpServletRequestWrapper {

	public MyRequest2(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String name) {
		
		//没有过滤过的属性
		String parameter = super.getParameter(name);
		
		return parameter.replace("贺飞", "**");
	}

}
