package com.atguigu.CRUD.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.CRUD.bean.Book;
import com.atguigu.CRUD.dao.Dao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

/**
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
 * 原理分析：
 * 		1.BookAction类的Action方法执行之前需要执行每一个拦截器
 * 		2.在经过modelDriven拦截器时，首先获取目标Action类对象
 * 		3.判断BookAction对象是否实现了ModelDriven接口
 * 		4.如果实现了接口，则调用BookAction类的getModel()方法
 * 		5.将getModel()方法的返回值压入栈顶
 * 		6.modelDriven拦截器执行完成后，后面还有params拦截器
 * 		7.params拦截器负责向栈顶的Book对象注入请求参数
 * 问题二：在执行editUI.jsp时，栈顶有两个Book对象，对内存是一种浪费。
 * @author Creathin
 *
 */
public class CopyOfBookAction02 extends ActionSupport implements RequestAware, ModelDriven<Book>{

	private static final long serialVersionUID = 1L;
	
	private Dao dao = new Dao();

	private Map<String, Object> reqMap;
	
	private Book book;
	
	public String updateBook() {
		
		//1.将请求参数封装为Book对象
		//2.执行更新
		dao.updateBook(this.book);
		
		return "success";
	}
	
	public String editBook() {
		
		//1.根据bookId的值查询Book对象
		Book book = dao.getBook(this.book.getBookId());
		
		//2.借助值栈栈顶对象实现表单回显
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		valueStack.push(book);
		
		return "success";
	}
	
	public String deleteBook() {
		
		dao.removeBook(this.book.getBookId());
		
		return "success";
	}

	public String saveBook() {
		
		//1.获取请求参数：通过setXxx()方法注入
		
		//2.将请求参数封装为Book对象
		
		//3.通过调用Dao对象的方法保存Book对象
		dao.saveBook(this.book);
		
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

	@Override
	public Book getModel() {
		
		this.book = new Book();
		
		return this.book;
	}

}
