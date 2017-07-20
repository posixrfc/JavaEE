package cn.itcast.log4j.demo;

import org.apache.log4j.Logger;

public class UserService {
	private static Logger log = Logger.getLogger(Object.class);
	public void add(){
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");
		log.fatal("fatal");
		System.out.println("UserService running.....");
	}
}