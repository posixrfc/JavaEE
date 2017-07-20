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

	<center>
		<s:form action="/">
		
			<s:text name="today">
				<s:param value="today"></s:param>
			</s:text>
			<s:textfield name="userName" key="userName"></s:textfield>
			<s:textfield name="password" key="password"></s:textfield>
			<s:submit key="login" align="center"></s:submit>
			
		</s:form>
		
		<p>
			<s:a action="loginAction?request_locale=en_US">English</s:a>
			|
			<s:a action="loginAction?request_locale=zh_CN">中文</s:a>
		</p>
		
		<s:a value="/index.jsp">回首页</s:a>
	</center>

</body>
</html>