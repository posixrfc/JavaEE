package com.atguigu.orm.bean;

public class Boy {
	
	private Integer boyId;
	private String boyName;
	
	private Girl girl;
	
	public Boy() {
		// TODO Auto-generated constructor stub
	}

	public Boy(Integer boyId, String boyName) {
		super();
		this.boyId = boyId;
		this.boyName = boyName;
	}

	public Boy(Integer boyId, String boyName, Girl girl) {
		super();
		this.boyId = boyId;
		this.boyName = boyName;
		this.girl = girl;
	}

	@Override
	public String toString() {
		return "Boy [boyId=" + boyId + ", boyName=" + boyName + "]";
	}

	public Integer getBoyId() {
		return boyId;
	}

	public void setBoyId(Integer boyId) {
		this.boyId = boyId;
	}

	public String getBoyName() {
		return boyName;
	}

	public void setBoyName(String boyName) {
		this.boyName = boyName;
	}

	public Girl getGirl() {
		return girl;
	}

	public void setGirl(Girl girl) {
		this.girl = girl;
	}

}
