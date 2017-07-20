package com.atguigu.interview;

import org.junit.Test;

public class QuestionDemo {
	
	
	@Test
	public void test1(){
		String str = null;
		StringBuffer sb = new StringBuffer();
		sb.append(str);

		System.out.println(sb.length());//4

		System.out.println(sb);//"null"

		StringBuffer sb1 = new StringBuffer(str);//报NullPointerException
		System.out.println(sb1);//"null" 

	}
}
