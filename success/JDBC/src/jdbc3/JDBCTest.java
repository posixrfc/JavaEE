package jdbc3;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCTest {
	
	@Test
	public void testJdbcTools() throws Exception{
		Connection connection = JDBCTools.getConnection();
		System.out.println(connection); 
	}

	@Test
	public void testC3poWithConfigFile() throws Exception{
		DataSource dataSource = new ComboPooledDataSource("helloc3p0p");
		System.out.println(dataSource.getConnection());
		ComboPooledDataSource comboPooledDataSource = (ComboPooledDataSource) dataSource;
		System.out.println(comboPooledDataSource.getMaxStatements()); 
	}
	
	@Test
	public void testC3P0() throws Exception{
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.jdbc.Driver" );         
		cpds.setJdbcUrl( "jdbc:mysql:///test" );
		cpds.setUser("root");                                  
		cpds.setPassword("123456");
		System.out.println(cpds.getConnection()); 
	}
	@Test
	public void testDBCPWithDataSourceFactory() throws Exception{
		Properties properties = new Properties();
		InputStream inStream = JDBCTest.class.getClassLoader().getResourceAsStream("dbcp.properties");
		properties.load(inStream);
		DataSource dataSource = BasicDataSourceFactory.createDataSource(properties);
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void testDBCP() throws SQLException{
		final BasicDataSource dataSource = new BasicDataSource();		
		dataSource.setUsername("root");
		dataSource.setPassword("123456");
		dataSource.setUrl("jdbc:mysql:///test");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setInitialSize(5);		
		dataSource.setMaxActive(5);		
		dataSource.setMinIdle(2);
		dataSource.setMaxWait(1000 * 5);
		
		Connection connection = dataSource.getConnection();
		System.out.println(connection.getClass()); 
		
		connection = dataSource.getConnection();
		System.out.println(connection.getClass()); 
		
		connection = dataSource.getConnection();
		System.out.println(connection.getClass()); 
		
		connection = dataSource.getConnection();
		System.out.println(connection.getClass()); 
		
		Connection connection2 = dataSource.getConnection();
		System.out.println(">" + connection2.getClass()); 
		
		new Thread(){
			public void run() {
				Connection conn;
				try {
					conn = dataSource.getConnection();
					System.out.println(conn.getClass()); 
				} catch (SQLException e) {
					e.printStackTrace();
				}
			};
		}.start();
		
		connection2.close();
	}
	@Test
	public void testBatch(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		try {
			connection = JDBCTools.getConnection();
			JDBCTools.beginTx(connection);
			sql = "INSERT INTO customers VALUES(?,?)";
			preparedStatement = connection.prepareStatement(sql);			
			long begin = System.currentTimeMillis();
			for(int i = 20; i < 100000; i++){
				preparedStatement.setInt(1, i + 1);
				preparedStatement.setString(2, "name_" + i);
				preparedStatement.addBatch();
				if((i + 1) % 300 == 0){
					preparedStatement.executeBatch();
					preparedStatement.clearBatch();
				}
			}
			if(100000 % 300 != 0){
				preparedStatement.executeBatch();
				preparedStatement.clearBatch();
			}
			long end = System.currentTimeMillis();
			System.out.println("Time: " + (end - begin)); //569
			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.rollback(connection);
		} finally{
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}
	@Test
	public void testBatchWithPreparedStatement(){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		try {
			connection = JDBCTools.getConnection();
			JDBCTools.beginTx(connection);
			sql = "INSERT INTO customers VALUES(?,?)";
			preparedStatement = connection.prepareStatement(sql);			
			long begin = System.currentTimeMillis();
			for(int i = 100100; i < 200100; i++){
				preparedStatement.setInt(1, i + 1);
				preparedStatement.setString(2, "name_" + i);
				preparedStatement.executeUpdate();
			}
			long end = System.currentTimeMillis();
			System.out.println("Time: " + (end - begin)); //9819
			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.rollback(connection);
		} finally{
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}
	@Test
	public void testBatchWithStatement(){
		Connection connection = null;
		Statement statement = null;
		String sql = null;
		try {
			connection = JDBCTools.getConnection();
			JDBCTools.beginTx(connection);
			statement = connection.createStatement();
			long begin = System.currentTimeMillis();
			for(int i = 0; i < 100000; i++){
				sql = "INSERT INTO customers VALUES(" + (i + 1) + ", 'name_" + i + "', '29-6月 -13')";
				statement.addBatch(sql);
			}
			long end = System.currentTimeMillis();
			System.out.println("Time: " + (end - begin)); //39567
			JDBCTools.commit(connection);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCTools.rollback(connection);
		} finally{
			JDBCTools.releaseDB(null, statement, connection);
		}
	}
}