package cn.itcast.spring.annotation;

import org.springframework.stereotype.Service;

@Service("bean2")
public class Bean2 {
	public void fn(){
		System.out.println("bean2....");
	}
}
