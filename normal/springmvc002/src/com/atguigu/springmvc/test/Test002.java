package com.atguigu.springmvc.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.springmvc.crud.dao.EmployeeDao;
import com.atguigu.springmvc.crud.entities.Employee;
import com.atguigu.springmvc.exception.MyUserLockException;

@Controller
public class Test002{
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	@RequestMapping(value={"/testInit"},method=RequestMethod.GET)
	public String testInit(){
		System.out.println("testInit=====get");
		return "ok";
	}
	
	@ResponseBody//结合jacksong的三个jar包，进行json串的处理
	@RequestMapping("/testJson")
	public Collection<Employee> qryAllEmployee(){
		return employeeDao.getAll();
	}
	
	@ResponseBody
	@RequestMapping("/testRequestBody")
	public String testRequestBody(@RequestBody String content){
		System.out.println("content----->:"+content);
		return "<font color = 'red' size = '7'>aaaaaaaaaaaaaaaaaaaaaaaaaaa</font>";
	}

	@RequestMapping("/testResponseEntity")
	public ResponseEntity<byte[]> testDownLoad()throws IOException{
		byte[] body = null;
		FileInputStream input = new FileInputStream(new File("C:\\Users\\Administrator\\Pictures\\2015-10-01_213809.jpg"));
		body = new byte[input.available()];
		input.read(body);
		input.close();
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition","attachment;filename=f.jpg");
		HttpStatus statusCode = HttpStatus.OK;
		ResponseEntity<byte[]> result = new ResponseEntity<byte[]>(body, headers, statusCode);
		return result;
	}
	
	@RequestMapping("/i18n")
	public String i18n(){
		System.out.println("i18n----->");
		return "ok";
	}
	
	@RequestMapping("/i18n2")
	public String i18n2(Locale locale){	
		System.out.println("i18n2----->");
		String v1 = messageSource.getMessage("i18n.username", null, locale);
		String v2 = messageSource.getMessage("i18n.password", null, locale);
		System.out.println("i18n2----->"+v1+"\t"+v2);
		return "ok";
	}	
	
	@RequestMapping("/i18n3")
	public String i18n3(){
		System.out.println("i18n3----->");
		return "ok";
	}
	
	@RequestMapping("/testUpload")	
	public String testUpload(@RequestParam("file") MultipartFile[] file) throws IllegalStateException, IOException{
		int i = 0;
		for (MultipartFile multipartFile : file)
			if(!multipartFile.isEmpty())
				multipartFile.transferTo(new File("D:\\44\\" + ++i + multipartFile.getOriginalFilename()));
		return "ok";
	}
	
	@RequestMapping("/testHandlerExceptionResolver")
	public String testHandlerExceptionResolver(@RequestParam("age") Integer age){
		@SuppressWarnings("unused")
		int result = 10/age;
		System.out.println("testHandlerExceptionResolver----->");
		return "ok";
	}
	
	@ExceptionHandler(value={ArithmeticException.class})
	public String dealHandlerExceptionResolver(Exception e,Map<String,Object> map){
		System.out.println("dealHandlerExceptionResolver----->   "+e);
		map.put("myException",e);
		return "error";
	}
	
	@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView dealHandlerExceptionResolver(Exception e){
		System.out.println("1111111111111");
		ModelAndView mv = new ModelAndView();
		mv.addObject("myException",e);
		mv.setViewName("error");
		return mv;
	}
	
	@ExceptionHandler(value={RuntimeException.class})
	public ModelAndView dealHandlerExceptionResolver2(Exception e){
		System.out.println("22222222");
		ModelAndView mv = new ModelAndView();
		mv.addObject("myException",e);
		mv.setViewName("error");
		return mv;
	}
	
	@RequestMapping("/testResponseStatusExceptionResolver")
	@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="测试......")
	public String testResponseStatusExceptionResolver(@RequestParam("userName") String userName){
		System.out.println("testResponseStatusExceptionResolver" + userName);
		if(userName.equalsIgnoreCase("li5"))
			throw new MyUserLockException();
		return "ok";
	}
	
	@RequestMapping("/testSimpleMappingExceptionResolver")
	public String testSimpleMappingExceptionResolver(@RequestParam("idx") Integer idx){
		int[] intArray = new int[10];
		System.out.println(intArray[idx]);
		return "ok";
	}
}