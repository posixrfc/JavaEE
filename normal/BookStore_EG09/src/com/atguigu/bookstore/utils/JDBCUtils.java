package com.atguigu.bookstore.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 获取和释放数据库连接的工具类
 * 
 * @author lilichao
 * 
 */
public class JDBCUtils {

	// 获取数据源
	private static DataSource dataSource = new ComboPooledDataSource(
			"webDataSource");

	// 定义Connection属性
	// 这种方式会项目中所有的线程都会共享一个connection，非常的不靠谱
	// 我们希望一个线程可以对应着一个Connection
	// private static Connection connection = null;

	// 第二种方式，将数据库连接保存到一个map中
	// private static Map<Thread, Connection> map = new HashMap<Thread,
	// Connection>();

	// 第三种方式，使用ThreadLocal类,这个类的泛型，指定的是要保存对象的类型
	// threadLocal通过get()方法获取对象
	// 通过set()方法存储对象
	// 通过remove()移除一个对象

	private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

	/**
	 * 获取连接的方法
	 * 
	 * @return
	 */
	public static Connection getConnection() {

		// 从ThreadLocal中读取Connection
		Connection conn = threadLocal.get();
		// 判断是否为null
		if (conn == null) {

			try {
				// 获取一个数据连接
				conn = dataSource.getConnection();
				// 将数据库连接保存到ThreadLocal中
				threadLocal.set(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 返回Connection对象
		return conn;

		// 先从map读取线程
		/*
		 * Connection conn = map.get(Thread.currentThread()); //判断conn是否为null
		 * if(conn==null){ try { //获取一个新的数据库连接 conn =
		 * dataSource.getConnection(); //将新的连接放入到map中
		 * map.put(Thread.currentThread(), conn); } catch (SQLException e) {
		 * e.printStackTrace(); } }
		 * 
		 * return conn;
		 */

		/*
		 * Connection connection = null; try { connection =
		 * dataSource.getConnection(); } catch (SQLException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */

		/*
		 * if(connection==null){ try { connection = dataSource.getConnection();
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } }
		 */

	}

	/**
	 * 释放属性中Connection的方法
	 */
	public static void releaseConnection() {
		
		//获取ThreadLocal中数据库连接
		Connection conn = threadLocal.get();
		//释放数据库连接
		releaseConnection(conn);
		//移除连接
		threadLocal.remove();
		

		/*// 获取map中的Connection
		Connection conn = map.get(Thread.currentThread());
		// 释放数据库连接
		releaseConnection(conn);
		// 将关闭的数据库连接移除出map
		map.remove(Thread.currentThread());*/

		// releaseConnection(connection);

		// 将connection设置为null
		// connection = null;
	}

	/**
	 * 释放数据库连接的方法
	 * 
	 * @param conn
	 */
	public static void releaseConnection(Connection conn) {

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
