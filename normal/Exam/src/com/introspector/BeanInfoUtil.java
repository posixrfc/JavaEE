package com.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanInfoUtil {
	public static void setProperty(UserInfo userInfo, String userName) throws Exception {
		PropertyDescriptor propDesc = new PropertyDescriptor(userName, UserInfo.class);
		Method methodSetUserName = propDesc.getWriteMethod();
		methodSetUserName.invoke(userInfo, "wang");
		System.out.println(userInfo.getUserName());
	}
	public static void getProperty(UserInfo userInfo, String userName) throws Exception {
		PropertyDescriptor propDesc = new PropertyDescriptor(userName, UserInfo.class);
		Method methodGetUserName = propDesc.getReadMethod();
		Object objUserName = methodGetUserName.invoke(userInfo);
		System.out.println(objUserName.toString());
	}
	public static void setPropertyByIntrospector(UserInfo userInft, String userName) throws Exception {
		BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
		PropertyDescriptor[] proDescrtptors = beanInfo.getPropertyDescriptors();
		if (proDescrtptors != null && proDescrtptors.length > 0)
			for (PropertyDescriptor propDesc : proDescrtptors)
				if (propDesc.getName().equals(userName)) {
					Method methodSetUserName = propDesc.getWriteMethod();
					methodSetUserName.invoke(userInft, "anal");
					System.out.println(userInft.getUserName());
					break;
				}
	}
	public static void getPropertyByIntrospector(UserInfo userInfo, String userName) throws Exception {
		BeanInfo beanInfo = Introspector.getBeanInfo(UserInfo.class);
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		if (null != propertyDescriptors && 0 < propertyDescriptors.length)
			for (PropertyDescriptor propDesc : propertyDescriptors)
				if (propDesc.getName().equals(userName)) {
					Method methodGetUserName = propDesc.getReadMethod();
					Object objUserName = methodGetUserName.invoke(userInfo);
					System.out.println(objUserName.toString());
					break;
				}
	}
}
