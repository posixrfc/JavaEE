package junit.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.dao.BookDao;
import com.atguigu.bookstore.dao.impl.BookDaoImpl;

public class TestBookDao {

	BookDao bookDao = new BookDaoImpl();
	
	@Test
	public void testFindBookByPrice(){
		Page<Book> page = new Page<Book>();
		//设置页码
		page.setPageNumber(1);
		//设置pageSize
		page.setPageSize(10);
		
		Page<Book> pg = bookDao.findBookByPrice(page, 30, 35);
		
		for(Book book : pg.getData()){
			System.out.println(book);
		}
	}
	
	@Test
	public void testFindBook(){
		
		Page<Book> page = new Page<Book>();
		//设置页码
		page.setPageNumber(2);
		//设置pageSize
		page.setPageSize(3);
		
		Page<Book> pg = bookDao.findBook(page);
		
		List<Book> list = pg.getData();
		
		//遍历list
		for (Book book : list) {
			System.out.println(book);
		}
		
	}
	
	@Test
	public void testGetBookList() {
		
		List<Book> bookList = bookDao.getBookList();
		
		System.out.println(bookList);
		
	}

	@Test
	public void testGetBookById() {
		
		Book book = bookDao.getBookById("1");
		System.out.println(book);
		
	}

	@Test
	public void testSaveBook() {
		Book book = new Book(null, "三国演义", "罗贯中", 20, 100, 50, "/static/img/default.jpg");
		int count = bookDao.saveBook(book);
		
		System.out.println(count);
	}

	@Test
	public void testDelBook() {
		int count = bookDao.delBook("1");
		
		System.out.println(count);
	}

	@Test
	public void testUpdateBook() {
		
		Book book = new Book(1, "三国演义2", "罗贯中", 20, 100, 50, "/static/img/default.jpg");
		
		int count = bookDao.updateBook(book);
		
		System.out.println(count);

	}

}
