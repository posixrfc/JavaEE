package com.atguigu.i18n.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

public class I18NAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	public String getStackeValue() {
		return "happy";
	}

	public String execute() {
		
		String userName = this.getText("userName");
		System.out.println("userName="+userName);
		
		String today = this.getText("today");
		System.out.println("today="+today);
		
		//通过额外传入一个List类型的数据，填充占位符
		List<String> paramStrList = new ArrayList<String>();
		paramStrList.add("Good");
		today = this.getText("today",paramStrList);
		System.out.println("today="+today);
		
		//可以对日期类型的数据进行自动的格式化
		List<Date> paramDateList = new ArrayList<Date>();
		paramDateList.add(new Date());
		today = this.getText("today",paramDateList);
		System.out.println("today="+today);
		
		return "success";
	}

}
