package cn.itcast.test;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import cn.itcast.ejb3.HelloWorld;

public class EJBClient {

	public static void main(String[] args) {
//		Properties props = new Properties();
//		props.setProperty("java.naming.factory.initial", "org.jnp.interfaces.NamingContextFactory");
//		props.setProperty("java.naming.provider.url", "localhost:1099");
		try {
			InitialContext ctx = new InitialContext();
			HelloWorld helloworld = (HelloWorld) ctx.lookup("HelloWorldBean/remote");
			System.out.println(helloworld.getClass());
			System.out.println(helloworld.getGreeting("evening"));
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}