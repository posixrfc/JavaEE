package cn.itcast.h3.qbc.user;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.junit.Test;

import cn.itcast.h3.util.H3Util;

public class XMLQueryApp {
	@Test
	//将HQL语句配置到hbm.xml文件中
	//<query name="getAll">from UserModel</query>
	public void test1(){
		Session s = H3Util.getSession();
		Query q = s.getNamedQuery("getAll");
		System.out.println(q.list());
		s.close();
	}
	@Test
	//将SQL语句配置到hbm.xml文件中
	//<sql-query name="getAll2">select * from tbl_user where uuid = ?</sql-query>
	public void test2(){
		Session s = H3Util.getSession();
		Query q = s.getNamedQuery("getAll2");
		q.setLong(0, 1L);
		System.out.println(q.list());
		s.close();
	}
}
