package com.atguigu.ioc.component.base;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {
	
	//将自动装配的代码提取到父类中
	//1.遇到@Autowired注解Spring就知道需要进行自动装配
	//2.首先检测当前需要自动装配的属性的类型：BaseRepository
	//3.进一步发现BaseRepository有两个子类：BookDao和OrderDao
	//4.为了在两个类型匹配的bean中确定要装配的bean，需要检测当前需要装配的属性的泛型类型
	//5.对于BookService，泛型类型是Book，而OrderService泛型类型是Order
	//6.所以可以根据子类继承父类时传入的一致的泛型类型进行装配
	@Autowired
	private BaseRepository<T> repository;
	
	public void save() {
		repository.save();
	}

}
