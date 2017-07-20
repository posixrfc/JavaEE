package cn.itcast.javaee.springmvc.app05;

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
	public HelloAction(){
		System.out.println("HelloAction()::" + this.hashCode());
	}
	/**
	 * 业务方法
	 */
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("HelloAction::handleRequest()");
		/**
		 * ModelAndView表示向视图封装的数据和真实路径
		 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","这是我的第一个springmvc应用程序，映射器_适配器_视图解析器_都可省略");
		modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	}
}
