<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css" />
</head>
<body>

	<table class="tableStyle">
		<tr>
			<th>ID</th><th>书名</th><th>作者</th><th>售价</th><th>更新</th><th>删除</th>
		</tr>
		<s:iterator value="#request.bookList">
			<tr>
				<td><s:property value="bookId"/></td>
				<td><s:property value="bookName"/></td>
				<td><s:property value="author"/></td>
				<td><s:property value="price"/></td>
				<td><s:a value="/editUI.action?bookId=%{bookId}">更新</s:a></td>
				<td><s:a value="/remove.action?bookId=%{bookId}">删除</s:a></td>
			</tr>
		</s:iterator>
	</table>
	
	<br /><br />
	
	<center>
		<s:a value="/addUI.jsp">添加图书</s:a>
	</center>
	
	<br /><br />
	
	<center>
		<s:a value="/index.jsp">回首页</s:a>
	</center>
</body>
</html>