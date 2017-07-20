package com.atguigu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//2.�ͻ��˷������ݸ�����ˣ�����˸��跴����
public class TestTCP2 {
	
	@Test
	public void client() throws IOException{ //Ϊ�˱�����ʾ����ʱ��throws
		String str = "�ͻ���ͨ��TCP�������ݸ�����ˣ�";
		
		Socket s = new Socket(InetAddress.getByName("127.0.0.1"), 9898);
		OutputStream os = s.getOutputStream();
		os.write(str.getBytes());
		
		s.shutdownOutput();//��ʾ�Ѿ���������ĩβ
		
		//���շ���˵ķ���
		InputStream in = s.getInputStream();
		byte[] b = new byte[1024];
		int len = 0;
		while((len = in.read(b)) != -1){
			System.out.println(new String(b, 0, len));
		}
		
		in.close();
		os.close();
		s.close();
	}
	
	
	@Test
	public void server() throws IOException{
		ServerSocket ss = new ServerSocket(9898);
		Socket s = ss.accept();
		
		InputStream in = s.getInputStream();
		
		byte[] b = new byte[1024];
		int len = 0;
		while((len = in.read(b)) != -1){
			System.out.println(new String(b, 0, len));
		}
		
		s.shutdownInput();//��ʾ�Ѿ���������ĩβ
		
		//
		OutputStream os = s.getOutputStream();
		os.write("���ճɹ���".getBytes());
		
		os.close();
		in.close();
		s.close();
		ss.close();
	}

}
