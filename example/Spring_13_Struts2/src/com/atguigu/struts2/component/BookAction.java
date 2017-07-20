package com.atguigu.struts2.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope(value="prototype")
public class BookAction extends ActionSupport{
	
	public BookAction() {
		System.out.println("★★★★★★★BookAction 对象创建！");
	}
	
	@Autowired
	private BookService bookService;
	
	private String message;
	
	public String getMessage() {
		return this.message;
	}
	
	public String showMessage() {
		this.message = bookService.getMessage();
		return "success";
	}

}
