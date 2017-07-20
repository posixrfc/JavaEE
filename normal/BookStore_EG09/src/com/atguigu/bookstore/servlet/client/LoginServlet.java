package com.atguigu.bookstore.servlet.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

/**
 * 用来处理用户登录的Servlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户输入的用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//将用户名和密码封装为一个user对象
		User user = new User(null, username, password, null);
		
		//通过UserService验证用户名和密码
		User loginUser = userService.login(user);
		
		//判断loginUser是否为null
		if(loginUser != null){
			//登录成功，重定向到login_success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/login_success.jsp");
		}else{
			
			//登录失败时，需要给JSP页面返回一个错误消息
			request.setAttribute("msg", "用户名或密码错误");
			
			//登录失败，转发login.html
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}
	}

}
