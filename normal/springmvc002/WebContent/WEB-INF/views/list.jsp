<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
	$(function(){
		$(".deleteCss").click(function(){
			var action = $(this).attr("href");
			$("#deleteForm").attr("action",action).submit();
			return false;
		})
	})
</script>
<body>
	<c:if test="${requestScope.employees == null}">
		nothing......
	</c:if>
	<c:if test="${ not empty requestScope.employees}">
		<table border="1" cellpadding="10" cellspacing="2">
			<tr>
				<th>id</th>
				<th>lastName</th>
				<th>email</th>
				<th>gender</th>
				<th>department</th>
				<th>edit</th>
				<th>delete</th>
			</tr>
		<c:forEach items="${requestScope.employees}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.lastName}</td>
				<td>${employee.email}</td>
				<td>${employee.gender == 1 ? 'male':'female'}</td>
				<td>${employee.department.departmentName}</td>
				<td><a href="${pageContext.request.contextPath}/emp/${employee.id}">edit</a></td>
				<td><a class="deleteCss" href="${pageContext.request.contextPath}/emp/${employee.id}">delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	<br>
	<form id="deleteForm" action="" method="post">
		<input type="hidden" name="_method" value="DELETE">
	</form>
	<a href="${pageContext.request.contextPath}/emp">add new employee</a>
</body>
</html>