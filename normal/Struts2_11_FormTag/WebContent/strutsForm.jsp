<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@page import="java.util.HashMap"%>
	<%@page import="java.util.Map"%>
	<%@page import="java.util.ArrayList"%>
	<%@page import="com.atguigu.formtag.bean.City"%>
	<%@page import="java.util.List"%>
	<%
		List<City> cityList = new ArrayList<City>();
		cityList.add(new City("BeiJing","北京"));
		cityList.add(new City("TianJin","天津"));
		cityList.add(new City("WuHan","武汉"));
		request.setAttribute("loveCities", cityList);
		
		Map<String,String> jpMap = new HashMap<String,String>();
		jpMap.put("shenHu", "神户");
		jpMap.put("daBan", "大阪");
		jpMap.put("nailiang", "奈良");
		jpMap.put("beihaidao", "北海道");
		request.setAttribute("jpMap", jpMap);
		
		Map<String,String> usMap = new HashMap<String,String>();
		usMap.put("newYK", "纽约");
		usMap.put("hsd", "华盛顿");
		usMap.put("lsj", "洛杉矶");
		usMap.put("ytdl", "亚特兰大");
		request.setAttribute("usMap", usMap);
	%>

	<p>☆☆☆☆☆☆☆☆☆☆用于提交数据的表单☆☆☆☆☆☆☆☆☆☆</p>
	<!-- 默认情况下可以自动排版 -->
	<!-- action属性值如果以斜杠开始，则自动附加Web应用虚拟路径 -->
	<!-- method="post"是默认值，可以省略 -->
	<s:form action="/login">
	
		<s:hidden name="userId"/>
	
		<!-- 使用label属性生成当前表单元素的说明信息 -->
		<s:textfield name="userName" label="用户名"/>
		<s:password name="userPwd" label="密码"/>
		<s:textarea name="describ" label="自我介绍"/>
		
		<!-- 生成有选择功能的表单标签 -->
		<s:radio list="#request.loveCities" listKey="cityId" listValue="cityName" name="loveChinaCity"/>
		
		<!-- 如果list的值是一个Map类型，则使用Map的键作为listKey，使用Map的值作为listValue -->
		<s:checkboxlist list="#request.jpMap" name="jpCities"/>
		
		<s:select list="#request.usMap" name="usCity"/>
		
		<s:submit value="登录"/>
	
	</s:form>

</body>
</html>