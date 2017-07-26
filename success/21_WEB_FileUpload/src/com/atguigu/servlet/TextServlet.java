package com.atguigu.servlet;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public TextServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		BufferedReader bReader = request.getReader();
		StringBuilder sb = new StringBuilder();
		char[] chr = new char[1024];
		int len = -1;
		while ((len = bReader.read(chr)) != -1) {
			sb.append(chr, 0, len);
		}
		System.err.println(sb.toString());
//		String line = bReader.readLine();
//		while (null != line)
//		{
//			System.err.println(line);
//			line = bReader.readLine();
//		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
