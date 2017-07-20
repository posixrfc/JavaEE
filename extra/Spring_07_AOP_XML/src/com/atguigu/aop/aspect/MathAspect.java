package com.atguigu.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class MathAspect {
	
	public void whenMethodBegin(JoinPoint joinPoint) {
		
		//1.为当前通知方法设计JoinPoint类型的形参
		//方法签名：com.atguigu.aop.aspect.MathAspect.whenMethodBegin(JoinPoint)
		
		//2.通过JoinPoint对象获取封装方法签名的Signature对象
		Signature signature = joinPoint.getSignature();
		
		//3.通过Signature对象获取方法名
		String methodName = signature.getName();
		
		//4.通过JoinPoint对象获取方法执行时传入的实参
		Object[] args = joinPoint.getArgs();
		
		System.out.println("[AOP日志][方法开始][方法名："+methodName+"][实参："+Arrays.asList(args)+"]");
	}
	
	public void whenMethodReturn(Object myResult) {
		System.out.println("[AOP日志][方法返回][返回值："+myResult+"]");
	}
	
	public void whenMethodThrow(ArithmeticException myException) {
		System.out.println("[AOP日志][方法异常][异常信息："+myException.getClass().getName()+"]");
	}
	
	public void whenMethodEnd() {
		System.out.println("[AOP日志][方法结束]");
	}
	
	public Object whenMethodInvoke(ProceedingJoinPoint joinPoint) {
		
		Object result = null;
		
		//获取方法名
		String methodName = joinPoint.getSignature().getName();
		
		//获取实参
		Object[] args = joinPoint.getArgs();
		
		try {
			
			//方法执行之前所做的操作，作用相当于前置通知
			System.out.println("[环绕●日志][方法开始][方法名："+methodName+"][实参："+Arrays.asList(args)+"]");
			
			//执行目标方法
			result = joinPoint.proceed();
			
			//方法正常结束候所做的操作，作用相当于返回通知
			System.out.println("[环绕●日志][方法返回][返回值："+result+"]");
			
		} catch (Throwable e) {
			//方法捕获到异常时所做的操作，作用相当于异常通知
			System.out.println("[环绕●日志][方法异常][异常信息："+e.getClass().getName()+"]");
		} finally {
			
			//在方法最终结束时所做的操作，作用相当于后置通知
			System.out.println("[环绕●日志][方法结束]");
			
		}
		
		//一般来说，需要将目标方法的返回值返回，否则外部方法将得不到目标方法执行的结果
		return result;
		
	}

}
