package cn.itcast.mybatis.dao.impl;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.itcast.mybatis.dao.UserDao;
import cn.itcast.mybatis.po.User;

/**
 * 
 * <p>
 * Title: UserDaoImpl
 * </p>
 * <p>
 * Description: 用户管理dao实现类
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2014-12-17下午2:49:04
 * @version 1.0
 */
public class UserDaoImpl implements UserDao {

	// 注入SqlSessionFactory
	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public User findUserById(int id) throws Exception {

		// 根据SqlSessionFactory创建SqlSession

		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过sqlSession查询用户信息(发起数据库操作)
		// 第一个参数statement：指定mapper映射文件中statement的id，指定 时需要前边加上statement所属的命名空间
		// 第二个参数parameter，指定 输入参数
		// selectOne返回的是单条记录，如果select返回多条记录(list集合)，使用selectOne会报错
		// 根据映射文件中的resultType指定输出类型
		User user = sqlSession.selectOne("test.findUserById", id);

		// 遍历查询结果
		// System.out.println(user);

		return user;
	}

	@Override
	public void insertUser(User user) throws Exception {
		// 根据SqlSessionFactory创建SqlSession

		SqlSession sqlSession = sqlSessionFactory.openSession();

		sqlSession.insert("test.insertUser", user);

		sqlSession.commit();

		sqlSession.close();

	}

	@Override
	public List<User> findUserList() throws Exception {
		// 根据SqlSessionFactory创建SqlSession

		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 通过sqlSession查询用户信息(发起数据库操作)
		// 第一个参数statement：指定mapper映射文件中statement的id，指定 时需要前边加上statement所属的命名空间
		// 第二个参数parameter，指定 输入参数
		// selectOne返回的是单条记录，如果select返回多条记录(list集合)，使用selectOne会报错
		// 根据映射文件中的resultType指定输出类型

		// 查询用户列表
		// selectList表示查询一个结果集（可以是一条或多条）
		List<User> list = sqlSession.selectList("test.findUserList", "张");

		System.out.println(list.size());
		return list;
	}

}
