package com.atguigu.bookstore.bean;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 封装购物项的类
 * @author lilichao
 *
 */
public class CartItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 表示要购买的图书的信息
	 */
	private Book book;
	
	/**
	 * 要购买图书的数量
	 */
	private int count;
	
	/**
	 * 要购买图书小计金额
	 */
	//private double amount;

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getAmount() {
		
		BigDecimal price = new BigDecimal(book.getPrice()+"");
		BigDecimal count = new BigDecimal(getCount()+"");
		
		return price.multiply(count).doubleValue();
	}

	public CartItem() {
	}
	
	

}
