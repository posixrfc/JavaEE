package com.atguigu.ioc.component;

public class UserAction {
	
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void save() {
		userService.save();
	}
	
}
