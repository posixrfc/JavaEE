package com.atguigu.tag.comparator;

import java.util.Comparator;

import com.atguigu.tag.bean.Book;

public class BookComparator implements Comparator<Book>{

	@Override
	public int compare(Book o1, Book o2) {
		return o1.getBookName().compareTo(o2.getBookName());
	}

}
