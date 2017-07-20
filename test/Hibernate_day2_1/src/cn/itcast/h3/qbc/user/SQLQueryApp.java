package cn.itcast.h3.qbc.user;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import cn.itcast.h3.util.H3Util;

public class SQLQueryApp {
	public static void main(String[] args) {
		Session s = H3Util.getSession();
		String sql = "select u.* from tbl_user u";
		//执行原生SQL
		SQLQuery sq = s.createSQLQuery(sql);
		//为查询的表名别名指定对应的实体类型
		sq.addEntity("u", UserModel.class);
		List list = sq.list();
		System.out.println(list);
		
		s.close();
	}
}
