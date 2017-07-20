package com.atguigu.upload.action;

import java.io.File;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class MultiListUploadAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private List<File> logo;
	private List<String> logoContentType;
	private List<String> logoFileName;
	
	public String execute() {
		
		for (int i = 0; i < logo.size(); i++) {
			File file = logo.get(i);
			System.out.println("临时文件名="+file.getName());
			
			String contentType = logoContentType.get(i);
			System.out.println("内容类型="+contentType);
			
			String fileName = logoFileName.get(i);
			System.out.println("真实文件名="+fileName);
			
			System.out.println("==========================");
		}
		
		return "success";
	}

	public void setLogo(List<File> logo) {
		this.logo = logo;
	}

	public void setLogoContentType(List<String> logoContentType) {
		this.logoContentType = logoContentType;
	}

	public void setLogoFileName(List<String> logoFileName) {
		this.logoFileName = logoFileName;
	}

}
