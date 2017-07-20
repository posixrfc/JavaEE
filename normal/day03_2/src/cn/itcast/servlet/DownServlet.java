package cn.itcast.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@SuppressWarnings("serial")
public class DownServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FileInputStream in = new FileInputStream("F:\\F\\白冰.jpg");//一个流，需要把它写入到response的输出流中
		String contentType = "image/jpeg";
		response.setContentType(contentType);//一个头，说明下载文件的类型
		
		String filename = "白冰.jpg";
		filename = new String(filename.getBytes("GBK"), "ISO-8859-1");
		String contentDisposition = "attachment;filename=" + filename;
		response.setHeader("content-disposition", contentDisposition);//一个头，它说明的是让浏览器弹出下载框，并显示文件名称
		
		OutputStream out = response.getOutputStream();		
		IOUtils.copy(in, out);//把in中的数据写入out中
	}
}