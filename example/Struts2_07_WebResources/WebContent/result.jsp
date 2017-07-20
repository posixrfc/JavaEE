<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<center>

	Application域数据：${applicationScope.attrName }<br /><br />
	Session域数据：${sessionScope.attrName }<br /><br />
	
	尝试获取subject请求参数：${param.subject }<br />

	Request域数据：${requestScope.attrName }<br /><br />
	</center>
</body>
</html>