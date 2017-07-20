package com.atguigu.CRUD.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.CRUD.bean.Book;
import com.atguigu.CRUD.dao.Dao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BookAction extends ActionSupport implements RequestAware,ModelDriven<Book>,Preparable {

	private static final long serialVersionUID = 1L;

	private Dao dao = new Dao();
	private Map<String, Object> requestMap;
	
	private Book book;
	
	public void prepareUpdate() {
		this.book = new Book();
	}
	
	public String update() {
		dao.updateBook(book);
		return "update-success";
	}
	
	public void prepareEditUI() {
		this.book = dao.getBook(bookId);
	}
	
	public String editUI() {
		return "editUI";
	}
	
	public String remove() throws Exception {
		dao.removeBook(bookId);
		return "remove-success";
	}
	
	public void prepareSave() {
		this.book = new Book();
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
		return this.book;
	}
	
	@Override
	public void prepare() throws Exception {
		System.out.println("prepare...");
	}

}
