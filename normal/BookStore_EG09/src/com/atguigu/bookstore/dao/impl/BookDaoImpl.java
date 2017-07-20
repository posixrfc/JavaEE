package com.atguigu.bookstore.dao.impl;

import java.util.List;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.dao.BaseDao;
import com.atguigu.bookstore.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	@Override
	public List<Book> getBookList() {

		String sql = "SELECT id , title , author , price , sales , stock , img_path imgPath FROM bs_book";

		return this.getBeanList(sql);

	}

	@Override
	public Book getBookById(String bookId) {

		String sql = "SELECT id , title , author , price , sales , stock , img_path imgPath FROM bs_book WHERE id=?";

		return this.getBean(sql, bookId);
	}

	@Override
	public int saveBook(Book book) {

		String sql = "INSERT INTO bs_book (title , author , price , sales , stock , img_path) values(?,?,?,?,?,?)";

		return this.update(sql, book.getTitle(), book.getAuthor(),
				book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath());
	}

	@Override
	public int delBook(String bookId) {

		String sql = "DELETE FROM bs_book WHERE id=?";

		return this.update(sql, bookId);
	}

	@Override
	public int updateBook(Book book) {

		String sql = "UPDATE bs_book set title=? , author=? , price=? , sales=? , stock=? , img_path=? WHERE id=?";

		return this.update(sql, book.getTitle(), book.getAuthor(),
				book.getPrice(), book.getSales(), book.getStock(),
				book.getImgPath(), book.getId());
	}

	@Override
	public Page<Book> findBook(Page<Book> page) {

		// 设置总记录数
		String sql = "SELECT COUNT(*) FROM bs_book";
		// 查询总记录数
		long count = (long) this.getSingleValue(sql);
		// 设置总记录数
		page.setTotalRecord((int) count);
		// 去数据库中查询图书
		sql = "SELECT id , title , author , price , sales , stock , img_path imgPath FROM bs_book LIMIT ? , ?";
		List<Book> list = this.getBeanList(sql, page.getIndex(),
				page.getPageSize());
		// 将list设置进page
		page.setData(list);

		return page;
	}

	@Override
	public Page<Book> findBookByPrice(Page<Book> page, double min, double max) {
		// 设置总记录数
		String sql = "SELECT COUNT(*) FROM bs_book WHERE price>=? AND price<=?";
		// 查询总记录数
		long count = (long) this.getSingleValue(sql, min, max);
		// 设置总记录数
		page.setTotalRecord((int) count);

		// 去数据库中查询图书
		sql = "SELECT id , title , author , price , sales , stock , img_path imgPath FROM bs_book WHERE price>=? AND price<=? LIMIT ? , ?";
		List<Book> list = this.getBeanList(sql, min, max, page.getIndex(),
				page.getPageSize());
		// 将list设置进page
		page.setData(list);

		return page;
	}

	@Override
	public void batchUpdateSalesAndStock(Object[][] params) {
		String sql = "UPDATE bs_book set sales=? , stock=?  WHERE id=?";
		
		this.batchUpdate(sql, params);

		
	}

}
