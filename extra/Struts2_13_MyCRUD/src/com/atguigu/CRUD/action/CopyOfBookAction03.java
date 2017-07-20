package com.atguigu.CRUD.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.atguigu.CRUD.bean.Book;
import com.atguigu.CRUD.dao.Dao;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 问题二：在执行editUI.jsp时，栈顶有两个Book对象，对内存是一种浪费。
 * 问题分析：
 * 		1.表面原因：modelDriven拦截器压入了一个空的Book对象，然后editBook()方法又压入了一个从Dao中取出的Book对象
 * 		2.深层次原因
 * 			①saveBook()使用一个空的Book对象就能够满足需求
 * 			②editBook()必须压入一个从Dao中取出的对象才可以
 * 			③updateBook()方法根据不同情况有可能需要空对象，也有可能需要从Dao中取出的对象
 * 		3.所以需要将各个不同的Action方法区别对象，借助Struts2提供的prepare拦截器为每一个Action方法量身定做一个
 * 			准备模型对象的专有方法。
 * 		4.前提是prepare拦截器比modelDriven拦截器先执行。
 * 解决方案：
 * 		1.让当前BookAction实现Preparable接口
 * 		2.为每一个Action方法准备一个以prepare为前缀的方法
 * 			例如：saveBook()方法的前缀方法是：prepareSaveBook()
 * 		3.在Action方法各自的prepareXxx()方法中给this.book赋值
 * 			prepareSaveBook()：需要赋值一个空的Book对象
 * 			prepareEditBook()：需要赋值一个从Dao中取出的对象
 * 			prepareUpdateBook()：需要赋值一个空的Book对象
 * 		4.将getModel()方法中的赋值代码删除
 * 		5.editBook()方法中删除全部代码
 * 		6.此时对于deleteBook()方法来说，this.book从来都没有被赋值过，所以会抛空指针异常。
 * 		7.需要创建private Integer bookId;接收bookId请求参数，让deleteBook()方法直接使用成员变量bookId
 * 问题三：prepare拦截器执行时，需要注入请求参数，但默认拦截器栈中，params拦截器在prepare拦截器的后面。
 * 		所以需要在prepare拦截器执行之前执行一个params拦截器。
 * 解决方案：将当前使用的拦截器栈替换为paramsPrepareParamsStack
 * 		在struts.xml配置文件的package标签内加入：<default-interceptor-ref name="paramsPrepareParamsStack"/>
 * 
 * 最终总体上的工作原理[以editBook()方法为例]
 * 		1.按照paramsPrepareParamsStack栈中定义的顺序，首先通过params拦截器给BookAction类中的bookId属性注入请求参数的值
 * 		2.在经过prepare拦截器时，首先判断目标Action类是否实现了Preparable接口
 * 		3.如果实现了Preparable接口，则获取目标Action方法的方法名，即："editBook"
 * 		4.将"editBook"字符串改变成首字母大写："EditBook"
 * 		5.在"EditBook"字符串之前，加上"prepare"前缀，得到："prepareEditBook"字符串
 * 		6.以"prepareEditBook"字符串作为方法名，在BookAction类中查找对应的方法
 * 		7.如果能够找到，则调用这个prepareEditBook()方法
 * 		8.在prepareEditBook()方法中根据bookId的值查询Dao，返回一个Book对象，赋值给this.book
 * 		9.prepare拦截器的任务完成了
 * 		10.经过modelDriven拦截器时，将this.book对象压入栈顶
 * 		11.目标editBook()方法中什么都不做，Struts2直接执行对应的result
 * 		12.在执行editUI.jsp时，Struts2的表单标签自动根据栈顶的Book对象进行表单回显
 * 
 * 问题四：Preparable接口的prepare()没有实际作用，但是每次都执行，需要取消。
 * 解决方案：通过修改prepare拦截器参数实现。
 * 		修改拦截器参数的前提：拦截器类中有参数对应的setXxx()方法
    	<interceptors>
	    	<!-- 自定义一个拦截器栈 -->
    		<interceptor-stack name="atguiguStack">
    			<!-- 引用paramsPrepareParamsStack拦截器栈 -->
    			<interceptor-ref name="paramsPrepareParamsStack">
    				<!-- 修改拦截器栈中的prepare拦截器的参数 -->
    				<param name="prepare.alwaysInvokePrepare">false</param>
    			</interceptor-ref>
    		</interceptor-stack>
    	</interceptors>
    
    	<!-- 修改当前使用的拦截器栈为上面自定义的拦截器栈 -->
    	<default-interceptor-ref name="atguiguStack"/>
 * @author Creathin
 *
 */
public class CopyOfBookAction03 extends ActionSupport implements RequestAware, ModelDriven<Book>,Preparable{

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
		
		//1.将请求参数封装为Book对象
		//2.执行更新
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
		
		return this.book;
	}

	@Override
	public void prepare() throws Exception {
		System.out.println("prepare()...");
	}

}
