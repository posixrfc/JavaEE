package cn.itcast.spring.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.spring.annotation.Bean1;

//设置当前类的JUnit测试的类运行器由Spring提供
@RunWith(SpringJUnit4ClassRunner.class)
//设置加载的配置文件
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class JUnitSpringTestApp {
	//Junit测试必须使用
	@Autowired
	@Qualifier("bean1")
	private Bean1 bean;
	@Test
	public void fn(){
		bean.fn();
	}
}
