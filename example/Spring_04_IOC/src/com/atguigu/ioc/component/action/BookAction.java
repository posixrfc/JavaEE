package com.atguigu.ioc.component.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope(value="prototype")
public class BookAction {
	
	public BookAction() {
		System.out.println("BookAction对象创建了！");
	}

}
