<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'form.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<h1>上传</h1>
<s:fielderror />
<s:actionerror/>
<form action="<c:url value='/upload2.action'/>" method="post" enctype="multipart/form-data">
  用户名：<input type="text" name="username"/><br/>
 <%-- 所有文件表单项，其中name必须是相同的！ --%>
  照　片：<input type="file" name="zhaoPian"/><br/>
  照　片：<input type="file" name="zhaoPian"/><br/>
  照　片：<input type="file" name="zhaoPian"/><br/>
  <input type="submit" value="上传"/>
</form>

  </body>
</html>
