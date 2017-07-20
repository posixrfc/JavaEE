package com.atguigu.ioc.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class BookShop {
	
	private Book specialBook;
	private Book innerBook;
	
	private List<Book> bookList;
	private Map<String, Book> bookMap;
	
	private Properties prop;
	
	public BookShop() {
		// TODO Auto-generated constructor stub
	}

	public BookShop(Book specialBook) {
		super();
		this.specialBook = specialBook;
	}

	@Override
	public String toString() {
		return "BookShop [specialBook=" + specialBook + ", innerBook="
				+ innerBook + "]";
	}

	public Book getSpecialBook() {
		return specialBook;
	}

	public void setSpecialBook(Book specialBook) {
		this.specialBook = specialBook;
	}

	public Book getInnerBook() {
		return innerBook;
	}

	public void setInnerBook(Book innerBook) {
		this.innerBook = innerBook;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	public Map<String, Book> getBookMap() {
		return bookMap;
	}

	public void setBookMap(Map<String, Book> bookMap) {
		this.bookMap = bookMap;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

}
