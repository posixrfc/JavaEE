package com.atguigu.valuestack.action;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.atguigu.valuestack.bean.Person;
import com.atguigu.valuestack.bean.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

public class ValueStackAction implements RequestAware,SessionAware,ApplicationAware{
	
	private Map<String, Object> request;
	private Map<String, Object> app;
	private Map<String, Object> session;

	public String getMessage() {
		return "I am very happy in atguigu!";
	}
	
	public String testReadMapStack06() {
		
		//测试14：使用OGNL表达式从Map栈中使用带特殊符号的键读取数据
		request.put("special-name", "specialVal");
		
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		
		String special = valueStack.findString("#request['special-name']");
		System.out.println("special="+special);
		
		return "success";
	}
	
	public String testReadMapStack05() {
		
		//测试13：使用OGNL表达式从各个域对象中按从小到大的顺序读取数据
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		
		//准备数据
		//request.put("attrName", "reqVal");
		//session.put("attrName", "sessVal");
		app.put("attrName", "appVal");
		
		//按照属性域从小到大的顺序读取
		String attrName = valueStack.findString("#attr.attrName");
		System.out.println("attrName="+attrName);
		
		return "success";
	}
	
	public String testReadMapStack03() {
		
		//测试11：使用OGNL表达式从Map栈中读取session域中的数据
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		
		String banana = valueStack.findString("#session.banana02");
		System.out.println("banana="+banana);
		
		return "success";
	}
	
	public String testReadMapStack01() {
		
		//测试9：使用OGNL表达式从Map栈中读取请求参数
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		
		String userName = valueStack.findString("#parameters.userName[0]");
		System.out.println("userName="+userName);
		
		return "success";
	}
	
	public String testReadObjectStack03() {
		
		//测试8：OGNL：不指定索引时表示默认从栈顶读取数据
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		
		//2.准备数据
		Person person = new Person("TomPerson");
		Student student01 = new Student("JerryStudent");
		Student student02 = new Student("KateStudent");
		Student student03 = new Student("JustinStudent");
		
		//3.将测试数据压入值栈
		valueStack.push(student01);//索引3
		valueStack.push(student03);//索引2
		valueStack.push(student02);//索引1
		valueStack.push(person);//索引0
		
		//4.使用OGNL表达式读取数据
		String result = valueStack.findString("stuName");
		System.out.println(result);
		
		return "success";
	}
	
	public String testReadObjectStack02() {
		
		//测试7：OGNL：[索引].属性名的方式从索引值指定的位置开始查找对象
		//1.获取值栈对象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		
		//2.准备数据
		Person person = new Person("TomPerson");
		Student student01 = new Student("JerryStudent");
		Student student02 = new Student("KateStudent");
		Student student03 = new Student("JustinStudent");
		
		//3.将测试数据压入值栈
		valueStack.push(student03);//索引3
		valueStack.push(person);//索引2
		valueStack.push(student02);//索引1
		valueStack.push(student01);//索引0
		
		//4.使用OGNL表达式读取数据
		String result = valueStack.findString("[2].stuName");
		System.out.println(result);
		
		return "success";
	}
	
	public String testReadObjectStack01() {
		//测试6：OGNL：[0].属性名的方式从栈顶开始查找对象
		//1.获取值栈对象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		
		//2.准备数据
		Person person = new Person("TomPerson");
		Student student01 = new Student("JerryStudent");
		Student student02 = new Student("KateStudent");
		
		//3.将测试数据压入值栈
		valueStack.push(student02);
		valueStack.push(student01);
		valueStack.push(person);
		
		//4.使用OGNL表达式读取数据
		String result = valueStack.findString("[0].stuName2");
		System.out.println(result);
		
		return "success";
	}
	
	public String testMapStackValue() {
		
		//测试5：向请求域中保存数据，在Map栈中查看
		request.put("banana", "BananaIsGood");
		
		return "success";
	}
	
	public String testMapStack() {
		
		//目的：证明Map栈对象就是ActionContext对象所引用的那个Map
		//1.从ActionContext中获取Map栈
		Map<String, Object> contextMap = ActionContext.getContext().getContextMap();
		
		//2.从ValueStack对象中获取Map栈
		Map<String, Object> context = ActionContext.getContext().getValueStack().getContext();
		
		//3.比较
		System.out.println(context == contextMap);
		
		return "success";
	}
	
	public String testPush() {
		
		//1.获取值栈对象
		ValueStack valueStack = ActionContext.getContext().getValueStack();
		
		//2.准备数据
		Person person = new Person("TomPerson");
		Student student = new Student("JerryStudent");
		
		//3.压入
		valueStack.push(person);
		valueStack.push(student);
		
		valueStack.pop();
		
		return "success";
	}
	
	public String testGetValueStack() {
		
		//1.获取ActionContext对象
		ActionContext context = ActionContext.getContext();
		
		//2.通过ActionContext对象获取ValueStack对象
		ValueStack valueStack = context.getValueStack();
		
		System.out.println(valueStack);
		
		return "success";
	}
	
	public String testGetProperty() {
		return "success";
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.app = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
