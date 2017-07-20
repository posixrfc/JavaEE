package cn.itcast.ejb3.impl;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import cn.itcast.ejb3.HelloWorld;

@Stateless
@Remote(HelloWorld.class)
public class HelloWorldBean implements HelloWorld {

	@Override
	public String getGreeting(String greet) {
		return "Hello " + greet;
	}
}