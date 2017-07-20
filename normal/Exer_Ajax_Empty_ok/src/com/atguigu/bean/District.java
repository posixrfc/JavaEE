package com.atguigu.bean;

public class District {
	/**
	 * 区县的id
	 */
	private int id;

	/**
	 * 区县的名字
	 */
	private String name;

	/**
	 * 所属市的id
	 */
	private int cid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public District(int id, String name, int cid) {
		super();
		this.id = id;
		this.name = name;
		this.cid = cid;
	}

	public District() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", name=" + name + ", cid=" + cid + "]";
	}

}
