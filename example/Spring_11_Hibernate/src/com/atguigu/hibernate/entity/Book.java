package com.atguigu.hibernate.entity;

public class Book {
	
	private Integer bookId;
	private int stock;
	private int price;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Integer bookId, int stock, int price) {
		super();
		this.bookId = bookId;
		this.stock = stock;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", stock=" + stock + ", price="
				+ price + "]";
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
