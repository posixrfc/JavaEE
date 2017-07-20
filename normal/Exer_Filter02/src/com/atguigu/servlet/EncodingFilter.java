package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	
	private String encode;

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//设置请求的编码
		request.setCharacterEncoding(encode);
		//设置响应编码
		response.setContentType("text/html;charset="+encode);
		//放行请求
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		//获取参数中编码
		ServletContext servletContext = fConfig.getServletContext();
		encode = servletContext.getInitParameter("encode");
	}

}
