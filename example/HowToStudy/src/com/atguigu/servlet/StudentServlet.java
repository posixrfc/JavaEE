package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Student;
import com.atguigu.service.StudentService;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取请求参数
		
		//2.处理请求参数
		//①获取要在页面上显示的集合数据
		StudentService studentService = new StudentService();
		List<Student> stuList = studentService.getStuList();
		//②将集合对象保存到请求域中
		request.setAttribute("studentList", stuList);
		
		//3.根据请求参数处理的结果派发页面
		request.getRequestDispatcher("/student.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
