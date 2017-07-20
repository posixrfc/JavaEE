<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.tableStyle {border: 1px solid black;border-collapse: collapse;margin: 50px auto 0px auto;}
	.tableStyle td,th {border: 1px solid black;padding: 5px;text-align: center;}
</style>
</head>
<body>

	<s:sort comparator="#request.comprator" var="bookList"></s:sort>
	<table class="tableStyle">
		<tr>
			<th><a href="${pageContext.request.contextPath }/sortAction.action?condition=bookName">BOOK NAME</a></th>
			<th><a href="${pageContext.request.contextPath }/sortAction.action?condition=author">AUTHOR</a></th>
			<th><a href="${pageContext.request.contextPath }/sortAction.action?condition=price">PRICE</a></th>
		</tr>
		<s:iterator value="#attr.bookList">
			<tr>
				<td>${bookName }</td>
				<td>${author }</td>
				<td>${price }</td>
			</tr>
		</s:iterator>
	</table>

</body>
</html>