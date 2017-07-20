package cn.itcast.springmvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

/**
 * 
 * <p>Title: Hello1</p>
 * <p>Description: 使用HttpRequestHandlerAdapter</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-15上午10:57:17
 * @version 1.0
 */

public class Hello1 implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//向页面显示一行提示信息
		String message = "hellworld1";
	    request.setAttribute("message", message);
	    
	    //指定转向页面，使用request指定页面完整路径
	    request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request, response);
		
	}

}
