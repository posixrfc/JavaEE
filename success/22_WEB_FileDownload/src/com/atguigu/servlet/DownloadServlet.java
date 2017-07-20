package com.atguigu.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		String path = context.getRealPath("/WEB-INF/听袁惟仁弹吉他.mp3");
		FileInputStream in = new FileInputStream(path);
		String mime = context.getMimeType(path);
		response.setContentType(mime);
		String fileName = "听袁惟仁弹吉他.mp3";
		/*String ua = request.getHeader("User-Agent");
		if(ua.contains("Firefox")){
			//火狐浏览器
			fileName = "=?utf-8?b?"+new BASE64Encoder().encode(fileName.getBytes("utf-8"))+"?=";
		}else{
			//在设置中文名字时，需要对中文进行编码
			//其他大部分浏览器
			fileName = URLEncoder.encode(fileName, "utf-8");
		}*/
		fileName = new String(fileName.getBytes("gbk"),"iso8859-1");
		response.setHeader("Content-Disposition", "attachment;filename="+fileName);
		ServletOutputStream out = response.getOutputStream();
		IOUtils.copy(in, out);
		in.close();
	}
}