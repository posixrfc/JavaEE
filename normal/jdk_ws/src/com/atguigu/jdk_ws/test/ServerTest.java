package com.atguigu.jdk_ws.test;

import javax.xml.ws.Endpoint;
import com.atguigu.jdk_ws.ws.HelloWsImpl;

public class ServerTest {
	public static void main(String[] args) {
		String address = "http://192.168.10.11:8089/jdk_ws/hellows";
		Endpoint.publish(address, new HelloWsImpl());
		System.out.println("webservice发布成功!");
	}
}