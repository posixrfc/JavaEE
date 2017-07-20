package com.atguigu.conversion.convertor;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.atguigu.conversion.bean.Address;

public class AddressConvertor extends StrutsTypeConverter{

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		Address address = null;
		
		if(values != null && values.length > 0) {
			String addressStr = values[0];
			String[] split = addressStr.split(",");
			address = new Address(split[0], split[1], split[2], split[3]);
		}
		
		System.out.println("类型转换器执行了");
		
		return address;
	}

	@Override
	public String convertToString(Map context, Object o) {
		// TODO Auto-generated method stub
		return null;
	}

}
