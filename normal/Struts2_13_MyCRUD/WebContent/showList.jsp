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
	<table>
		<s:if test="#request.bookList == null || #request.bookList.empty">
			<tr>
				<td>当前没有图书数据可以显示</td>
			</tr>
		</s:if>
		<s:else>
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>AUTHOR</th>
				<th>PRICE</th>
				<th>删除</th>
				<th>更新</th>
			</tr>
			<s:iterator value="#request.bookList">
				<tr>
					<td><s:property value="bookId"/></td>
					<td><s:property value="bookName"/></td>
					<td><s:property value="author"/></td>
					<td><s:property value="price"/></td>
					<td>
						<s:a action="deleteBook?bookId=%{bookId}">删除</s:a>
					</td>
					<td>
						<s:a action="editBook?bookId=%{bookId}">更新</s:a>
					</td>
				</tr>
			</s:iterator>
		</s:else>
	</table>
	
	<br /><br /><br />
	
	<s:a value="/addUI.jsp">添加图书</s:a>
	
	</center>
</body>
</html>