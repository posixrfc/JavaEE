package com.atguigu.bookstore.service;

import java.util.List;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;

/**
 * 
 * 处理图书相关逻辑的Service
 * @author lilichao
 *
 */
public interface BookService {
	
	/**
	 * 获取图书的列表
	 * @return
	 */
	List<Book> getBookList();
	
	/**
	 * 根据ID查询图书
	 * @param bookId
	 * @return
	 */
	Book getBookById(String bookId);
	
	/**
	 * 保存图书
	 * @param book
	 * @return
	 */
	int saveBook(Book book);
	
	/**
	 * 删除图书
	 * @param book
	 * @return
	 */
	int delBook(String bookId);
	
	/**
	 * 更新图书
	 * @param book
	 * @return
	 */
	int updateBook(Book book);
	
	/**
	 * 分页查找图书
	 * @return
	 */
	Page<Book> findBook(String pageNumber , String pageSize);
	
	
	/**
	 * 根据价格分页查找图书
	 * @return
	 */
	Page<Book> findBookByPrice(String pageNumber , String pageSize , String max , String min);
	
	

}
