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

	<s:debug/>

	<center>
		<s:property value="[0].exception"/>
		<s:form action="/daoDanAction">
			<s:textfield name="num" label="10除以"></s:textfield>
			<s:submit value="前往捣蛋鬼Action"></s:submit>
		</s:form>
		<s:form action="/daoMeiAction">
			<s:textfield name="num" label="10除以"></s:textfield>
			<s:submit value="前往倒霉鬼Action"></s:submit>
		</s:form>
	</center>

</body>
</html>