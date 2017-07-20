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
<center><p>==========实验==========</p></center>
<!-- a标签：作用是生成超链接 -->
<p>●实验①	在value属性中使用“/”开头的绝对路径</p>
<s:a value="saveBook">保存图书</s:a><br />
<s:a value="/saveBook">保存图书</s:a><br />

<p>●实验②	附加普通字符串请求参数</p>
<s:a value="/saveBook?bookName=GoodBook">保存图书</s:a><br />

<p>●实验③	附加从值栈中取出的值作为请求参数</p>
<!-- 强制OGNL解析 -->
<% request.setAttribute("myParam", "myParamValue"); %>
<s:a value="/saveBook?bookName=%{#request.myParam}">保存图书</s:a><br />

</body>
</html>