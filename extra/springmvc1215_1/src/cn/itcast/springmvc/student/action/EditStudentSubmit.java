package cn.itcast.springmvc.student.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import cn.itcast.springmvc.student.pojo.Student;

public class EditStudentSubmit extends AbstractCommandController {
	
	public EditStudentSubmit(){
		//设置命令对象
		this.setCommandClass(Student.class);
		
	}
	//command：命令对象，这里使用上边设置的Student
	//命令对象，通过形参传递
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		//调用service保存学生信息
		//...
		//这里仅测试将页面的参数提交到命令对象中
		Student student = (Student)command;
		System.out.println(student);
		//返回成功页面
		modelAndView.setViewName("success");
		return modelAndView;
	}
	
	//注册一个属性编辑器
	@Override
	protected void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		//将student类中的birthday属性进行日期转换，类型和birthday一致
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	
	
	

}
