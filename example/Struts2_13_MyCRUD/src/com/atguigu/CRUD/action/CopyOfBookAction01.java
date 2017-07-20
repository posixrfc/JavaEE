package com.atguigu.CRUD.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.CRUD.bean.Book;
import com.atguigu.CRUD.dao.Dao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * Struts2运行流程中的关键点
 * 	①Struts2在执行所有拦截器之前就会将目标Action对象压入栈顶。
 * 	②Struts2会在执行目标Action的目标方法之前逐一调用拦截器。
 * 	③每一个拦截器都负责一项具体的功能，例如：params拦截器负责将表单提交的请求参数注入到栈顶对象中。
 * 	④拦截器执行的顺序是由当前所使用的拦截器栈定义的。

 * 问题一：当前BookAction类与Book类相比较，存在大量冗余的代码。
 * 问题分析：
 * 		1.当前BookAction类包含Book类中的属性的目的是为了享受请求参数的注入
 * 		2.那既然只要有对应的setXxx()方法就能够享受请求参数的注入，那何不将Book对象压入栈顶享受注入
 * 		3.这里需要注意：请求参数的注入是由params拦截器执行的，那么将Book对象压入栈顶必须在params拦截器执行之前操作。
 * 		4.在默认拦截器栈中params拦截器之前有一个modelDriven拦截器可以实现上述需求。
 * 解决方案：
 * 		1.将冗余的代码删除
 * 		2.让当前BookAction类实现ModelDriven接口
 * 		3.给当前BookAction类创建private Book book;成员变量
 * 		4.在getModel()方法中为this.book赋值new Book();并将this.book返回
 * 		5.再将代码进行必要的调整
 * @author Creathin
 *
 */
public class CopyOfBookAction01 extends ActionSupport implements RequestAware{

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
