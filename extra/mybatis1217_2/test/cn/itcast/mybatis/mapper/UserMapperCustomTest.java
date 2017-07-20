package cn.itcast.mybatis.mapper;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.QueryVo;
import cn.itcast.mybatis.po.User;

public class UserMapperCustomTest {
	// 会话工厂
	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setUp() throws Exception {
		// 加载配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据mytais的配置创建SqlSessionFactory

		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void testFindUserList() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		UserMapperCustom userMapperCustom = sqlSession
				.getMapper(UserMapperCustom.class);

		// 查询条件
		User user = new User();
		user.setUsername("张三");
		// user.setSex("1");
		// 包装对象
		QueryVo queryVo = new QueryVo();
		queryVo.setUser(user);
		List<User> list = userMapperCustom.findUserList(queryVo);

		System.out.println(list.size());

	}

	@Test
	public void testFindUserCount() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		UserMapperCustom userMapperCustom = sqlSession
				.getMapper(UserMapperCustom.class);

		// 查询条件
		User user = new User();
		user.setUsername("张三");
		user.setSex("1");

		// 构造一个数组
		int[] ids = new int[3];
		ids[0] = 10;
		ids[1] = 89;
		ids[2] = 16;
		// 包装对象
		QueryVo queryVo = new QueryVo();
		queryVo.setUser(user);
		queryVo.setIds(ids);
		int count = userMapperCustom.findUserCount(queryVo);

		System.out.println(count);

	}

	@Test
	public void testFindUserListResultMap() throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession();

		UserMapperCustom userMapperCustom = sqlSession
				.getMapper(UserMapperCustom.class);

		// 查询条件
		User user = new User();
		user.setUsername("张三");
		user.setSex("1");

		// 构造一个数组
		int[] ids = new int[3];
		ids[0] = 10;
		ids[1] = 89;
		ids[2] = 16;
		// 包装对象
		QueryVo queryVo = new QueryVo();
		queryVo.setUser(user);
		queryVo.setIds(ids);
		List<User> list = userMapperCustom.findUserListResultMap(queryVo);

		System.out.println(list.size());

	}

}
