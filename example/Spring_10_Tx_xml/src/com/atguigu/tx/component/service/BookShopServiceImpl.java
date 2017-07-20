package com.atguigu.tx.component.service;

import com.atguigu.tx.component.dao.BookShopDao;

public class BookShopServiceImpl implements BookShopService{

	private BookShopDao bookShopDao;
	
	public void setBookShopDao(BookShopDao bookShopDao) {
		this.bookShopDao = bookShopDao;
	}
	
	@Override
	public void purchase(String userName, String isbn) {
		
		//1.根据isbn查询书的价格
		int price = bookShopDao.findBookPriceByISBN(isbn);
		System.out.println("第一次读取：price="+price);
		
		//2.根据用户名和书的价格更新用户余额
		bookShopDao.updateBalanceByUserNamePrice(userName, price);
		
		//3.根据isbn更新书的库存
		bookShopDao.updateBookStockByISBN(isbn);
		
		price = bookShopDao.findBookPriceByISBN(isbn);
		System.out.println("第二次读取：price="+price);
		
//		String a = null;
//		System.out.println(a.length());
		
//		int i = 10 / 0;
//		System.out.println("i="+i);
	}

}
