package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Province;
import com.atguigu.dao.ProvinceDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class ProvinceServlet
 */
public class ProvinceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private ProvinceDao dao = new ProvinceDao();
	/**
	 * 查询所有省份信息
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		
		//获取省份的list
		List<Province> list = dao.getProvinceList();
		
		//将list转换为json对象
		Gson gson = new Gson();
		String proStr = gson.toJson(list);
		
		//将json数据作为响应发送
		response.getWriter().print(proStr);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
