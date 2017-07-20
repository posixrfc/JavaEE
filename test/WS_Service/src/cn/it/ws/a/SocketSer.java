package cn.it.ws.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketSer {
	public static void main(String[] args) throws Exception {
		ServerSocket ss=new ServerSocket(6666);
		boolean flag=true;
		while(flag) {
			System.out.println("监听客户端的数据:");
			Socket sc = ss.accept();
			InputStream is = sc.getInputStream();
			byte[] buffer=new byte[1024];
			int len=-1;
			len=is.read(buffer);
			String getData=new String(buffer, 0, len);
			System.out.println("从客户端" + sc.toString() + "获取的数据:"+getData);
			String outPutData=getData.toUpperCase();
			OutputStream os = sc.getOutputStream();
			os.write(outPutData.getBytes("UTF-8"));
			os.close();
			is.close();
			sc.close();
		}
		ss.close();
	}
}