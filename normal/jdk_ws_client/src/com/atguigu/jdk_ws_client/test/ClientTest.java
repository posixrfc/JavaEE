package com.atguigu.jdk_ws_client.test;

import com.atguigu.jdk_ws.ws.HelloWsImpl;
import com.atguigu.jdk_ws.ws.HelloWsImplService;

public class ClientTest {
	public static void main(String[] args) {
		//创建一个Service对象
		HelloWsImplService service = new HelloWsImplService();
		//得到SEI接口的代理实现对象
		HelloWsImpl helloWs = service.getHelloWsImplPort();
		System.out.println(helloWs);
		//发送webservice请求,并最终得到返回的结果
		String result = helloWs.sayHello("JACK"); //真正请求webservice
		System.out.println("client "+result);
	}
}