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

	<s:debug />

	<center>
	
		<s:form action="/test06">
			
			<!-- 23011119920102335X -->
			<s:textfield name="idcard" label="身份证号" />
			
			<s:submit value="提交" />
		
		</s:form>
		
	</center>

</body>
</html>