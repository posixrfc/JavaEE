package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.District;
import com.atguigu.dao.DistrictDao;
import com.google.gson.Gson;

/**
 * Servlet implementation class DistrictServlet
 */
public class DistrictServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DistrictDao dao = new DistrictDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//设置响应编码
		response.setContentType("text/html;charset=utf-8");
		//获取城市的id
		String cid = request.getParameter("cid");
		//根据城市id查找区县
		List<District> list = dao.getListByCityId(cid);
		//将list转换为JSON对象
		Gson gson = new Gson();
		String str = gson.toJson(list);
		//将json作为响应发送
		response.getWriter().print(str);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
