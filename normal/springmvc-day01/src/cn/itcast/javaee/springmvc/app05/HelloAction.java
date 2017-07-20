package cn.itcast.javaee.springmvc.app05;

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
	public HelloAction(){
		System.out.println("HelloAction()::" + this.hashCode());
	}
	/**
	 * ҵ�񷽷�
	 */
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("HelloAction::handleRequest()");
		/**
		 * ModelAndView��ʾ����ͼ��װ�����ݺ���ʵ·��
		 */
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","�����ҵĵ�һ��springmvcӦ�ó���ӳ����_������_��ͼ������_����ʡ��");
		modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	}
}
