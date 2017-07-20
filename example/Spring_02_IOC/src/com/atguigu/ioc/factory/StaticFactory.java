package com.atguigu.ioc.factory;

import java.util.HashMap;
import java.util.Map;

import com.atguigu.ioc.bean.Book;

/**
 * 静态工厂：通过静态方法获取对象，工厂类本身不需要创建对象
 * @author Creathin
 *
 */
public class StaticFactory {
	
	private static Map<String, Book> bookMap;
	
	static {
		bookMap = new HashMap<String, Book>();
		bookMap.put("key01", new Book("bookName01", "author01", 100, "isbn01"));
		bookMap.put("key02", new Book("bookName02", "author02", 100, "isbn02"));
		bookMap.put("key03", new Book("bookName03", "author03", 100, "isbn03"));
	}
	
	public static Book getBook(String key) {
		return bookMap.get(key);
	}

}
