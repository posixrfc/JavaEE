package cn.itcast.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice2 {
	public void before(){
		System.out.println("before......");
	}
	public void after(){
		System.out.println("after......");
	}
	public void afterReturning(){
		System.out.println("afterReturning......");
	}
	public void afterThrowing(){
		System.out.println("afterThrowing......");
	}
	public void around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("around before......");
		pjp.proceed();
		System.out.println("around after......");
	}
}