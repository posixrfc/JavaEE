package com.atguigu.bookstore.utils;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bookstore.bean.Cart;
import com.atguigu.bookstore.bean.User;

/**
 * WEB相关的工具
 * 
 * @author lilichao
 * 
 */
public class WEBUtils {

	/**
	 * 将参数封装为一个JavaBean 要求类中属性名，和表单中的name属性值一样
	 * 
	 * @param request
	 * @param t
	 * @return
	 */
	public static <T> T param2Bean(HttpServletRequest request, T t) {

		// 获取User类的所有属性
		Field[] fields = t.getClass().getDeclaredFields();
		// 遍历fields
		for (Field field : fields) {
			// 获取属性名
			String name = field.getName();
			// 通过属性名从request中获取属性值
			String value = request.getParameter(name);
			// 使用BeanUtil为对象赋值
			try {
				// 如果value为null，那么不为属性赋值
				if (value != null && !"".equals(value)) {
					BeanUtils.copyProperty(t, name, value);
				}
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		return t;
	}

	/**
	 * 获取分页请求连接的方法
	 * 
	 * @param request
	 * @return
	 */
	public static String getPath(HttpServletRequest request) {
		// 动态获取请求地址
		// 获取项目根目录
		String contextPath = request.getContextPath();
		// 获取Servlet的地址
		String servletPath = request.getServletPath();
		// 获取查询字符串
		String queryString = request.getQueryString();
		// 截取字符串之前，判断当前queryString中是否包含&pageNumber字符串
		if (queryString.contains("&pageNumber")) {
			// 如果包含该字符串，那么将字符&pageNumber以后的部分截掉
			queryString = queryString.substring(0,
					queryString.indexOf("&pageNumber"));
		}
		
		// 拼装地址
		String path = contextPath + servletPath + "?" + queryString;
		return path;
	}

	/**
	 * 获取购物车对象的方法，如果session没有购物车，则创建并返回
	 * 					如果有则直接返回
	 * @param request
	 * @return
	 */
	public static Cart getCart(HttpServletRequest request) {
		//获取购物车对象
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		//判断cart是否为空
		if(cart == null){
			cart = new Cart();
			//将cart放入到session中
			session.setAttribute("cart", cart);
		}
		return cart;
	}

	/**
	 * 请求从哪发送就回到哪去
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	public static void goBack(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		//获取请求的来源
		String path = request.getHeader("referer");
		//判断path是否为null
		if(path==null){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			//重定向到path
			response.sendRedirect(path);
		}
		
	}

}
