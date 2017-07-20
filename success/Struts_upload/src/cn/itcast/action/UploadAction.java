package cn.itcast.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {
	private String username;
	private File zhaoPian;// 封装了文件的内容
	private String zhaoPianContentType;// 封装了文件的MIME类型
	private String zhaoPianFileName;// 封装了文件的名称

	public void setUsername(String username) {
		this.username = username;
	}

	public void setZhaoPian(File zhaoPian) {
		this.zhaoPian = zhaoPian;
	}

	public void setZhaoPianContentType(String zhaoPianContentType) {
		this.zhaoPianContentType = zhaoPianContentType;
	}

	// 这里处理文件名称是绝对路径的问题
	public void setZhaoPianFileName(String zhaoPianFileName) {
		int index = zhaoPianFileName.lastIndexOf("\\");
		if(index != -1) {
			this.zhaoPianFileName = zhaoPianFileName.substring(index+1);
		} else {
			this.zhaoPianFileName = zhaoPianFileName;
		}
	}

	@Override
	public String execute() throws Exception {
		// 获取保存路径
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/images");
		// 创建目标文件
		File destFile = new File(path, zhaoPianFileName);
		
		// 把zhaoPian这个文件中的内容copy到destFile中
		FileUtils.copyFile(zhaoPian, destFile);
		
		return null;
	}
}
