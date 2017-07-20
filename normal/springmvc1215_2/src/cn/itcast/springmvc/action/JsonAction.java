package cn.itcast.springmvc.action;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.itcast.springmvc.pojo.Student;

@Controller
public class JsonAction {

	@RequestMapping("/requestJson")
	public @ResponseBody Student requestJson(@RequestBody Student student)throws Exception{
		System.out.println(student);
		return student;
	}

	@RequestMapping("/responseJson")
	public @ResponseBody Student responseJson(Student student)throws Exception{
		System.out.println(student);
		return student;
	}
}