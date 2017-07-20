package com.atguigu.helloworld.bean;

import com.opensymphony.xwork2.ActionSupport;

public class Book extends ActionSupport{

	private Integer bookId;
	private String bookName;
	private String author;
	private double price;
	
	public String update() throws Exception {
		
		return SUCCESS;
	}
	
	public String save() {
		System.out.println("我是save()方法，我被Struts2调用了！");
		return "saveSuccess";
	}

	public Book() {
		System.out.println("BookAction对象创建了！");
	}

	public Book(Integer bookId, String bookName, String author, double price) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(double price) {
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

	public String getBookName() {
		return bookName;
	}

	public String getAuthor() {
		return author;
	}

	public double getPrice() {
		return price;
	}
	
}
