package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户输入的信息
		String info = request.getParameter("info");
		
		//将info放入request域中
		request.setAttribute("info", info);
		
		//转发到bbs.jsp
		request.getRequestDispatcher("/bbs.jsp").forward(request, response);
		
	}

}
