package com.atguigu.bean;

/**
 * 封装城市的信息，省的下一级
 * 
 * @author lilichao
 * 
 */
public class City {

	/**
	 * 城市的id
	 */
	private int id;

	/**
	 * 城市的名字
	 */
	private String name;

	/**
	 * 所属省的id
	 */
	private int pid;

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

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public City(int id, String name, int pid) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
	}

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", pid=" + pid + "]";
	}

}
