package com.atguigu.tag.action;

import com.opensymphony.xwork2.ActionSupport;

public class TagAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	public String getHappyMessage() {
		return "吃饱了就是这么开心";
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}
