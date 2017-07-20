package com.atguigu.ioc.bean;

public class Book {
	
	private String bookName;
	private String author;
	private double price;
	private String isbn;
	
	public Book() {
		System.out.println("Book对象创建了，欢迎大家光临小罗的新书发布会！");
	}

	public Book(String bookName, String author, double price, String isbn) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
	}
	
	public Book(String bookName, String author, String isbn, double price) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", author=" + author + ", price="
				+ price + ", isbn=" + isbn + "]";
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

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
