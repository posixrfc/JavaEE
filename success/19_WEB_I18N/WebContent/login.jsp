<%@page import="java.util.Date" import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${!empty param.locale }">
	<fmt:setLocale value="${param.locale}"/>
	kk:${param.locale } <br/>
</c:if>

<fmt:setBundle basename="i18n"/>

<h1><fmt:message key="login" /></h1>
<h3>
	欢迎XXX光临我们的网站，今天的日期是
	<fmt:formatDate value="<%=new Date() %>" dateStyle="FULL" type="both"/>
</h3>
<h2>
	<fmt:message key="info" />
	<span style="color: red">
	<fmt:formatDate value="<%=new Date() %>" dateStyle="FULL" type="both"/>
	</span>
</h2>

<h2>
	<fmt:message key="info">
		<fmt:param>大师兄</fmt:param>
		<fmt:param>
		<fmt:formatDate value="<%=new Date() %>" dateStyle="FULL" type="both"/>
		</fmt:param>
	</fmt:message> 
</h2>

<form action="">
	<fmt:message key="username" /> <input type="text" /> <br /><br />
	<fmt:message key="password" /> <input type="password" /> <br /><br />
	<input type="submit" value="<fmt:message key="login" />" />
</form>

<a href="${pageContext.request.contextPath }/login.jsp?locale=zh_CN">中文</a> | <a href="${pageContext.request.contextPath }/login.jsp?locale=en_US">ENGLISH</a>
</body>
</html>