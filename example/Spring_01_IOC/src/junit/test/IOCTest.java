package junit.test;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.ioc.bean.Book;
import com.atguigu.ioc.bean.BookShop;
import com.atguigu.ioc.component.BookService;

public class IOCTest {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
	
	@Test
	public void test14() {
		//实验14：给bean的级联属性赋值
		BookService bookService = ioc.getBean(BookService.class);
		String daoMsg = bookService.getBookDao().getDaoMsg();
		System.out.println(daoMsg);
	}
	
	@Test
	public void test13() {
		//实验13：通过util名称空间创建集合类型的bean
		List<String> list = (List<String>) ioc.getBean("myList");
		for (String string : list) {
			System.out.println(string);
		}
	}
	
	@Test
	public void test08() {
		//实验8：引用其他bean★
		//实验9：引用内部bean
		BookShop bookShop = ioc.getBean(BookShop.class);
		System.out.println(bookShop);
		
//		Book book = (Book) ioc.getBean("myInnerBook");
//		System.out.println(book);
		
		//实验10：使用List类型的集合属性
		List<Book> bookList = bookShop.getBookList();
		for (Book book : bookList) {
			System.out.println(book.getBookName());
		}
		
		//实验11：使用Map类型的集合属性
		Set<Entry<String, Book>> entrySet = bookShop.getBookMap().entrySet();
		for (Entry<String, Book> entry : entrySet) {
			System.out.println(entry);
		}
		
		//实验12：使用prop子元素为Properties类型的属性赋值
		Set<Entry<Object, Object>> propEntry = bookShop.getProp().entrySet();
		for (Entry<Object, Object> entry : propEntry) {
			System.out.println(entry);
		}
	}
	
	@Test
	public void test07() {
		//实验7：测试使用null值
		Book book = (Book) ioc.getBean("book07");
		System.out.println(book);
	}
	
	@Test
	public void test06() {
		//实验6：通过p名称空间为bean赋值
		Book book = (Book) ioc.getBean("book06");
		System.out.println(book);
	}
	
	@Test
	public void test05() {
		//实验5：通过类型不同区分重载的构造器
		Book book = (Book) ioc.getBean("book05");
		System.out.println(book);
	}
	
	@Test
	public void test04() {
		//实验4：通过index属性指定参数的位置
		Book book = (Book) ioc.getBean("book04");
		System.out.println(book);
	}
	
	@Test
	public void test03() {
		//实验3：通过构造器为bean的属性赋值
		Book book = (Book) ioc.getBean("book03");
		System.out.println(book);
	}
	
	@Test
	public void test02() {
		//实验2：根据bean的类型从IOC容器中获取bean的实例★
		Book book = ioc.getBean(Book.class);
		System.out.println(book);
	}

	@Test
	public void test01() {
		//实验1：通过IOC容器创建对象，并为属性赋值★
		//1.创建IOC容器对象
		ApplicationContext ioc = new ClassPathXmlApplicationContext("bean.xml");
		
		System.out.println("IOC容器对象创建好了");
		
		//2.从IOC容器中获取已经创建好的对象
		//默认情况下创建对象是在IOC容器创建和初始化过程中
		Book book = (Book) ioc.getBean("book");
		System.out.println(book);
	}

}
