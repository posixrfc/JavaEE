package com.atguigu.ioc.component;

public class BookService {
	
	private BookDao bookDao;

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
