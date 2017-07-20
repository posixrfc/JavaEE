package cn.itcast.h3.qbc.user;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import cn.itcast.h3.util.H3Util;

public class QBCApp {
	//Criteria基础实例
	@Test
	public void qbc1(){
		Session s = H3Util.getSession();
		//获取Criteria对象
		Criteria c = s.createCriteria(UserModel.class);
		List list = c.list();
		System.out.println(list);
		
		s.close();
	}
	//QBC查询单个属性
	@Test
	public void qbc2(){
		Session s = H3Util.getSession();
		//获取Criteria对象
		Criteria c = s.createCriteria(UserModel.class);
		//只查询单个属性
		Property p = Property.forName("age");
		c.setProjection(p);
		
		List<Integer> list = c.list();
		System.out.println(list);
		
		s.close();
	}
	//QBC查询多个属性
	@Test
	public void qbc3(){
		Session s = H3Util.getSession();
		//获取Criteria对象
		Criteria c = s.createCriteria(UserModel.class);
		//查询多个属性
		//1.将要查询的属性声明
		Property p1 = Property.forName("age");
		Property p2 = Property.forName("userName");
		//2.将这些属性放入到一个属性列表对象中
		ProjectionList plist = Projections.projectionList();
		//3.将属性添加到列表对象中
		plist.add(p1);
		plist.add(p2);
		//4.将属性列表对象设置到查询的模型中
		c.setProjection(plist);
		
		List<Object[]> list = c.list();
		for(Object[] objs:list){
			for(Object obj:objs){
				System.out.print(obj+"\t");
			}
			System.out.println();
		}
		
		s.close();
	}
	//QBC查询分页
	@Test
	public void qbc4(){
		Session s = H3Util.getSession();
		//获取Criteria对象
		Criteria c = s.createCriteria(UserModel.class).setFirstResult(0).setMaxResults(2);
		List list = c.list();
		System.out.println(list);
		s.close();
	}
	//QBC条件查询
	@Test
	//查询名称中包含有jock的用户信息
	//select um from UseModel um where um.userName like ?     ?->value 
	public void qbc5(){
		Session s = H3Util.getSession();
		//获取Criteria对象
		Criteria c = s.createCriteria(UserModel.class);
		//为QBC添加查询条件的方式 c.add(条件)
		//c.add(Restrictions.like("userName", "%jock%"));
		//c.add(Restrictions.eq("age", 34));
		//c.add(Restrictions.le("age", 30));
		//c.add(Restrictions.eq("userName", "jock"));
		//非关系
		//c.add(Restrictions.not(Restrictions.eq("userName", "jock")));
		//and
		c.add(Restrictions.and(Restrictions.eq("age", 33), Restrictions.eq("userName", "jock")));
		//or
		c.add(Restrictions.or(Restrictions.eq("age", 33), Restrictions.eq("userName", "jock")));
		
		List list = c.list();
		System.out.println(list);
		s.close();
	}
	//QBC使用聚合函数查询
	@Test
	public void qbc6(){
		Session s = H3Util.getSession();
		//获取Criteria对象
		Criteria c = s.createCriteria(UserModel.class);
		/*
		//count
		//HQL: SELECT count(uuid) from UserModel
		c.setProjection(Projections.rowCount());
		Object obj = c.uniqueResult();
		System.out.println(obj);
		*/
		/*
		//max min
		c.setProjection(Projections.max("age"));
		Object obj = c.uniqueResult();
		System.out.println(obj);
		*/
		c.setProjection(Projections.avg("age"));
		Object obj = c.uniqueResult();
		System.out.println(obj);
		
		s.close();
	}
	//QBC分组
	@Test
	public void qbc7(){
		Session s = H3Util.getSession();
		//获取Criteria对象
		Criteria c = s.createCriteria(UserModel.class);
		//分组设置通过投影进行
		//HQL: select age,count(age) from UserModel group by age
		c.setProjection(Projections.projectionList().add(Projections.groupProperty("age")).add(Projections.rowCount()));
		List<Object[]> list = c.list();
		
		for(Object[] objs:list){
			for(Object obj:objs){
				System.out.print(obj+"\t");
			}
			System.out.println();
		}
		
		s.close();
	}
	//QBC排序
	@Test
	public void qbc8(){
		Session s = H3Util.getSession();
		//获取Criteria对象
		Criteria c = s.createCriteria(UserModel.class);
		c.addOrder(Order.desc("age"));
		c.addOrder(Order.desc("userName"));
		List<UserModel> list = c.list();
		for(UserModel um:list){
			System.out.println(um);
		}
		
		s.close();
	}
	//QBC离线查询
	@Test
	public void qbc9(){
		//查询条件都在表现层
		//创建一个离线查询条件对象
		DetachedCriteria dc = DetachedCriteria.forClass(UserModel.class);
		dc.add(Restrictions.eq("userName", "jock"));
		
		System.out.println("-------------------------------");
		
		DetachedCriteria dc1 = dc;
		
		System.out.println("-------------------------------");
		
		DetachedCriteria dc2 = dc1;
		Session s = H3Util.getSession();
		Criteria c = dc2.getExecutableCriteria(s);
		System.out.println(c.list());
		
		s.close();
		
	}
	
	
	
	
	
}
