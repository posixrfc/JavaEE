package com.atguigu.orm.bean;

public class Girl {
	
	private Integer girlId;
	private String girlName;
	
	private Boy boy;

	public Girl() {
		// TODO Auto-generated constructor stub
	}

	public Girl(Integer girlId, String girlName) {
		super();
		this.girlId = girlId;
		this.girlName = girlName;
	}

	public Girl(Integer girlId, String girlName, Boy boy) {
		super();
		this.girlId = girlId;
		this.girlName = girlName;
		this.boy = boy;
	}

	@Override
	public String toString() {
		return "Girl [girlId=" + girlId + ", girlName=" + girlName + "]";
	}

	public Integer getGirlId() {
		return girlId;
	}

	public void setGirlId(Integer girlId) {
		this.girlId = girlId;
	}

	public String getGirlName() {
		return girlName;
	}

	public void setGirlName(String girlName) {
		this.girlName = girlName;
	}

	public Boy getBoy() {
		return boy;
	}

	public void setBoy(Boy boy) {
		this.boy = boy;
	}
	
}
