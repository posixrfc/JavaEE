package cn.itcast.javaee.springmvc.app07;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * ����
 * ������Action
 * ������Action
 * @author AdminTC
 */
public class HelloAction implements Controller{
	/**
	 * ҵ�񷽷�
	 */
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","�����ҵĵڶ���springmvcӦ�ó�����ͼʹ���߼���");

		//ԭ����װ��ͼ����ʵ·��
		//modelAndView.setViewName("/jsp/success.jsp");
		
		//���ڷ�װ��ͼ���߼�����
		modelAndView.setViewName("success");

		return modelAndView;
	}
}
