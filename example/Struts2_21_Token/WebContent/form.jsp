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
	
	<s:actionerror/>
	
	<s:form action="tokenAction">
	
		<!-- 注意一定要写在form标签内 -->	
		<s:token/>
	
		<s:textfield name="userName" label="用户名"/>
		<s:textfield name="password" label="密码"/>
		
		<s:submit value="提交"/>
	
	</s:form>
	
	<br /><br />
	
	<%=session.getAttribute("struts.tokens.token") %>

</body>
</html>