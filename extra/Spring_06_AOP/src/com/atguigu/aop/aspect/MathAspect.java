package com.atguigu.aop.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(37)
public class MathAspect {
	
	//统一声明切入点表达式
	@Pointcut(value="execution(* *.*(int, int))")
	public void pointCutDecrition() {}
	
	//@Before(value="execution(* *.*(..))")
	//引用统一声明的切入点表达式
	@Before(value="pointCutDecrition()")
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
	
	//1.在注解中使用returning属性指定形参名字
	@AfterReturning(value="pointCutDecrition()",returning="myResult")
	//2.使用指定名称的形参接收返回值
	public void whenMethodReturn(Object myResult) {
		System.out.println("[AOP日志][方法返回][返回值："+myResult+"]");
	}
	
	//1.在注解中使用throwing属性执行形参名字
	@AfterThrowing(value="pointCutDecrition()",throwing="myException")
	//2.声明指定名称的形参，接收捕获到的异常对象
	//3.可以通过形参类型指定当前异常通知针对什么样的异常来执行
	public void whenMethodThrow(NullPointerException myException) {
		System.out.println("[AOP日志][方法异常][异常信息："+myException.getClass().getName()+"]");
	}
	
	@After(value="pointCutDecrition()")
	public void whenMethodEnd() {
		System.out.println("[AOP日志][方法结束]");
	}
	
	@Around(value="pointCutDecrition()")
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
