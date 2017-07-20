package com.atguigu.upload.action;

import java.io.File;

public class MultiUploadAction {

	private File facePicture;
	private String facePictureContentType;
	private String facePictureFileName;
	
	private File logo;
	private String logoContentType;
	private String logoFileName;
	
	public String execute() {
		
		System.out.println("facePictureFileName="+facePictureFileName);
		System.out.println("logoFileName="+logoFileName);
		
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

	public void setLogo(File logo) {
		this.logo = logo;
	}

	public void setLogoContentType(String logoContentType) {
		this.logoContentType = logoContentType;
	}

	public void setLogoFileName(String logoFileName) {
		this.logoFileName = logoFileName;
	}

}
