package com.atguigu.bookstore.servlet.client;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;
import com.atguigu.bookstore.servlet.BaseServlet;
import com.atguigu.bookstore.utils.WEBUtils;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理前端图书的Servlet
 * @author lilichao
 *
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	//创建一个BookService对象
	private BookService bookService = new BookServiceImpl();
	
	/**
	 * 根据价格查找图书
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findBookByPrice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//获取页码
		String pageNumber = request.getParameter("pageNumber");
		//指定pageSize
		String pageSize = "4";
		//获取最大和最小价格
		String max = request.getParameter("max");
		String min = request.getParameter("min");
		
		//调用Service查询page 
		Page<Book> page = bookService.findBookByPrice(pageNumber, pageSize, max, min);
		
		//设置path地址
		page.setPath(WEBUtils.getPath(request));
		
		//将page放入request域中
		request.setAttribute("page", page);
		
		//转发到index.jsp
		request.getRequestDispatcher("/pages/book/book_list.jsp").forward(request, response);
		
		
	}

	protected void findBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取页码
		String pageNumber = request.getParameter("pageNumber");
		//指定pageSize
		String pageSize = "4";
		//调用Service查询Page
		Page<Book> page = bookService.findBook(pageNumber, pageSize);
		//为page设置path属性
		page.setPath(WEBUtils.getPath(request));
		//将page对象放入到request域中
		request.setAttribute("page", page);
		
		
		//转发到index.jsp
		request.getRequestDispatcher("/pages/book/book_list.jsp").forward(request, response);
		
	}

}
