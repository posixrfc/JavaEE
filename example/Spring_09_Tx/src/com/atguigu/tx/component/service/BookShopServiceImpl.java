package com.atguigu.tx.component.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.tx.component.dao.BookShopDao;

@Service
public class BookShopServiceImpl implements BookShopService{

	@Autowired
	private BookShopDao bookShopDao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,
				isolation=Isolation.READ_COMMITTED,
				readOnly=false,
				rollbackFor=NullPointerException.class,
				noRollbackFor=ArithmeticException.class,
				timeout=3)
	public void purchase(String userName, String isbn) {
		
		/*try {
			//为了测试事务的超时时间，让当前线程sleep5秒
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
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

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void updatePrice(String isbn, int price) {
		bookShopDao.updatePrice(isbn,price);
	}

}
