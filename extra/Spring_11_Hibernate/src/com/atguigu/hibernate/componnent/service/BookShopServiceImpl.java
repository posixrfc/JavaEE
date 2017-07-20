package com.atguigu.hibernate.componnent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.hibernate.componnent.dao.BookShopDao;

@Service
public class BookShopServiceImpl implements BookShopService{

	@Autowired
	private BookShopDao bookShopDao;
	
	@Transactional
	public void purchase(Integer bookId, Integer userId) {
		
		int price = bookShopDao.findPriceById(bookId);
		
		bookShopDao.updateBookStock(bookId);
		
		bookShopDao.updateUserBalance(userId, price);
		
	}

}
