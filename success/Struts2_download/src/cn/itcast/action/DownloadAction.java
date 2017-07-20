package cn.itcast.action;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class DownloadAction extends ActionSupport {
	private InputStream input;

	public InputStream getInputStream() {
		return input;
	}
	
	public String getFileName() throws UnsupportedEncodingException {
		String fileName = "白冰.jpg";
		fileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
		return fileName;
	}
	
	public String getType() {
		return "image/jpeg";
	}
	
	@Override
	public String execute() throws Exception {
		input = new FileInputStream("C:\\Users\\Administrator\\Desktop\\fin\\lj0508zyx24s.jpg");
		return SUCCESS;
	}
}