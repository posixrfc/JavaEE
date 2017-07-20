package com.atguigu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.bean.Province;


/**
 * 查询省信息的DAO，虚拟数据
 * @author lilichao
 *
 */
public class ProvinceDao {
	
	/**
	 * 用来保存城市数据 
	 */
	private static List<Province> list = new ArrayList<Province>();
	
	static{
		list.add(new Province(1, "北京市"));
		list.add(new Province(2, "天津市"));
		list.add(new Province(3, "河北省"));
	}
	
	public List<Province> getProvinceList(){
		return list;
	}
	

}
