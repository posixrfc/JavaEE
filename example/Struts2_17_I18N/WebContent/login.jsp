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

	<s:debug/>
	
	<s:form action="/#">
	
		<s:textfield name="userName" key="userName"/>
		<s:password name="password" key="password"/>
		<s:submit key="login"/>
	
	</s:form>
	
	<br /><br />
	
	<s:a action="toLoginPage?request_locale=en_US">English</s:a>
	|
	<s:a action="toLoginPage?request_locale=zh_CN">中文</s:a>
	
	<br /><br />
	
	<s:a value="/index.jsp">回首页</s:a>

</body>
</html>