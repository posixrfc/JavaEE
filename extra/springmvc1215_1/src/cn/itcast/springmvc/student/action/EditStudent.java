package cn.itcast.springmvc.student.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import cn.itcast.springmvc.student.pojo.Student;

/**
 * 
 * <p>Title: EditStudent</p>
 * <p>Description: 学生信息修改页面</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-15上午11:11:02
 * @version 1.0
 */
public class EditStudent extends AbstractCommandController {
	

	public EditStudent(){
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
		
		
		//调用service获取学生的信息
		//...
		//使用静态数据
		Student student = new Student();
		student.setName("张三");
		student.setAge(32);
		student.setBirthday(new Date());
		//需要将学生信息传到页面
		
		modelAndView.addObject("student", student);
		
		//返回修改学生信息页面
		modelAndView.setViewName("student/editstudent");
		
		return modelAndView;
	}
	

}
