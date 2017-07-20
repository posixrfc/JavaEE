package com.atguigu.sort.bean;

public class Book {

	private Integer bookId;
	private String bookName;
	private String author;
	private double price;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Integer bookId, String bookName, String author, double price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName
				+ ", author=" + author + ", price=" + price + "]";
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
