package cn.itcast.javaee.springmvc.app09;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * ��������ʵ��Controller�ӿڵ���
 * @author AdminTC
 */
public class EmpAction implements Controller{
	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView  modelAndView = new ModelAndView();
		//���ñ��뷽ʽ
		request.setCharacterEncoding("UTF-8");
		//��ȡԱ������
		String username = request.getParameter("username");
		//��ʾ
		System.out.println("Ա��������" + username);
		//��Ա��������װ��ModelAndView������ȥ
		modelAndView.addObject("message",username);
		//����ʵ·������װ��ModelAndView������ȥ
		modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	}
}

/**
 * 1)Action��ʵ��Controller�ӿڣ������˴������
 * 2)����������࣬ʵ��Controller�ӿڵ�Action�ռ���������
 */










