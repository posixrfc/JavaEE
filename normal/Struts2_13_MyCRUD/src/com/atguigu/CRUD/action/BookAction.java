package com.atguigu.CRUD.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.CRUD.bean.Book;
import com.atguigu.CRUD.dao.Dao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

public class BookAction extends ActionSupport implements RequestAware{

	private static final long serialVersionUID = 1L;
	
	private Dao dao = new Dao();

	private Map<String, Object> reqMap;
	
	private Integer bookId;
	private String bookName;
	private String author;
	private Double price;
	
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
	
	public String updateBook() {
		
		//1.将请求参数封装为Book对象
		Book book = new Book(bookId, bookName, author, price);
		
		//2.执行更新
		dao.updateBook(book);
		
		return "success";
	}
	
	public String editBook() {
		
		//1.根据bookId的值查询Book对象
		Book book = dao.getBook(bookId);
		
		//2.借助值栈栈顶对象实现表单回显
		/*this.bookId = book.getBookId();
		this.bookName = book.getBookName();
		this.author = book.getAuthor();
		this.price = book.getPrice();*/
		//将book对象直接压入栈顶，进行回显
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(book);
		
		return "success";
	}
	
	public String deleteBook() {
		
		dao.removeBook(bookId);
		
		return "success";
	}

	public String saveBook() {
		
		//1.获取请求参数：通过setXxx()方法注入
		
		//2.将请求参数封装为Book对象
		Book book = new Book(bookId, bookName, author, price);
		
		//3.通过调用Dao对象的方法保存Book对象
		dao.saveBook(book);
		
		return "success";
	}
	
	public String showList(){
		
		//1.通过Dao对象获取集合数据
		List<Book> bookList = dao.getBookList();
		
		//2.将集合数据保存到请求域中
		reqMap.put("bookList", bookList);
		
		//3.转发到目标JSP页面上进行显示
		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.reqMap = arg0;
	}

}
