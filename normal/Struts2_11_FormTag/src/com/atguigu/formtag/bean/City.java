package com.atguigu.formtag.bean;

public class City {
	
	//用于生成value属性值
	private String cityId;
	
	//用于生成页面上显示的内容
	private String cityName;
	
	public City() {}

	public City(String cityId, String cityName) {
		super();
		this.cityId = cityId;
		this.cityName = cityName;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", cityName=" + cityName + "]";
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
}
