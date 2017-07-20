package com.atguigu.tx.component.dao;

public interface BookShopDao {
	
	//根据ISBN的值查询书的价格
	int findBookPriceByISBN(String isbn);
	
	//根据ISBN的值减少书的库存
	void updateBookStockByISBN(String isbn);
	
	//根据书的价格和用户名减少用户账户余额
	void updateBalanceByUserNamePrice(String userName, int price);

	//更新书的价格
	void updatePrice(String isbn, int price);

}
