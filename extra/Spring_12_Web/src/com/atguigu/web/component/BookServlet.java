package com.atguigu.web.component;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookService bookService;
	
	@Override
	public void init() throws ServletException {
		//1.获取ServletContext对象
		ServletContext servletContext = this.getServletContext();
		
		//2.从ServletContext对象中获取IOC容器对象
		ApplicationContext ioc = (ApplicationContext) servletContext.getAttribute("ioc");
		
		//3.从IOC容器对象中获取BookService对象给this.bookService赋值
		this.bookService = ioc.getBean(BookService.class);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String message = this.bookService.getMessage();
		response.getWriter().write(message);
		
	}

}
