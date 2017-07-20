package com.atguigu.CRUD.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.CRUD.bean.Book;
import com.atguigu.CRUD.dao.Dao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CopyOfBookAction03 extends ActionSupport implements RequestAware,ModelDriven<Book> {

	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private Map<String, Object> requestMap;
	
	private Book book;
	
	public String update() {
		dao.updateBook(book);
		return "update-success";
	}
	
	public String editUI() {
		return "editUI";
	}
	
	public String remove() throws Exception {
		dao.removeBook(book.getBookId());
		return "remove-success";
	}

	public String save() {
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
	
	private Integer bookId;
	
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	@Override
	public Book getModel() {
		if(bookId == null) {
			this.book = new Book();
		}else{
			this.book = dao.getBook(bookId);
		}
		return this.book;
	}

}
