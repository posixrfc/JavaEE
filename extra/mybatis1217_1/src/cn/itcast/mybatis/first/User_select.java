package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.itcast.mybatis.po.User;

/**
 * 
 * <p>Title: User_select</p>
 * <p>Description:用户查询 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-17上午10:05:14
 * @version 1.0
 */
public class User_select {
	public static void main(String[] args) throws IOException {
		
		//加载配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream  = Resources.getResourceAsStream(resource);
		
		//根据mytais的配置创建SqlSessionFactory
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		//根据SqlSessionFactory创建SqlSession
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//通过sqlSession查询用户信息(发起数据库操作)
		//第一个参数statement：指定mapper映射文件中statement的id，指定 时需要前边加上statement所属的命名空间
		//第二个参数parameter，指定 输入参数
		//selectOne返回的是单条记录，如果select返回多条记录(list集合)，使用selectOne会报错
		//根据映射文件中的resultType指定输出类型
		User user = sqlSession.selectOne("test.findUserById", 10);
		
		//遍历查询结果
		System.out.println(user);
		
		//查询用户列表
		//selectList表示查询一个结果集（可以是一条或多条）
		List<User> list = sqlSession.selectList("test.findUserList", "张");
		
		System.out.println(list.size());
		
		//关闭sqlSession
		
		sqlSession.close();
		
	}
}
