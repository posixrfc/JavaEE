package com.atguigu.bookstore.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 专门用来被其他Servlet继承
 * @author lilichao
 *
 */
public class BaseServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//解决post请求乱码，在使用request第一次获取参数之前来设置它字符集
		request.setCharacterEncoding("utf-8");
		
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		/**
		 * 根据不同业务调用不同的方法 我在页面中设置一个method参数，使用注册功能时传一个regist 使用登录功能时传一个login
		 */
		String methodName = request.getParameter("method");
		/**
		 * 根据methodName的不同调用不同的方法
		 */
		/*if ("login".equals(methodName)) {
			login(request,response);
		} else if ("regist".equals(methodName)) {
			regist(request, response);
		}*/
		
		//根据方法名获取方法的对象
		
		//getDeclaredMethod()需要传两个参数，第一个参数时方法名，第二个参数时方法的参数类型
		try {
			//获取指定的方法
			Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class , HttpServletResponse.class);
			//设置访问权限
			method.setAccessible(true);
			//调用方法
			//invoke()需要两个参数第一个是一个Object，你要调用哪个对象的方法就传哪个对象
			//第二个参数方法需要的实参
			/**
			 * 通过反射获取方法对象以后，再在Servlet添加方法不需要再修改doPost中的代码，直接添加方法即可。
			 * 所有以后再向Servlet中添加方法，只需按照doGet或doPost方法的格式创建方法即可
			 */
			method.invoke(this, request , response);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			
			//导致出现该异常的原因
			Throwable cause = e.getCause();
			//如果cause为运行时则向上抛出
			throw new RuntimeException(cause);
		}
	}

}
