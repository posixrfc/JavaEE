package cn.it.ws.a;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient {

	public static void main(String[] args) throws Exception{

		Scanner input=new Scanner(System.in);
		System.out.println("请输入数据:");
		String inputData = input.nextLine();

		Socket sc = new Socket("127.0.0.1", 6666);
		OutputStream os = sc.getOutputStream();
		os.write(inputData.getBytes());
		System.out.println(sc.toString());
		InputStream is = sc.getInputStream(); 
		byte[] buffer=new byte[1024];
		int len=-1;
		len=is.read(buffer);
		String getData=new String(buffer, 0, len);
		System.out.println("从服务端获取的数据:"+getData);
		
		is.close();
		os.close();
		sc.close();
		input.close();
	}
}