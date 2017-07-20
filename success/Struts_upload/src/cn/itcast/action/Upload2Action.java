package cn.itcast.action;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class Upload2Action extends ActionSupport {
	private String username;
	private List<File> zhaoPian;// 封装了文件的内容
//	private List<String> zhaoPianContentType;// 封装了文件的MIME类型
	private List<String> zhaoPianFileName;// 封装了文件的名称

	public void setUsername(String username) {
		this.username = username;
	}

	public void setZhaoPian(List<File> zhaoPian) {
		this.zhaoPian = zhaoPian;
	}
/*
	public void setZhaoPianContentType(List<String> zhaoPianContentType) {
		this.zhaoPianContentType = zhaoPianContentType;
	}
*/
	public void setZhaoPianFileName(List<String> zhaoPianFileName) {
		this.zhaoPianFileName = zhaoPianFileName;
	}

	@Override
	public String execute() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/images");
		for(int i = 0; i < zhaoPian.size(); i++) {
			File file = zhaoPian.get(i);//第一个文件的内容
			String name = zhaoPianFileName.get(i);//第一个文件的名称
			int index = name.lastIndexOf("\\");
			if(index != -1) {
				name = name.substring(index+1);
			}
			
			File destFile = new File(path, name);
			FileUtils.copyFile(file, destFile);
		}
		return null;
	}
}
