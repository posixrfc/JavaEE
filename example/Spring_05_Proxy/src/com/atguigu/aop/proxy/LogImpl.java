package com.atguigu.aop.proxy;

import java.util.Date;

public class LogImpl implements MathCalculator{

	@Override
	public int add(int i, int j) {
		
		System.out.println("[日志][时间："+new Date().toLocaleString()+"][方法开始][方法名：add][实参："+i+","+j+"]");
		
		int result = i + j;
		
		System.out.println("-->方法内部打印：result="+result);
		
		System.out.println("[日志][时间："+new Date().toLocaleString()+"][方法结束][方法名：add][执行结果："+result+"]");
		
		return result;
	}

	@Override
	public int sub(int i, int j) {
		
		System.out.println("[日志][时间："+new Date().toLocaleString()+"][方法开始][方法名：sub][实参："+i+","+j+"]");
		
		int result = i - j;
		
		System.out.println("-->方法内部打印：result="+result);
		
		System.out.println("[日志][时间："+new Date().toLocaleString()+"][方法结束][方法名：sub][执行结果："+result+"]");
		
		return result;
	}

	@Override
	public int mul(int i, int j) {
		
		System.out.println("[日志][时间："+new Date().toLocaleString()+"][方法开始][方法名：mul][实参："+i+","+j+"]");
		
		int result = i * j;
		
		System.out.println("-->方法内部打印：result="+result);
		
		System.out.println("[日志][时间："+new Date().toLocaleString()+"][方法结束][方法名：mul][执行结果："+result+"]");
		
		return result;
	}

	@Override
	public int div(int i, int j) {
		
		System.out.println("[日志][时间："+new Date().toLocaleString()+"][方法开始][方法名：div][实参："+i+","+j+"]");
		
		int result = i / j;
		
		System.out.println("-->方法内部打印：result="+result);
		
		System.out.println("[日志][时间："+new Date().toLocaleString()+"][方法结束][方法名：div][执行结果："+result+"]");
		
		return result;
	}

}
