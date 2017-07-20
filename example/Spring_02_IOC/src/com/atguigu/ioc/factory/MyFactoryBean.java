package com.atguigu.ioc.factory;

import org.springframework.beans.factory.FactoryBean;

import com.atguigu.ioc.bean.Book;

public class MyFactoryBean implements FactoryBean<Book>{
	
	private String propertyParam;

	@Override
	public Book getObject() throws Exception {
		
		Book book = new Book(propertyParam, "author", 100, "isbn");
		
		return book;
	}

	@Override
	public Class<?> getObjectType() {
		return Book.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public String getPropertyParam() {
		return propertyParam;
	}

	public void setPropertyParam(String propertyParam) {
		this.propertyParam = propertyParam;
	}

}
