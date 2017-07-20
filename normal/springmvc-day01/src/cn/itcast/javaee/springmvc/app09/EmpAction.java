package cn.itcast.javaee.springmvc.app09;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 控制器是实现Controller接口的类
 * @author AdminTC
 */
public class EmpAction implements Controller{
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView  modelAndView = new ModelAndView();
		//设置编码方式
		request.setCharacterEncoding("UTF-8");
		//获取员工姓名
		String username = request.getParameter("username");
		//显示
		System.out.println("员工姓名：" + username);
		//将员工姓名封装到ModelAndView对象中去
		modelAndView.addObject("message",username);
		//将真实路径名封装到ModelAndView对象中去
		modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	}
}

/**
 * 1)Action类实现Controller接口，带来了代码耦合
 * 2)如果参数过多，实现Controller接口的Action收集起来不便
 */










