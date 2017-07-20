package com.atguigu.bookstore.service.impl;

import java.util.List;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;
import com.atguigu.bookstore.service.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public List<Book> getBookList() {
		return bookDao.getBookList();
	}

	@Override
	public Book getBookById(String bookId) {
		return bookDao.getBookById(bookId);
	}

	@Override
	public int saveBook(Book book) {
		return bookDao.saveBook(book);
	}

	@Override
	public int delBook(String bookId) {
		return bookDao.delBook(bookId);
	}

	@Override
	public int updateBook(Book book) {
		return bookDao.updateBook(book);
	}

	@Override
	public Page<Book> findBook(String pageNumber, String pageSize) {
		
		//指定默认值
		int pn = 1;
		int pz = 4;
		//将页码和条数强转为int类型
		try {
			pz = Integer.parseInt(pageSize);
			pn = Integer.parseInt(pageNumber);
		} catch (NumberFormatException e) {
		}
		//创建一个Page对象
		Page<Book> page = new Page<Book>();
		page.setPageNumber(pn);
		page.setPageSize(pz);
		//调用DAO查询数据库
		return bookDao.findBook(page);
		
		
	}

	@Override
	public Page<Book> findBookByPrice(String pageNumber, String pageSize,
			String max, String min) {
		//对价格进行转型
		double minPrice = 0;
		double maxPrice = Double.MAX_VALUE;
		
		try {
			minPrice = Double.parseDouble(min);
			maxPrice = Double.parseDouble(max);
		} catch (NumberFormatException e1) {
		}
			
		
		//指定默认值
		int pn = 1;
		int pz = 4;
		//将页码和条数强转为int类型
		try {
			pz = Integer.parseInt(pageSize);
			pn = Integer.parseInt(pageNumber);
		} catch (NumberFormatException e) {
		}
		//创建一个Page对象
		Page<Book> page = new Page<Book>();
		page.setPageNumber(pn);
		page.setPageSize(pz);
		//调用DAO查询数据库
		return bookDao.findBookByPrice(page, minPrice, maxPrice);
	}

}
