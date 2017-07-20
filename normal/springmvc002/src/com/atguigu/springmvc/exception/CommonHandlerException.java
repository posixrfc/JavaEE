package com.atguigu.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonHandlerException{
	
	@ExceptionHandler(value={ArithmeticException.class})
	public ModelAndView dealHandlerExceptionResolver(Exception e){
		System.out.println("33333333333333");
		ModelAndView mv = new ModelAndView();
		mv.addObject("myException",e);
		mv.setViewName("error");
		return mv;
	}
}