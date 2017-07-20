package com.introspector;

public class Main {

	public static void main(String[] args) throws Exception {
		UserInfo userInfo = new UserInfo();
		String un = "userName";
		BeanInfoUtil.setProperty(userInfo, un);
		BeanInfoUtil.getProperty(userInfo, un);
		BeanInfoUtil.setPropertyByIntrospector(userInfo, un);
		BeanInfoUtil.getPropertyByIntrospector(userInfo, un);
	}

}
