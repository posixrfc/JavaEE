package com.atguigu.ioc.factory;

import java.util.HashMap;
import java.util.Map;

import com.atguigu.ioc.bean.Book;

/**
 * 实例工厂：工厂类通过非静态方法获取对象，所以工厂类本身也要创建对象
 * @author Creathin
 *
 */
public class InstanceFactory {
	
	private Map<String, Book> bookMap;
	
	{
		bookMap = new HashMap<String, Book>();
		bookMap.put("key01", new Book("bookName01", "author01", 100, "isbn01"));
		bookMap.put("key02", new Book("bookName02", "author02", 100, "isbn02"));
		bookMap.put("key03", new Book("bookName03", "author03", 100, "isbn03"));
	}
	
	public Book getBook(String key) {
		return bookMap.get(key);
	}

}
