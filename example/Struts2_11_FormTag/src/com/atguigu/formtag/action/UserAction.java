package com.atguigu.formtag.action;

import java.util.List;

import com.atguigu.formtag.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class UserAction {

	private Integer userId;

	private String userName;
	private String userPwd;
	private String describ;
	
	private String loveChinaCity;
	
	private List<String> jpCities;
	
	private boolean merried = true;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void setDescrib(String describ) {
		this.describ = describ;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getDescrib() {
		return describ;
	}

	public String getLoveChinaCity() {
		return loveChinaCity;
	}

	public void setLoveChinaCity(String loveChinaCity) {
		this.loveChinaCity = loveChinaCity;
	}

	public List<String> getJpCities() {
		return jpCities;
	}

	public void setJpCities(List<String> jpCities) {
		this.jpCities = jpCities;
	}

	public boolean isMerried() {
		return merried;
	}

	public void setMerried(boolean merried) {
		this.merried = merried;
	}

	public String execute() {
//		System.out.println("userName=" + userName);
//		System.out.println("userPwd=" + userPwd);
//		System.out.println("describ=" + describ);
//		
//		System.out.println("loveChinaCity="+loveChinaCity);
//		System.out.println("jpCities="+jpCities);

		// 手动的将User对象压入栈顶，表单标签就会根据User对象进行回显
//		User user = new User("Jerry2015", "654321", "EEEEEEEE");
//		ValueStack valueStack = ActionContext.getContext().getValueStack();
//		valueStack.push(user);
//		
//		this.userId = 800523;
		
		System.out.println("婚否="+merried);

		return "success";
	}

}
