package com.atguigu.bean;

/**
 * 封装省信息的类
 * 
 * @author lilichao
 * 
 */
public class Province {

	/**
	 * 省的id
	 */
	private int id;
	/**
	 * 省的名字
	 */
	private String name;

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

	public Province(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Province() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", name=" + name + "]";
	}

}
