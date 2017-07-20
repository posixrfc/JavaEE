package com.atguigu.interview;

import java.util.HashMap;

public class CollectionTest {
	/*
	 * 数据结构：
	 * 1.数据之间的逻辑关系：集合，一对一，一对多，多对多的关系
	 * 2.数据的存储结构：①顺序存储（一维数组） ②链式存储
	 * 
	 * 
	 * Collection
	 * 		|----List(开发中常用的)
	 * 		|----Set
	 * 
	 * Map(开发中常用的)
	 * 
	 * 问题一：
	 * 都实现了List接口，存储的都是可重复的、有序的数据
	 * ArrayList:是List的主要实现类，线程不安全的，效率高；Collections.synchronizedList(list);底层使用Object[]存储
	 * Vector:是古老的实现类，线程安全的，效率低；底层使用Object[]存储
	 * LinkedList:对于频繁的插入、删除操作，建议使用此类。底层是使用双向链表实现
	 * 
	 * ArrayList list = new ArrayList();//Object arr = new Object[10]默认长度是10
	 *  list.add(obj1);
	 *  list.add(obj2);
	 *  ...
	 *  一旦超过底层的数组的长度，就需要扩容。默认扩容为原来的1.5倍
	 * 建议：
	 * ArrayList list = new ArrayList(90);
	 */
	
	
	/*
	 * 问题二：
	 * HashMap的底层实现：
	 * 兼具数组的存储结构和链表的存储结构。
	 * HashMap map = new HashMap();
	 * 默认底层数组为Entry[]，长度是16，加载因子0.75.
	 * 通过map添加entry,在底层不是顺序存储在数组中的，而是根据entry里的key的hash值决定存储的位置。
	 * 如果已有的entry和将要存储的新的entry的hash值相同，并且equals()也返回false,两个entry就是
	 * 一个链表存储。如果hash值相同，并且equals()也返回true,新的entry的value就会替换旧的entry
	 * 的value.
	 * 
	 * 扩容：DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR = 16 * 0.75 = 12.
	 * 当entry的个数超过12的时候，就扩容为原来的2倍
	 * 
	 *    >引申：HashSet的底层实现。
	 *    	public HashSet() {
        		map = new HashMap<>();
    		}
	 * 
	 * 问题三：
	 * HashMap和Hashtable的区别
	 * ①HashMap主要实现类；Hashtable是古老实现类
	 * ②HashMap是线程不安全的；Hashtable是线程安全的。
	 * 
	 */
}
