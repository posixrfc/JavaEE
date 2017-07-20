package cn.itcast.emp.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 工具类 
 * @author AdminTC
 */
public class JdbcUtil {
	/**
	 * 去src目录下加载c3p0-config.xml配置文件
	 */
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource();
	/**
	 * 获取数据源
	 */
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
}
