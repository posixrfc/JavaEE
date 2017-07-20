package com.atguigu.jdk_ws.ws;

import javax.jws.WebService;

@WebService
public class HelloWsImpl implements HelloWs {

	@Override
	public String sayHello(String name) {
		System.out.println("server sayHello() "+name);
		return "hello "+name;
	}

}
