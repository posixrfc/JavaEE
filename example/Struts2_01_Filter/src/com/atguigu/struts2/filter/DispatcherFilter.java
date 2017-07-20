package com.atguigu.struts2.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.struts2.bean.Book;

public class DispatcherFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//1.获取当前请求的servletPath值，以判断当前请求的目标资源
		String servletPath = request.getServletPath();
		//System.out.println(servletPath);// /saveUI.action
		
		//2.如果目标资源是表单页面，则直接将请求转发到表单页面
		if("/saveUI.action".equals(servletPath)) {
			request.getRequestDispatcher("/saveUI.jsp").forward(request, response);
		}else if("/saveBook.action".equals(servletPath)) {
			//3.如果当前请求是提交表单数据
			//①接收请求参数
			String bookName = request.getParameter("bookName");
			String author = request.getParameter("author");
			String priceStr = request.getParameter("price");
			
			//②将表单提交的price值的类型转换为double类型
			double price = Double.parseDouble(priceStr);
			
			//③将请求参数封装为Book对象
			Book book = new Book(null, bookName, author, price);
			
			//④将book对象保存到请求域中
			request.setAttribute("book", book);
			
			//⑤将请求转发到detail.jsp
			request.getRequestDispatcher("/detail.jsp").forward(request, response);
		}
		
	}

}
