package com.atguigu.tx.component.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements BookShopDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int findBookPriceByISBN(String isbn) {
		
		String sql = "SELECT price FROM book WHERE isbn=?";
		
		Integer price = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
		
		return price;
	}

	@Override
	public void updateBookStockByISBN(String isbn) {
		String sql = "UPDATE book_stock SET stock=stock-1 WHERE isbn=?";
		jdbcTemplate.update(sql, isbn);
	}

	@Override
	public void updateBalanceByUserNamePrice(String userName, int price) {
		String sql = "UPDATE account SET balance=balance-? WHERE username=?";
		jdbcTemplate.update(sql, price, userName);
	}

	@Override
	public void updatePrice(String isbn, int price) {
		String sql = "UPDATE book SET price=? WHERE isbn=?";
		jdbcTemplate.update(sql,price, isbn);
	}

}
