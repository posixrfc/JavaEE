package com.atguigu.tx.component.service;

public interface BookShopService {
	
	//结账
	void purchase(String userName, String isbn);
	
	//为了测试事务传播行为：更新书的价格
	void updatePrice(String isbn, int price);

}
