package cn.itcast.springmvc.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.springmvc.pojo.Student;


/**
 * 
 * <p>Title: JsonAction</p>
 * <p>Description: json转换测试</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-15下午5:38:43
 * @version 1.0
 */
@Controller
public class JsonAction {
	
	//请求json响应json
	@RequestMapping("/requestJson")
	public @ResponseBody Student requestJson(@RequestBody Student student)throws Exception{
		
		System.out.println(student);
		return student;
	}
	
	
	//请求key/value响应json
	@RequestMapping("/responseJson")
	public @ResponseBody Student responseJson(Student student)throws Exception{
		
		System.out.println(student);
		return student;
	}

}
