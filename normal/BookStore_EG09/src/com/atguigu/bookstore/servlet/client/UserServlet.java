package com.atguigu.bookstore.servlet.client;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;
import com.atguigu.bookstore.servlet.BaseServlet;
import com.atguigu.bookstore.utils.WEBUtils;

/**
 * 处理用户相关业务的Servlet
 * 
 * @author lilichao
 * 
 */
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	private UserService userService = new UserServiceImpl();
	
	
	/**
	 * 检查用户名是否存在
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void checkUsername(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//获取用户名
		String username = request.getParameter("username");
		//调用Service检查用户名
		boolean flag = userService.checkUsername(username);
		//根据结果发送响应信息
		if(flag){
			//用户名可以用，返回一个1
			response.getWriter().print("1");
		}else{
			//用户名不可用，返回一个0
			response.getWriter().print("0");
		}
	}
	
	/**
	 * 用户注销的方法
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void logout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//获取Session对象
		HttpSession session = request.getSession();
		//强制Session失效
		session.invalidate();
		//重定向到首页
		response.sendRedirect(request.getContextPath()+"/index.jsp");
		
		
	}

	protected void regist(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//获取Session对象
		HttpSession session = request.getSession();
		
		//验证用户输入的验证码是否正确
		//1.获取用户输入的验证码
		String reqCode = request.getParameter("code");
		//2.获取Session中的验证码
		String seCode = (String) session.getAttribute("code");
		
		//3.将验证码从session中移除
		session.removeAttribute("code");
		
		//验证验证码
		if(reqCode!=null && reqCode.equals(seCode)){
			//验证码输入正确
			
			//通过工具类封装一个User对象
			User user = WEBUtils.param2Bean(request, new User());
		
			// 向数据库中插入用户
			boolean regist = userService.regist(user);
		
			// 根据结果派发页面
			if (regist) {
				// 注册成功，重定向到regist_success.html
				response.sendRedirect(request.getContextPath()
						+ "/pages/user/regist_success.jsp");
			} else {
		
				// 注册失败返回一个错误消息
				request.setAttribute("msg", "用户名已存在");
				// 注册失败，转发到regist.html
				request.getRequestDispatcher("/pages/user/regist.jsp").forward(
						request, response);
			}
		
		}else{
			// 注册失败返回一个错误消息
			request.setAttribute("msg", "验证码输入错误");
			// 注册失败，转发到regist.html
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(
					request, response);
		}
	}

	protected void login(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取用户输入的用户名和密码
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");

		// 将用户名和密码封装为一个user对象
		User user = new User(null, username, password, null);*/
		
		//获取Session对象
		HttpSession session = request.getSession();
		
		User user = WEBUtils.param2Bean(request, new User());

		// 通过UserService验证用户名和密码
		User loginUser = userService.login(user);

		// 判断loginUser是否为null
		if (loginUser != null) {
			
			//登录成功以后将loginUser对象放入到session中
			session.setAttribute("loginUser", loginUser);
			
			// 登录成功，重定向到login_success.html
			response.sendRedirect(request.getContextPath()
					+ "/pages/user/login_success.jsp");
		} else {

			// 登录失败时，需要给JSP页面返回一个错误消息
			request.setAttribute("msg", "用户名或密码错误");

			// 登录失败，转发login.html
			request.getRequestDispatcher("/pages/user/login.jsp").forward(
					request, response);
		}
	}

}
