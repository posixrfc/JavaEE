package cn.itcast.javaee.springmvc.app07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 单例
 * 控制器Action
 * 处理器Action
 * @author AdminTC
 */
public class HelloAction implements Controller{
	/**
	 * 业务方法
	 */
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","这是我的第二个springmvc应用程序，视图使用逻辑名");

		//原来封装视图的真实路径
		//modelAndView.setViewName("/jsp/success.jsp");
		
		//现在封装视图的逻辑名称
		modelAndView.setViewName("success");

		return modelAndView;
	}
}
