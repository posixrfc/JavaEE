package com.atguigu.test;

import java.util.List;

import org.junit.Test;

import com.atguigu.bean.City;
import com.atguigu.bean.District;
import com.atguigu.bean.Province;
import com.atguigu.dao.CityDao;
import com.atguigu.dao.DistrictDao;
import com.atguigu.dao.ProvinceDao;

public class TestDao {

	ProvinceDao pDao = new ProvinceDao();
	CityDao cityDao = new CityDao();
	DistrictDao dao = new DistrictDao();
	
	@Test
	public void testDist(){
		List<District> list = dao.getListByCityId("4");
		for (District district : list) {
			
			System.out.println(district);
			
		}
	}
	
	@Test
	public void testCity(){
		List<City> list = cityDao.getCityByProId("3");
		for (City city : list) {
			System.out.println(city);
		}
	}
	
	@Test
	public void testProvinceDao() {
		List<Province> list = pDao.getProvinceList();
		
		for (Province province : list) {
			System.out.println(province);
		}
	}

}
