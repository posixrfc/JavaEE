package com.atguigu.bookstore.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.atguigu.bookstore.utils.JDBCUtils;

/**
 * 统一事务控制Filter
 * @author lilichao
 *
 */
public class TransactionFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//获取数据库连接
		Connection conn = JDBCUtils.getConnection();
		//设置事务不自动提交
		try {
			conn.setAutoCommit(false);
			
			//放行请求
			chain.doFilter(request, response);
			
			//提交事务
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				//发生异常以后事务回滚
				conn.rollback();
				
				//出现异常以后，转发到一个错误
				//request.setAttribute("error", e.getMessage());
				request.setAttribute("error", "系统出现异常，请联系管理员");
				request.getRequestDispatcher("/pages/error/error.jsp").forward(request, response);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			JDBCUtils.releaseConnection();
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
