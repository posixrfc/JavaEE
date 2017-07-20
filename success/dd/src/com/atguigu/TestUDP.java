package com.atguigu;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.junit.Test;

public class TestUDP {
	
	//���Ͷ�
	@Test
	public void send() throws IOException{
		String str = "ʹ��UDP��������";
		DatagramSocket ds = new DatagramSocket();
		
		int i = 0;
		while(i < 100){
			
			byte[] buf = str.getBytes(); //ע�⣺��С���ܳ���64kb
			
			DatagramPacket dp = new DatagramPacket(buf, 0, buf.length, InetAddress.getByName("127.0.0.1"), 9898);
			
			ds.send(dp);
			
			System.out.println("------���Ͷ˷�����" + i++ + "������------");
		}
		
		
		ds.close();
	}
	
	//���ն�
	@Test
	public void receive() throws IOException{
		DatagramSocket ds = new DatagramSocket(9898);
		
		int i = 0;
		while(i < 100){
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
			
			ds.receive(dp);
			
			System.out.println(new String(dp.getData(), 0, dp.getLength()));
			
			System.out.println("******���ն˽�����" + i++ + "������******");
		}
		
		ds.close();
	}

}
