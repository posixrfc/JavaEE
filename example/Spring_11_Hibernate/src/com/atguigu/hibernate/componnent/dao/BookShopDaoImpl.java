package com.atguigu.hibernate.componnent.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public int findPriceById(Integer bookId) {
		
		/*Session session = factory.openSession();
		Book book = (Book) session.get(Book.class, bookId);
		
		return book.getPrice();*/
		
		Session session = factory.getCurrentSession();
	
		String hql = "select b.price From Book b where b.bookId=?";
		Integer price = (Integer) session.createQuery(hql).setInteger(0, bookId).uniqueResult();
		
		return price;
	}

	@Override
	public void updateBookStock(Integer bookId) {
		
		Session session = factory.getCurrentSession();
		
		String hql = "UPDATE Book b set b.stock=b.stock-1 where b.bookId=?";
		
		session.createQuery(hql).setInteger(0, bookId).executeUpdate();
		
	}

	@Override
	public void updateUserBalance(Integer userId, int price) {
		String hql = "UPDATE User u set u.balance=u.balance-? where u.userId=?";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setInteger(0, price).setInteger(1, userId).executeUpdate();
	}

}
