package com.atguigu.bookstore.dao;

import java.util.List;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;

/**
 * 图书数据库操作的接口
 * @author lilichao
 *
 */
public interface BookDao {

	/**
	 * 获取所有图书
	 * @return
	 */
	List<Book> getBookList();
	
	/**
	 * 根据ID获取一本图书
	 * @param bookId
	 * @return
	 */
	Book getBookById(String bookId);
	
	/**
	 * 向数据库中保存一本图书
	 * @param book
	 * @return
	 */
	int saveBook(Book book);
	
	/**
	 * 删除一本图书
	 * @param bookId
	 * @return
	 */
	int delBook(String bookId);
	
	/**
	 * 更新一本图书
	 * @param book
	 * @return
	 */
	int updateBook(Book book);
	
	/**
	 * 分页查找图书的方法
	 * @param page
	 * @return
	 */
	Page<Book> findBook(Page<Book> page);
	
	/**
	 * 根据价格查找分页数据
	 * @param page
	 * @param min
	 * @param max
	 * @return
	 */
	Page<Book> findBookByPrice(Page<Book> page , double min , double max);
	
	/**
	 * 批量更新销量和库存
	 */
	void batchUpdateSalesAndStock(Object[][] params);
	
	
	
}
