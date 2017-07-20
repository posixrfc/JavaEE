package junit.test;

import java.sql.Connection;

import org.junit.Test;

import com.atguigu.bookstore.utils.JDBCUtils;

public class TestJDBCUtils {

	@Test
	public void testConnection() {
		
		Connection connection = JDBCUtils.getConnection();
		
		System.out.println(connection);
		
		JDBCUtils.releaseConnection(connection);
		
	}

}
