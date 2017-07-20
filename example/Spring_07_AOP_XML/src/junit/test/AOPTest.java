package junit.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.aop.bean.MathCalculator;

public class AOPTest {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("aop.xml");

	@Test
	public void testAOP01() {
		//测试：AOP初步配置使用
		//1.从IOC容器中获取代理对象
		MathCalculator calculator = ioc.getBean(MathCalculator.class);
		
		//2.测试代理对象方法
		calculator.add(8, 2);
		
		System.out.println();
		
		calculator.sub(8, 2);
		
		System.out.println();
		
		calculator.mul(8, 2);
		
		System.out.println();
		
		calculator.div(8, 2);
		
		System.out.println();
		
		calculator.add(5.0, 2.0, 5.0);
		
		System.out.println();
		
		calculator.sub(10, 5, 3);
		
	}

}
