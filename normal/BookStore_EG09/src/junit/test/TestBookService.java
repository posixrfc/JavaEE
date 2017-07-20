package junit.test;

import org.junit.Test;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Page;
import com.atguigu.bookstore.service.BookService;
import com.atguigu.bookstore.service.impl.BookServiceImpl;

public class TestBookService {
	
	BookService bookService = new BookServiceImpl();

	@Test
	public void testFindBookByPrice() {
		
		Page<Book> page = bookService.findBookByPrice("1", "10", "30", "20");
		
		for(Book book : page.getData()){
			System.out.println(book);
		}
		
	}

}
