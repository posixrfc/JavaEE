package com.atguigu.sort.bean;

import java.util.Comparator;

public class PriceComprator implements Comparator<Book>{

	@Override
	public int compare(Book book01, Book book02) {
		return (int)(book01.getPrice() - book02.getPrice());
	}

}
