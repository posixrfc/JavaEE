package junit.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.bookstore.bean.Book;
import com.atguigu.bookstore.bean.Cart;
import com.atguigu.bookstore.bean.CartItem;

public class TestCart {

	@Test
	public void testCart() {
		
		Book book1 = new Book(1, "hello1", "a", 1, 1, 1, "");
		Book book2 = new Book(2, "hello2", "a", 1, 1, 1, "");
		Book book3 = new Book(3, "hello3", "a", 0.01, 1, 1, "");
		Book book4 = new Book(4, "hello4", "a", 0.05, 1, 1, "");
		
		Cart cart = new Cart();
		
		//向购物车中添加图书
	/*	cart.addBook2Cart(book1);
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book1);
		cart.addBook2Cart(book2);*/
		
		cart.addBook2Cart(book3);
		cart.addBook2Cart(book4);
		
		//删除Hello2
		//cart.delCartItem("2");
		
		//输出购物车的信息
		List<CartItem> cartItems = cart.getCartItems();
		for (CartItem cartItem : cartItems) {
			System.out.println(cartItem.getBook());
		}
		
		//输出图书的数量
		System.out.println(cart.getTotalCount());
		//图书的总价
		System.out.println(cart.getTotalAmount());
		
		
	}

}
