package cn.itcast.emp.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import cn.itcast.emp.entity.Emp;
import cn.itcast.emp.service.EmpService;

@SuppressWarnings("deprecation")
public class EmpAction extends AbstractCommandController{
	//ҵ���
	private EmpService empService;
	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	//����������װ��Empʵ����
	public EmpAction(){
		this.setCommandClass(Emp.class);
	}
	//�Զ���String->Date��ת����
	@Override
	protected void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(
				Date.class, 
				new CustomDateEditor(new SimpleDateFormat("dd-MM-yy"),true));
	}
	@Override
	protected ModelAndView handle(
			HttpServletRequest request,
			HttpServletResponse response, 
			Object obj, 
			BindException error)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		Emp emp = (Emp) obj;
		System.out.println(emp.getHiredate().toLocaleString());
		empService.register(emp);
		
		modelAndView.addObject("message","�����ɹ�");
		modelAndView.setViewName("success");
		return modelAndView;
	}
}





