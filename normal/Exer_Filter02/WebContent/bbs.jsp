<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>欢迎光临论坛</h1>
<p style="color: red">${info}</p>
<form action="${pageContext.request.contextPath }/BbsServlet" method="post">
	<textarea rows="10" cols="35" name="info"></textarea><br /><br />
	<input type="submit" value="发帖" />
</form>
</body>
</html>