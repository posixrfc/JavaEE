package com.atguigu.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.bean.City;
import com.atguigu.bean.District;

/**
 * 查询区县信息的DAO，虚拟数据
 * @author lilichao
 *
 */
public class DistrictDao {
	/**
	 * map用来保存区县信息
	 * id为城市ID
	 * key为区县的列表
	 */
	private static Map<String , List<District>> map = new HashMap<String , List<District>>();
	
	public List<District> getListByCityId(String cid){
		
		return map.get(cid);
	};

	static {
		//北京
		List<District> bjList = new ArrayList<District>();
		bjList.add(new District(1, "东城区", 1));
		bjList.add(new District(2, "西城区", 1));
		bjList.add(new District(3, "崇文区", 1));
		bjList.add(new District(4, "宣武区", 1));
		bjList.add(new District(5, "朝阳区", 1));
		bjList.add(new District(6, "丰台区", 1));
		bjList.add(new District(7, "石景山区", 1));
		bjList.add(new District(8, "海淀区", 1));
		
		map.put("1", bjList);
		
		//天津
		List<District> tjList = new ArrayList<District>();
		tjList.add(new District(9, "和平区", 2));
		tjList.add(new District(10, "河东区", 2));
		tjList.add(new District(11, "河西区", 2));
		tjList.add(new District(12, "南开区", 2));
		tjList.add(new District(13, "河北区", 2));
		map.put("2", tjList);
		
		//石家庄
		List<District> sjzList = new ArrayList<District>();
		sjzList.add(new District(14, "新华区", 3));
		sjzList.add(new District(15, "桥西区", 3));
		sjzList.add(new District(16, "长安区", 3));
		sjzList.add(new District(17, "裕华区", 3));
		sjzList.add(new District(18, "井陉矿区", 3));
		map.put("3", sjzList);
		
		//保定
		List<District> bdList = new ArrayList<District>();
		bdList.add(new District(19, "竞秀区", 4));
		bdList.add(new District(20, "莲池区", 4));
		bdList.add(new District(21, "满城区", 4));
		bdList.add(new District(22, "清苑区", 4));
		bdList.add(new District(23, "徐水区", 4));
		map.put("4", bdList);
	}
}
