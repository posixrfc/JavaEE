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
	
	<s:form action="/saveBook">
	
		<s:textfield name="bookName" value="NewBook" label="书名"/>
		<s:textfield name="author" value="NewAuthor" label="作者"/>
		<s:textfield name="price" value="100.50" label="价格"/>
		
		<s:submit value="保存"/>
	
	</s:form>
	
	</center>
	
</body>
</html>