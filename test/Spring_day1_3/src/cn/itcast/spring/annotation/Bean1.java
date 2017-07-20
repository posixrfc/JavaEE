package cn.itcast.spring.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("bean1")
@Scope("prototype")
public class Bean1 {
	@Autowired
	@Value("haha")
	private String name;
	
	@Autowired
	@Qualifier("bean2")
	private Bean2 bean2;
	
	@Resource(name="bean3")
	private Bean3 bean3;
	
	@PostConstruct 
	public void init(){
		System.out.println("嘿嘿.....");
	}
	
	
	public void fn(){
		bean2.fn();
		bean3.fn();
		System.out.println("bean1...."+name);
	}
}
