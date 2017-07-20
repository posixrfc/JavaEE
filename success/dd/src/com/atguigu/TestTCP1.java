package com.atguigu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

public class TestTCP1 {

	//�ͻ���
	@Test
	public void client(){
		String str = "�ͻ���ʹ��TCPЭ�鷢�����ݸ�����ˣ�";
		
		Socket s = null;
		OutputStream os = null;
		try {
			//1. ��ȡ�����׽��֣�IP��ַ�Ͷ˿ںŵ���ϣ�
			s = new Socket(InetAddress.getByName("127.0.0.1"), 9898);
			
			//2. ��ȡ��ǰ�׽��ֵ���
			os = s.getOutputStream();
			
			os.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(os != null){
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	//�����
	@Test
	public void server(){
		ServerSocket ss = null;
		Socket s = null;
		InputStream in = null;
		try {
			//1. ����ServerSocket��ʵ������ָ���˿ں�
			ss = new ServerSocket(9898);
			
			//2. ��ȡ��ǰ���ӵ������׽��� Socket
			s = ss.accept();
			
			//3. ��ȡ��ǰ���ӵ�������
			in = s.getInputStream();
			
			byte[] b = new byte[1024];
			int len = 0;
			while((len = in.read(b)) != -1){
				System.out.println(new String(b, 0, len));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(ss != null){
				try {
					ss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
