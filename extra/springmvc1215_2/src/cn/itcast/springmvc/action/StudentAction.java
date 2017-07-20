package cn.itcast.springmvc.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.itcast.springmvc.pojo.Student;
import cn.itcast.springmvc.pojo.UserVo;


/**
 * 
 * <p>
 * Title: StudentAction
 * </p>
 * <p>
 * Description: 注解开发学生信息管理
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2014-12-15下午2:46:00
 * @version 1.0
 */
@Controller
@RequestMapping("/stu")
public class StudentAction {
	

	//学生信息查询
	@RequestMapping("/querystudent")
	public String querystudent(
			Model model,
			@RequestParam(value = "groupid", required = true, defaultValue = "g001") String group,
			UserVo userVo) throws Exception {
	
		//System.out.println("group="+group);
		
		//将学生信息列表在页面上展示
		List<Student> list = new ArrayList<Student>();
		Student student = new Student();
		student.setId("s001");
		student.setName("张三");
		student.setAge(32);
		student.setBirthday(new Date());
		
		Student student2 = new Student();
		student2.setId("s002");
		student2.setName("李四");
		student2.setAge(32);
		student2.setBirthday(new Date());
		
		list.add(student);
		list.add(student2);
		
		model.addAttribute("list", list);
		
		return "student/querystudent";
		
	}
	
	//学生信息删除
	@RequestMapping("/deletestu")
	public String deletestu(String[] deleteid)throws Exception{
		
		System.out.println(deleteid.length);
		
		return "success";
	}
	
	
	// 修改学生信息页面
	// @RequestMapping指定url
	@RequestMapping(value="/editstudent/{id}",method = RequestMethod.GET)
	public String editstudent(HttpServletRequest request,Model model,@PathVariable String id) throws Exception {
		
		//System.out.println("request.getParameter..id="+request.getParameter("id"));
		
	
		System.out.println("id="+id);

		// 将学生信息的显示在页面
		// 使用静态数据
		Student student = new Student();
		student.setId("s001");
		student.setName("张三");
		student.setAge(32);
		student.setBirthday(new Date());
		// 需要将学生信息传到页面
		model.addAttribute("student", student);

		// 返回逻辑视图名
		return "student/editstudent";
	}

	// 学生信息修改提交
	@RequestMapping("/editstudentsubmit")
	public String editstudentsubmit(String id_,Student student,UserVo userVo)throws Exception{
		
		System.out.println(student);
		
		//重定向到学生信息列表页面
		//return "success";
		//请求重定向
		//return "redirect:querystudent.action";
		//页面转发
		return "forward:querystudent.action";
		
	}
	
	@InitBinder
	public void initBinder(HttpServletRequest request,
			ServletRequestDataBinder binder) throws Exception {
		//将student类中的birthday属性进行日期转换，类型和birthday一致
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}

}
