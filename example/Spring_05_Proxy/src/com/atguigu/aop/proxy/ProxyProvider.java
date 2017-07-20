package com.atguigu.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Date;

/**
 * 用于创建目标对象的代理对象并返回
 * @author Creathin
 *
 */
public class ProxyProvider {
	
	//被代理的目标对象
	private MathCalculator target;
	
	//让外部程序将目标对象通过构造器传入
	public ProxyProvider(MathCalculator target) {
		super();
		this.target = target;
	}

	public MathCalculator getProxy() {
		
		if(target == null) {
			throw new RuntimeException("目标对象不给我传进来，你想干嘛？！");
		}
		
		//1.准备目标对象的类加载器
		//①获取目标对象的Class类对象
		Class targetClass = this.target.getClass();
		
		//②获取类加载器对象
		ClassLoader loader = targetClass.getClassLoader();
		
		//2.准备目标对象所实现的接口类型的数组
		Class[] interfaces = targetClass.getInterfaces();
		
		//3.准备InvocationHandler对象
		InvocationHandler h = new InvocationHandler() {
			
			/**
			 * 作用：供代理对象间接的调用目标对象的被代理的方法
			 */
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				
				//①获取目标方法的方法名
				String methodName = method.getName();
				
				//②执行目标对象的目标方法
				Object result = null;
				try {
					
					System.out.println("[日志@]"
							+ "[时间："+new Date().toLocaleString()+"]"
							+ "[方法开始]"
							+ "[方法名："+methodName+"]"
							+ "[实参："+Arrays.asList(args)+"]");
					
					//③打开目标方法的权限限制
					method.setAccessible(true);
					
					//④执行目标方法
					result = method.invoke(ProxyProvider.this.target, args);
					
					System.out.println("[日志@]"
							+ "[时间："+new Date().toLocaleString()+"]"
							+ "[方法正常结束]"
							+ "[方法名："+methodName+"]"
							+ "[执行结果："+result+"]");
					
				} catch (Exception e) {
					System.out.println("[日志@]"
							+ "[时间："+new Date().toLocaleString()+"]"
							+ "[方法抛出异常]"
							+ "[方法名："+methodName+"]"
							+ "[异常信息："+e.getMessage()+"]");
				} finally {
					
					System.out.println("[日志@]"
							+ "[时间："+new Date().toLocaleString()+"]"
							+ "[方法最终结束]"
							+ "[方法名："+methodName+"]");
					
				}
				
				return result;
			}
		};
		
		//4.创建代理对象
		MathCalculator calculator = (MathCalculator)Proxy.newProxyInstance(loader, interfaces, h);
		
		return calculator;
	}

}
