package com.atguigu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.atguigu.req.MyRequest2;

public class WordFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		String info = request.getParameter("info");
		
		//使用*替换敏感字符
		//info = info.replace("贺飞", "**");
		//修改一个请求参数
		/**
		 * HttpServletRequest中并没有一个设置请求参数的方法，所以我们不能直接设置，
		 * 我们思考一下，可以不可修改HttpServletRequest的get方法
		 * 直接修改是肯定不行的，那么能自己写一个HttpServletRequest的实现类，来替换原有的类
		 */
		
		//System.out.println(info);
		
		//使用我们创建的MyRequest2来包装ServletRequest对象
		MyRequest2 req = new MyRequest2((HttpServletRequest)request);
		
		//向下个资源传递包装过的Request对象
		chain.doFilter(req, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
