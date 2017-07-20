package com.atguigu.sort.bean;

import java.util.Comparator;

public class BookNameComprator implements Comparator<Book>{

	@Override
	public int compare(Book book01, Book book02) {
		return book01.getBookName().compareTo(book02.getBookName());
	}

}
