package com.atguigu.bookstore.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.atguigu.bookstore.utils.JDBCUtils;
import com.atguigu.bookstore.utils.WEBUtils;

/**
 * 定义操作数据库的常用方法，用来被其他的DAO继承
 * @author lilichao
 *
 * @param <T>
 */
public class BaseDao<T> {
	
	private QueryRunner runner = new QueryRunner();
	
	//这个type代表的子类的泛型类型
	private Class<T> type;
	
	
	
	public BaseDao() {
		//这个构造器最终由子类调用
		//获取一个带泛型的父类
		//BaseDao<User>
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获取泛型的类型
		Type[] types = pt.getActualTypeArguments();
		type = (Class<T>) types[0];
	}
	
	/**
	 * 以map集合的形式返回数据库中信息
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> getMapList(String sql , Object... params){
		
		Connection conn = JDBCUtils.getConnection();
		List<Map<String, Object>> list = null;
		try {
			list = runner.query(conn, sql, new MapListHandler(), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
			//e.printStackTrace();
		} 
		/*finally{
			JDBCUtils.releaseConnection(conn);
		}*/
		
		return list;
	}
	
	/**
	 * 批量向数据库中插入数据
	 * Object二维数组封装的是要向数据库中插入数据
	 * 它的第一维 表示的是要插入的次数，或者说是sql执行的次数
	 * 二维：表示的sql中需要的参数，就是替换？的那些东西
	 */
	public void batchUpdate(String sql , Object[][] params){
		
		//获取数据库连接
		Connection conn = JDBCUtils.getConnection();
		
		try {
			runner.batch(conn, sql, params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
		/*finally{
			JDBCUtils.releaseConnection(conn);
		}*/
		
	}
	
	/**
	 * 通过数据库查询一个单个的值
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object getSingleValue(String sql , Object ... params){
		
		Object obj = null;
		
		Connection conn = JDBCUtils.getConnection();
		
		try {
			obj = runner.query(conn, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
		/*finally{
			JDBCUtils.releaseConnection(conn);
		}*/
		
		return obj;
		
	}
	
	/**
	 * 查询一个对象的列表
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> getBeanList(String sql , Object ... params){
		
		List<T> list = null;
		
		Connection conn = JDBCUtils.getConnection();
		
		try {
			list = runner.query(conn, sql, new BeanListHandler<T>(type), params);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} 
		/*finally{
			JDBCUtils.releaseConnection(conn);
		}*/
		
		
		return list;
		
	}
	
	/**
	 * 查询单个对象的方法
	 * @param sql
	 * @param params
	 * @return
	 */
	public T getBean(String sql , Object ... params){
		
		T t = null;
		
		Connection conn = JDBCUtils.getConnection();
		
		try {
			t = runner.query(conn, sql, new BeanHandler<T>(type) , params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
		
		/*finally{
			JDBCUtils.releaseConnection(conn);
		}*/
		
		return t;
		
	}
	
	/**
	 * 更新数据库的方法，返回的是修改的条数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql , Object ... params){
		
		//定义一个变量，接收修改条数
		int update = 0;
		
		Connection conn = JDBCUtils.getConnection();
		
		try {
			update = runner.update(conn, sql, params);
		} catch (SQLException e) {
			
			//将异常转换一个RunnTimeException
			throw new RuntimeException(e);
			
		} 
		/*finally{
			JDBCUtils.releaseConnection(conn);
		}*/
		
		return update;
		
	}

}
