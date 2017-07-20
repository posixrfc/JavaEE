package com.atguigu.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		request.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload fileUpload = new ServletFileUpload(factory);
		fileUpload.setFileSizeMax(1024*199);
		fileUpload.setSizeMax(1024*650);
		try
		{
			List<FileItem> fileItems = fileUpload.parseRequest(request);
			for (FileItem fileItem : fileItems)
			{
				System.out.println("------------------------------");
				if (fileItem.isFormField())
				{
					String fieldName = fileItem.getFieldName();
					String value = fileItem.getString("utf-8");
					System.out.println("fieldName = " + fieldName);
					System.out.println("value = " + value);
				}
				else
				{
					String fieldName = fileItem.getFieldName();
					String fileName = fileItem.getName();
					System.out.println(fileName);
					if (fileName.contains("\\")) {
						fileName = fileName.substring(1 + fileName.lastIndexOf('\\'));
					}
					long size = fileItem.getSize();
					String mime = fileItem.getContentType();
					System.out.println("表单name属性名："+fieldName);
					System.out.println("文件的名字："+fileName);
					System.out.println("文件的大小："+size);
					System.out.println("文件类型："+mime);
					try
					{
						ServletContext context = this.getServletContext();
						String realPath = context.getRealPath("/upload");
						System.out.println(realPath);
						File file = new File(realPath);
						if(!file.exists()) {
							file.mkdirs();
						}
						String prefix = UUID.randomUUID().toString().replace("-", "");
						fileName = prefix+"_" + fileName;
						fileItem.write(new File(realPath + "/" + fileName));
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			response.getWriter().print("ok");			
		}
		catch (FileUploadException e)
		{
			if(e instanceof FileSizeLimitExceededException)
			{
				request.setAttribute("msg", "单个文件不能大于100KB");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else if(e instanceof SizeLimitExceededException)
			{
				request.setAttribute("msg", "文件总大小不能超过150KB");
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}			
		}
	}
}