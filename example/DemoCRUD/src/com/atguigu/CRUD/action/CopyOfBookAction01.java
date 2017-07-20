package com.atguigu.CRUD.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.CRUD.bean.Book;
import com.atguigu.CRUD.dao.Dao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CopyOfBookAction01 extends ActionSupport implements RequestAware {

	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private Map<String, Object> requestMap;

	private Integer bookId;
	private String bookName;
	private String author;
	private Double price;
	
	public String update() {
		Book book = new Book(bookId, bookName, author, price);
		dao.updateBook(book);
		return "update-success";
	}
	
	public String editUI() {
		Book book = dao.getBook(bookId);
		ActionContext.getContext().getValueStack().push(book);
		return "editUI";
	}
	
	public String remove() throws Exception {
		dao.removeBook(bookId);
		return "remove-success";
	}

	public String save() {
		Book book = new Book(bookId, bookName, author, price);
		dao.saveBook(book);
		return "save-success";
	}

	public String showList() throws Exception {
		requestMap.put("bookList", dao.getBookList());
		return "showList";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.requestMap = request;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
