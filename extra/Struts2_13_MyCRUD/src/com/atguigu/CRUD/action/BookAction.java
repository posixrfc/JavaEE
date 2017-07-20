package com.atguigu.CRUD.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.CRUD.bean.Book;
import com.atguigu.CRUD.dao.Dao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class BookAction extends ActionSupport implements RequestAware, ModelDriven<Book>,Preparable{

	private static final long serialVersionUID = 1L;
	
	private Dao dao = new Dao();

	private Map<String, Object> reqMap;
	
	private Book book;
	private Integer bookId;
	
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	
	public void prepareUpdateBook() {
		this.book = new Book();
	}
	
	public String updateBook() {
		
		dao.updateBook(this.book);
		
		return "success";
	}
	
	public void prepareEditBook() {
		this.book = dao.getBook(this.bookId);
	}
	
	public String editBook() {
		
		return "success";
	}
	
	public String deleteBook() {
		
		dao.removeBook(this.bookId);
		
		return "success";
	}
	
	public void prepareSaveBook() {
		this.book = new Book();
	}

	public String saveBook() {
		
		dao.saveBook(this.book);
		
		return "success";
	}
	
	public String showList(){
		
		List<Book> bookList = dao.getBookList();
		
		reqMap.put("bookList", bookList);
		
		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.reqMap = arg0;
	}

	@Override
	public Book getModel() {
		return this.book;
	}

	@Override
	public void prepare() throws Exception {}

}
