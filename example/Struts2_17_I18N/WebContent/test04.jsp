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
	
	<!-- 在页面上实现国际化：simple主题 -->

	<s:form action="/#" theme="simple">
	
		<s:text name="userName"/>
		<s:textfield name="usreName" key="userName"/><br />
		
		<s:text name="password"/>
		<s:password name="password" key="password"/><br />
		
		<s:submit key="login"/>
	
	</s:form>

</body>
</html>