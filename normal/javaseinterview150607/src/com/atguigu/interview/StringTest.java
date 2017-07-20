package com.atguigu.interview;

import java.util.Arrays;

import org.junit.Test;

public class StringTest {
	
	/*
	 * 内存中存储数据：
	 * ① 数组
	 * ② 集合：
	 * ArrayList
	 * 
	 * 
	 */
	
	
	/*问题三：
	 * 都是操作字符串相关的类
	 * String:不可变的字符序列；底层使用char[]存储
	 * StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储
	 * StringBuilder:可变的字符序列；线程不安全的，效率高，jdk5.0新增的；底层使用char[]存储
	 * 
	 * 底层char[]数组的长度是由String具体的字符串内容的长度所决定的。
	 * String str1 = new String(); //char c = new char[0]
	 * String str2 = new String("abc");//char c = new char[]{'a','b','c'}
	 * 
	 * StringBuffer/StringBuilder
	 * StringBuffer sb1 = new StringBuffer();//默认底层创建的char[]长度为16
	 * sb1.append("ab");//value[0] = 'a',value[1] = 'b'
	 * 
	 * 扩容问题：
	 * 像StringBuffer、StringBuilder中添加的字符都保存在底层char[]中，当数组的容量不够时，
	 * 默认扩容为原来的 2 倍 + 2.
	 * 底层扩容的源代码
			 * void expandCapacity(int minimumCapacity) {
		        int newCapacity = value.length * 2 + 2;
		        if (newCapacity - minimumCapacity < 0)
		            newCapacity = minimumCapacity;
		        if (newCapacity < 0) {
		            if (minimumCapacity < 0) // overflow
		                throw new OutOfMemoryError();
		            newCapacity = Integer.MAX_VALUE;
		        }
		        value = Arrays.copyOf(value, newCapacity);
		    }
	 * 
	 * 建议：StringBuffer s = new StringBuffer(55);
	 * 
	 * 类比：final/ finally /finalize()
	 *     throw  / throws
	 *     Collection / Collections
	 *     override / overload
	 *     
	 *     wait() / sleep()区别
	 */
	
	
	/*
	 * 问题二：
	 * 此String str = new String("atguigu");在底层创建了几个对象？
	 * 
	 * 
	 */
	@Test
	public void test2(){
		Order o1 = new Order("order_A",1001);
		Order o2 = new Order("order_A",1002);
		
		System.out.println(o1.getName() == o2.getName());//true
		
		o1.setName("order_B");
		
		System.out.println(o2.getName());//order_A
	}
	/*
	 * 问题一：
	 * String是不可变的字符序列。
	 * 体现为：①在已有的字符串后面添加新的字符串，需要重新创建
	 * ②替换已有的字符串中的指定字符的话，仍然需要重新创建新的字符串
	 * 
	 * 
	 */
	@Test
	public void test1(){
		String str1 = "java";
		String str2 = "java";
		System.out.println(str1 == str2);//true
		
		str1 += "android";
		System.out.println(str2);//java
		System.out.println(str1);//javaandroid
		
		String str3 = str2.replace('a', 'b');
		System.out.println(str3);//jbvb
		System.out.println(str2);//java
	}
	
}
