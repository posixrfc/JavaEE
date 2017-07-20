package junit.test;

import org.junit.Test;

import com.atguigu.aop.proxy.EasyImpl;
import com.atguigu.aop.proxy.LogImpl;
import com.atguigu.aop.proxy.MathCalculator;
import com.atguigu.aop.proxy.ProxyProvider;

public class ProxyTest {
	
	@Test
	public void testPoxyImpl() {
		
		//1.创建目标对象的实例
		EasyImpl target = new EasyImpl();
		
		//2.创建ProxyProvider的对象
		ProxyProvider provider = new ProxyProvider(target);
		
		//3.通过ProxyProvider对象获取Proxy对象
		MathCalculator calculator = provider.getProxy();
		
		//4.调用方法执行测试
		calculator.add(8, 2);
		calculator.sub(8, 2);
		calculator.mul(8, 2);
		calculator.div(8, 2);
		
	}
	
	@Test
	public void testLogImpl() {
		MathCalculator calculator = new LogImpl();
		calculator.add(8, 2);
		calculator.sub(8, 2);
		calculator.mul(8, 2);
		calculator.div(8, 2);
	}

	@Test
	public void testEasyImpl() {
		
		MathCalculator calculator = new EasyImpl();
		calculator.add(8, 2);
		calculator.sub(8, 2);
		calculator.mul(8, 2);
		calculator.div(8, 2);
		
	}

}
