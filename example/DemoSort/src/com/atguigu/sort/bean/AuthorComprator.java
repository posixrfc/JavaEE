package com.atguigu.sort.bean;

import java.util.Comparator;

public class AuthorComprator implements Comparator<Book>{

	@Override
	public int compare(Book book01, Book book02) {
		return book01.getAuthor().compareTo(book02.getAuthor());
	}

}
