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

	<!-- 在页面上实现国际化：填充字符串的占位符 -->
	未填充占位符的字符串：<s:text name="today"></s:text><br />
	
	填充了占位符的字符串：
	<s:text name="today">
		<s:param value="'Good'"/>
	</s:text>
	<br />
	
	使用日期对象填充占位符的字符串：
	<!-- 创建日期对象，并保存到某个域对象中 -->
	<s:bean name="java.util.Date" var="myDate"/>
	
	<s:text name="today">
		<!-- 按顺序填充占位符，value属性支持自动的OGNL解析 -->
		<s:param value="#attr.myDate"/>
	</s:text>

</body>
</html>