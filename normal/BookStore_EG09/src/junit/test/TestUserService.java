package junit.test;

import org.junit.Test;

import com.atguigu.bookstore.bean.User;
import com.atguigu.bookstore.service.UserService;
import com.atguigu.bookstore.service.impl.UserServiceImpl;

public class TestUserService {
	
	UserService userService = new UserServiceImpl();

	@Test
	public void testRegist() {
		User user = new User(null, "sunwukong", "123123", "ad@163.com");
		
		boolean regist = userService.regist(user);
		
		System.out.println(regist);
	}
	
	@Test
	public void testLogin() {
		User user = new User(null, "sunwukong1", "123123", "ad@163.com");
		
		User u = userService.login(user);
		
		System.out.println(u);
	}

}
