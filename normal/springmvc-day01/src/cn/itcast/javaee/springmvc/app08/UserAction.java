package cn.itcast.javaee.springmvc.app08;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * ������
 * @author AdminTC
 */
public class UserAction implements Controller{
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("�����û�");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","�����û��ɹ�");
		modelAndView.setViewName("success");
		return modelAndView;
	}
}
