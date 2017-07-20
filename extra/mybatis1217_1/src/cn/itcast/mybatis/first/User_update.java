package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.itcast.mybatis.po.User;

/**
 * 
 * <p>
 * Title: User_update
 * </p>
 * <p>
 * Description:用户更新
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 * 
 * @author 传智.燕青
 * @date 2014-12-17上午10:05:14
 * @version 1.0
 */
public class User_update {
	public static void main(String[] args) throws IOException {

		// 加载配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 根据mytais的配置创建SqlSessionFactory

		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		// 根据SqlSessionFactory创建SqlSession

		SqlSession sqlSession = sqlSessionFactory.openSession();

		// 更新用户
		// 输入参数
		User user = new User();
		user.setId(92);//更新的主键
		user.setUsername("老张");
		user.setBirthday(new Date());

		sqlSession.update("test.updateUser", user);

		// 提交 事务
		sqlSession.commit();

		// 关闭sqlSession

		sqlSession.close();

	}
}
