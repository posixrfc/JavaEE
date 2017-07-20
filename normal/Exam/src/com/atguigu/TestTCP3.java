package com.atguigu;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

//3.�ӿͻ��˷����ļ�������ˣ�����˱��浽���ء������ء����ͳɹ������ͻ��ˡ����ر���Ӧ������
public class TestTCP3 {

	//�ͻ���
	@Test
	public void client() throws IOException{
		Socket s = new Socket(InetAddress.getByName("127.0.0.1"), 9898);

		FileInputStream fis = new FileInputStream(new File("1.jpg"));
		OutputStream os = s.getOutputStream();
		
		byte[] b = new byte[1024];
		int len = 0;
		while((len = fis.read(b)) != -1){
			os.write(b, 0, len);
		}
		
		s.shutdownOutput();
		//���շ���˵ķ���
		InputStream in = s.getInputStream();
		b = new byte[1024];
		int len2 = 0;
		while((len2 = in.read(b)) != -1){
			System.out.println(new String(b, 0, len2));
		}
		
		in.close();
		os.close();
		fis.close();
		s.close();
	}
	
	//�����
	@Test
	public void server() throws IOException{
		ServerSocket ss = new ServerSocket(9898);
		Socket s = ss.accept();
		
		InputStream is = s.getInputStream();
		
		FileOutputStream fos = new FileOutputStream(new File("2.jpg"));
		
		byte[] b = new byte[1024];
		int len = 0;
		while((len = is.read(b)) != -1){
			fos.write(b, 0, len);
		}
		
		s.shutdownInput();
		
		//���ͷ������ͻ���
		OutputStream os = s.getOutputStream();
		os.write("����ͼƬ�ɹ���".getBytes());
		
		os.close();
		fos.close();
		is.close();
		s.close();
		ss.close();
	}
	
}
