<%@page import="com.atguigu.bean.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- <%=request.getAttribute("studentList") %> --%>
	
	<% List<Student> list = (List<Student>)request.getAttribute("studentList"); %>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
		</tr>
	<% 
		for(int i = 0; i < list.size(); i++) {
			Student student = list.get(i);
	%>
			<tr>
				<td><%=student.getStuId() %></td>
				<td><%=student.getStuName() %></td>
			</tr>
	<%
		}
	%>
	</table>

</body>
</html>