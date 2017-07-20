package cn.itcast.springmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 
 * <p>Title: Hello</p>
 * <p>Description: 使用SimpleControllerHandlerAdapter适配器</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-15上午10:59:25
 * @version 1.0
 */
public class Hello implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//向页面显示一行提示信息
		//下边的方法就相当于request.setAttribute(arg0, arg1)
		modelAndView.addObject("message", "helloworld!!!!!!");
		
		//指定jsp页面地址
		
		//modelAndView.setViewName("/WEB-INF/jsp/hello.jsp");
		//指定逻辑视图名，真正的视图地址：前缀+逻辑视图名+后缀
		modelAndView.setViewName("hello");
		
		return modelAndView;
	}

}
