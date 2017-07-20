package com.atguigu.bookstore.servlet.manager;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;
import com.atguigu.bookstore.servlet.BaseServlet;
import com.atguigu.bookstore.utils.WEBUtils;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理端操作图书的Servlet
 */
public class BookManagerServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();

	/**
	 * 分页查询数据的方法
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void findPage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		//获取当前的页码
		String pageNumber = request.getParameter("pageNumber");
		String pageSize = "4";
		
		//调用service查询分页
		Page<Book> page = bookService.findBook(pageNumber, pageSize);
		
		//将path设置进Page
		page.setPath(WEBUtils.getPath(request));
		
		//将分页信息放到request域中
		request.setAttribute("page", page);
		
		//将请求转发到book_manager.jsp，然后在页面中显示列表
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
		
		
	}

	/**
	 * 添加图书
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void updateBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取要添加的图书信息
		Book book = WEBUtils.param2Bean(request, new Book());

		//获取地址信息
		String path = request.getParameter("referer");
		
		// 如果book的id为null，就是添加，否则是修改
		if (book.getId() != null) {
			
			bookService.updateBook(book);
			
		} else {
			// 调用Service将图书存储到数据库当中
			bookService.saveBook(book);
			
		}

		// 将页面重定向到图书列表页面
		response.sendRedirect(path);
		// bookList(request, response);

	}

	/**
	 * 显示图书列表
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void bookList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取所有的图书
		List<Book> bookList = bookService.getBookList();
		// 将bookList放入request域中
		request.setAttribute("list", bookList);
		// 将请求转发到book_manager.jsp，然后在页面中显示列表
		request.getRequestDispatcher("/pages/manager/book_manager.jsp")
				.forward(request, response);

	}

	/**
	 * 删除图书
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delBook(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取要删除图书的id
		String bookId = request.getParameter("bookId");
		// 调用service删除图书
		bookService.delBook(bookId);
		
		//获取referer头信息
		String path = request.getHeader("referer");
		
		// 将页面重定向到图书列表页面
		response.sendRedirect(path);

	}

	/**
	 * 前往图书的修改页面
	 */
	protected void toUpdatePage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 获取要修改的图书的ID
		String bookId = request.getParameter("bookId");
		// 根据id查询图书
		Book book = bookService.getBookById(bookId);
		// 将book放入到request域中
		request.setAttribute("book", book);
		// 转发到book_edit.jsp
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(
				request, response);

	}

}
