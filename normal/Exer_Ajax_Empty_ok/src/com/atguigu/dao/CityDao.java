package com.atguigu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.bean.City;

/**
 * 查询城市信息的DAO，虚拟数据
 * @author lilichao
 *
 */
public class CityDao {
	
	/**
	 * map用来保存城市信息
	 * id为省份ID
	 * key为城市的列表
	 */
	private static Map<String , List<City>> map = new HashMap<String , List<City>>();
	
	public List<City> getCityByProId(String pid){
		return map.get(pid);
	}

	static {
		//北京
		List<City> bjList = new ArrayList<City>();
		bjList.add(new City(1, "北京市", 1));
		map.put("1", bjList);
		
		//天津
		List<City> tjList = new ArrayList<City>();
		tjList.add(new City(2, "天津市", 2));
		map.put("2", tjList);
		
		//河北
		List<City> hbList = new ArrayList<City>();
		hbList.add(new City(3, "石家庄市", 3));
		hbList.add(new City(4, "保定市", 3));
		map.put("3", hbList);
		
	}
}
