package com.atguigu.upload.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;

public class SingleUploadAction implements ServletContextAware{
	
	private String userName;
	
	private File facePicture;
	private String facePictureContentType;
	private String facePictureFileName;

	private ServletContext servletContext;
	
	public String execute() throws IOException {
		
		System.out.println("服务器端缓冲区内的文件名："+facePicture.getName());
		System.out.println("上传文件的内容类型："+facePictureContentType);
		System.out.println("上传文件的实际文件名："+facePictureFileName);
		System.out.println("userName="+userName);
		
		//实现文件上传，本质：就是讲服务器端缓冲区内的文件复制到/upload目录下
		//1.准备输入流
		InputStream in = new FileInputStream(facePicture);
		
		//2.准备输出流对象
		//①给文件名附加当前系统时间，避免同名文件覆盖其他文件
		this.facePictureFileName = System.currentTimeMillis()+facePictureFileName;
		
		//②目标文件的虚拟路径
		String virtualPath = "/upload/"+facePictureFileName;
		
		//③将目标文件的虚拟路径转化为文件系统中的真实路径，否则不能使用IO流API进行操作
		String realPath = this.servletContext.getRealPath(virtualPath);
		
		//④根据真实路径创建输出流对象
		OutputStream out = new FileOutputStream(realPath);
		
		//⑤通过读写操作实现文件复制
		int len = 0;
		byte [] car = new byte[1024];
		
		while((len = in.read(car))!=-1) {
			out.write(car, 0, len);
		}
		
		in.close();
		out.close();
		
		return "success";
	}

	public void setFacePicture(File facePicture) {
		this.facePicture = facePicture;
	}

	public void setFacePictureContentType(String facePictureContentType) {
		this.facePictureContentType = facePictureContentType;
	}

	public void setFacePictureFileName(String facePictureFileName) {
		this.facePictureFileName = facePictureFileName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public void setServletContext(ServletContext context) {
		this.servletContext = context;
	}
}
