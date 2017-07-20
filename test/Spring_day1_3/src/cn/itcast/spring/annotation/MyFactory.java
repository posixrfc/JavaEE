package cn.itcast.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class MyFactory {
	@Bean(name="bean4")
	public static Bean1 getBean(){
		return new Bean1();
	}
}
