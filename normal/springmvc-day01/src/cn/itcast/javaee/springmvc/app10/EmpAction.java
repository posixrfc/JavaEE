package cn.itcast.javaee.springmvc.app10;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

/**
 * ����
 * ������
 * @author AdminTC
 */
@SuppressWarnings("deprecation")
public class EmpAction extends AbstractCommandController{
	public EmpAction(){
		//������������װ��Emp������ȥ
		this.setCommandClass(Emp.class);
	}
	/**
	 * �Զ�������ת��������String->Date����(��ʽyyyy-MM-dd)
	 */
	@Override
	protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
		//��springmvc�ڲ�ע��һ���Զ��������ת����
		//����һ����Stringת��ʲô���͵��ֽ���
		//���������Զ���ת������
		//true��ʾ�������ֶο���Ϊ��
		binder.registerCustomEditor(
				Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
	}
	/**
	 * obj��ʾ��װ���ʵ��
	 * error��ʾ��װʱ�������쳣
	 */
	@Override
	protected ModelAndView handle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object obj, 
			BindException error)throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message","����Ա���ɹ�");
		
		Emp emp = (Emp) obj;
		System.out.println(emp.getUsername()+":"+emp.getGender()+":"+emp.getHiredate().toLocaleString());
		
		//��Emp��װ��ModeAndView������
		modelAndView.addObject("emp",emp);
		
		modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	}
}






