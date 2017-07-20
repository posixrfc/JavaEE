package cn.itcast.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/user")
public class CommandAction {
	@RequestMapping("/test")
	public String test()throws Exception{
		return "success";
	}
	
}
