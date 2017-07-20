package com.atguigu.bookstore.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.atguigu.bookstore.bean.User;

/**
 * 对订单相关操作的是否登录的验证
 * @author lilichao
 *
 */
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//将Request强转为HttpServletRequest
		HttpServletRequest req = (HttpServletRequest) request;
		//获取Session
		HttpSession session = req.getSession();
		//获取loinUser
		User user = (User) session.getAttribute("loginUser");
		//判断当前user是否为空
		if(user == null){
			//设置提示消息
			request.setAttribute("msg", "当前操作必须登录！");
			//如果为null，转发登录页面
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else{
			//如果User不为空
			chain.doFilter(request, response);
		}
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
