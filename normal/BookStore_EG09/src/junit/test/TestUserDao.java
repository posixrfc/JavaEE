package junit.test;

import org.junit.Test;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.dao.UserDao;
import com.atguigu.bookstore.dao.impl.UserDaoImpl;

public class TestUserDao {

	UserDao ud = new UserDaoImpl();
	
	@Test
	public void testSavUser() {
		
		User user = new User(null, "admin", "123123", "ad@163.com");
		
		int count = ud.saveUser(user);
		
		System.out.println(count);
		
	}
	
	@Test
	public void testGetUser(){
		User user = new User(null, "admin", "123123", "ad@163.com");
		
		User u = ud.getUserByUserNameAndPassword(user);
		
		System.out.println(u);
	}

}
