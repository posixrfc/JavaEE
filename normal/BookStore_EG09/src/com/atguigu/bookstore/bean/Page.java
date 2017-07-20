package com.atguigu.bookstore.bean;

import java.util.List;

/**
 * 封装分页信息的类
 * @author lilichao
 *
 * @param <T>
 */
public class Page<T> {
	
	/**
	 * sql中开始索引
	 * 通过计算获得
	 */
	//private int index;
	
	/**
	 * 每页显示的条数
	 * pageSize可以自己指定，也可通过Servlet来传
	 * 在BookService中设置
	 */
	private int pageSize;
	
	/**
	 * 当前页码
	 * 页面传过来
	 * 在BookService中设置
	 */
	private int pageNumber;
	
	/**
	 * 总记录数
	 * 需要通过数据库查询
	 * SELECT count(*) from bs_book
	 * 在BookDao中设置
	 */
	private int totalRecord;
	
	/**
	 * 总页数
	 * 通过计算取得
	 */
	//private int totalPage;
	
	/**
	 * 保存的分页的对象
	 * 通过数据库查询
	 * 在BookDao中设置
	 */
	private List<T> data;
	
	/**
	 * 封装了请求地址
	 */
	private String path;

	public int getIndex() {
		
		/**
		 * 在get方法中计算索引值
		 * 假设每页显示2 总共10条记录
		 * pageNumber    index    pageSize
		 *   1            0          2
		 *   2            2          2
		 *   3            4          2
		 */
		return (getPageNumber()-1)*getPageSize();
		
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		
		if(pageNumber < 1){
			return 1;
		}
		
		if(pageNumber > getTotalPage()){
			return getTotalPage();
		}
		
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getTotalPage() {
		
		/**
		 * 计算总页数
		 *   总页数(totalPage)   总记录数（totalRecord）        每页的条数（pageSize）
		 *       5                    10                     2
		 *       5				      9					     2
		 *       4                    8                      2
		 *       4                    7                      2
		 */
		
		
		int tp = getTotalRecord()/getPageSize();
		if(getTotalRecord()%getPageSize()!=0){
			tp++;
		}
		return tp;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Page() {
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}

}
