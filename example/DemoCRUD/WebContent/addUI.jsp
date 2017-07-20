<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/style/style.css" />
<title>Insert title here</title>
</head>
<body>
	<s:form action="/save.action">
		
		<table class="tableStyle">
			<tr>
				<td colspan="2" class="centerText" id="tableHeader">保存图书信息</td>
			</tr>
			<tr>
				<td>图书名称：</td>
				<td><s:textfield cssClass="textStyle" name="bookName"></s:textfield></td>
			</tr>
			<tr>
				<td>图书作者：</td>
				<td><s:textfield cssClass="textStyle" name="author"></s:textfield></td>
			</tr>
			<tr>
				<td>图书价格：</td>
				<td><s:textfield cssClass="textStyle" name="price"></s:textfield></td>
			</tr>
			<tr>
				<td colspan="2" class="centerText"><s:submit cssClass="btnStyle" value="保存"></s:submit></td>
			</tr>
		</table>
	
	</s:form>
		
	<br /><br />
	
	<center>
		<s:a value="/index.jsp">回首页</s:a>
	</center>
</body>
</html>