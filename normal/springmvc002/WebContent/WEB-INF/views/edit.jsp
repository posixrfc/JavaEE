<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">
		<form:hidden path="id"/><br>
		<input type="hidden" name="_method" value="PUT"><br>
		email:	 <form:input path="email"/><br>
		gender:<form:radiobuttons path="gender" items="${genders}"/><br>
		department:<form:select path="department.id" items="${departments}"
					itemLabel="departmentName" itemValue="id"></form:select><br>
		<input type="submit" value="updateEmployee">
	</form:form>	
	
	
</body>
</html>