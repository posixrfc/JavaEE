package cn.itcast.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.springmvc.model.Person;
import cn.itcast.springmvc.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;
	
	@RequestMapping("/useraddsubmit")
	public String useraddsubmit(Person p){
		personService.save(p);
		return "success";
	}
	@RequestMapping("/useradd.action")
	public String useradd(){
		return "form";
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
