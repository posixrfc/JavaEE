package cn.itcast.mybatis.dao.impl;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.po.User;

public class UserDaoImplTest {

	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 加载配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据mytais的配置创建SqlSessionFactory

		sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

	}

	@Test
	public void testFindUserById() throws Exception {

		//构建dao对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);

		//调用 dao方法
		User user = userDao.findUserById(10);
		
		System.out.println(user);
	}

}
