package com.atguigu.sort.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ParameterAware;
import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.sort.bean.AuthorComprator;
import com.atguigu.sort.bean.Book;
import com.atguigu.sort.bean.BookNameComprator;
import com.atguigu.sort.bean.PriceComprator;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SortAction extends ActionSupport implements RequestAware,ParameterAware{

	private static final long serialVersionUID = 1L;
	
	private List<Book> bookList = null;
	
	public SortAction() {
		bookList = new ArrayList<>();
		bookList.add(new Book(1, "AAA", "ZZZ", 20.5));
		bookList.add(new Book(2, "BBB", "YYY", 70.3));
		bookList.add(new Book(3, "CCC", "XXX", 22));
		bookList.add(new Book(4, "DDD", "WWW", 58.5));
		bookList.add(new Book(5, "EEE", "VVV", 34.5));
	}
	
	@Override
	public String execute() throws Exception {
		
		BookNameComprator bc = new BookNameComprator();
		AuthorComprator ac = new AuthorComprator();
		PriceComprator pc = new PriceComprator();
		
		String condition = this.paramMap.get("condition")[0];
		if("bookName".equals(condition)) {
			requestMap.put("comprator", bc);
		}else if("author".equals(condition)) {
			requestMap.put("comprator", ac);
		}else if("price".equals(condition)){
			requestMap.put("comprator", pc);
		}
		
		ActionContext.getContext().getValueStack().push(bookList);
		System.out.println("abc...i am sort...");
		return SUCCESS;
	}
	
	private Map<String, Object> requestMap = null;

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}
	
	private Map<String, String[]> paramMap;

	@Override
	public void setParameters(Map<String, String[]> paramMap) {
		this.paramMap = paramMap;
	}
	
	public String testFormTag() {
		System.out.println("toForm...");
		return "toForm";
	}

}
