package com.atguigu.wild.action;

public class BookAction {
	
	public String happyBook() {
		return "happy-success";
	}
	
	public String saveBook() {
		System.out.println("saveBook...");
		return "save-success";
	}
	
	public String removeBook() {
		System.out.println("removeBook...");
		return "remove-success";
	}
	
	public String editBook() {
		System.out.println("editBook...");
		return "edit-success";
	}
	
	public String queryBook() {
		System.out.println("queryBook...");
		return "query-success";
	}

}
