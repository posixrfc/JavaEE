package com.atguigu.hibernate.componnent.dao;

public interface BookShopDao {
	
	int findPriceById(Integer bookId);
	
	void updateBookStock(Integer bookId);

	void updateUserBalance(Integer userId, int price);
}
