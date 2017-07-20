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
 * 处理用户注册请求的Servlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService userService = new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户输入的用户名、密码、电子邮件
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		//将信息封装为User对象
		User user = new User(null, username, password, email);
		
		//向数据库中插入用户
		boolean regist = userService.regist(user);
		
		//根据结果派发页面
		if(regist){
			//注册成功，重定向到regist_success.html
			response.sendRedirect(request.getContextPath()+"/pages/user/regist_success.jsp");
		}else{
			
			//注册失败返回一个错误消息
			request.setAttribute("msg", "用户名已存在");
			//注册失败，转发到regist.html
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}
	}

}
