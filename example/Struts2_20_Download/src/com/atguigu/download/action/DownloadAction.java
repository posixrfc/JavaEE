package com.atguigu.download.action;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;

import sun.misc.BASE64Encoder;

public class DownloadAction implements ServletContextAware, ServletRequestAware{
	
//	contentType - 要下载的文件的内容类型
	private String contentType;
	
//	contentLength - 要下载的文件的大小
	private int contentLength;
	
//	contentDisposition - 文件下载时专用的响应消息头：attachment;filename="document.pdf"
	private String contentDisposition;
	
	//将目标文件读取到内存中的输入流对象
	private InputStream inputStream;

	private ServletContext servletContext;

	private HttpServletRequest request;

	public String getContentType() {
		return contentType;
	}

	public int getContentLength() {
		return contentLength;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public InputStream getInputStream() {
		return inputStream;
	}
	
	public String execute() throws IOException {
		
		//为下载相关的各个属性赋值
		//1.创建输入流对象
		//①创建虚拟路径字符串
		String virtualPath = "/WEB-INF/郁金香.jpg";
		
		//②将虚拟路径字符串转换为真实路径
		String realPath = this.servletContext.getRealPath(virtualPath);
		
		//③创建输入流对象
		this.inputStream = new FileInputStream(realPath);
		
		//2.解析目标文件的内容类型
		this.contentType = this.servletContext.getMimeType(realPath);
		
		//3.获取文件大小
		this.contentLength = this.inputStream.available();
		
		//4.设置contentDisposition
		//创建文件名局部变量
		String fileName = "郁金香.jpg";
		
		//①从请求消息头中读取User-Agent信息
		String userAgent = this.request.getHeader("User-Agent");
		
		//②通过User-Agent判断发出当前请求的浏览器是不是火狐
		if(userAgent.contains("Firefox")) {
			//③如果是火狐的话，对文件名进行特殊编码
			fileName = "=?utf-8?b?"+new BASE64Encoder().encode(fileName.getBytes("utf-8"))+"?=";
			
		}else{
			//④如果不是火狐的话，按照UTF-8对文件名进行编码
			fileName = URLEncoder.encode(fileName, "utf-8");
			
		}
		
		//⑤使用编码后的文件名设置响应消息头
		this.contentDisposition = "attachment;filename="+fileName;
		
		return "success";
	}

	@Override
	public void setServletContext(ServletContext arg0) {
		this.servletContext = arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}

}
