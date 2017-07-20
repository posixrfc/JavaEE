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
<!-- 作用：生成一个URL地址字符串 -->
<p>●实验①	通过value属性创建URL地址字符串</p>
<s:url value="saveBook"/><br />

<!-- 如果value属性的值是以斜杠开头的，则可以自动附加Web应用的虚拟路径 -->
<s:url value="/saveBook"/><br />
<%-- ${pageContext.request.contextPath } --%>

<p>●实验②	通过action属性创建URL地址字符串</p>
<!-- 将action属性的值作为action的name来生成URL地址 -->
<!-- 前面自动附加Web应用的虚拟路径，后面自动附加请求的扩展名 -->
<s:url action="queryBook"/>

<p>●实验③	通过action属性和namespace属性以及method属性创建URL地址字符串</p>
<s:url action="queryBook" namespace="/banana" method="eat"/>
<!-- /Tag/banana/queryBook!eat.action --><br />

<p>●实验④	创建带请求参数的URL地址字符串</p>
<!-- 1.直接附着到URL地址字符串后面 -->
<!-- /Tag/updateBook?bookId=101 -->
<s:url value="/updateBook?bookId=101"/><br />

<!-- 2.使用param子标签 -->
<!-- /Tag/updateBook?bookId=303 -->
<s:url value="/updateBook">
	<s:param name="bookId" value="303"/>
</s:url>
<br />

<p>●实验⑤	请求参数的值来源于值栈</p>
<!-- /Tag/updateBook?msg=%E5%90%83%E9%A5%B1%E4%BA%86%E5%B0%B1%E6%98%AF%E8%BF%99%E4%B9%88%E5%BC%80%E5%BF%83  -->
<!-- 说明：1.param子标签的value属性可以进行自动的OGNL解析 -->
<!-- 2.可以对非ASCII码字符进行自动的UTF-8编码，便于在网络上传输 -->
<s:url value="/updateBook">
	<s:param name="msg" value="[0].happyMessage"/>
</s:url>
<br />

<p>●实验⑥	以字符串方式指定请求参数的值，但又不让它进行OGNL解析</p>
<s:url value="/updateBook">
	<s:param name="msg" value="'IloveYou'"/>
</s:url>
<br />

<p>●实验⑦	创建包含GET方式传递过来的请求参数的URL地址字符串</p>
<!-- /Tag/updateBook?userName=Tom&password=123456  -->
<s:url value="/updateBook" includeParams="get"/>

<p>●实验⑧	创建包含以任何方式传递过来的请求参数的URL地址字符串</p>
<!-- /Tag/updateBook?age=20&userName=UUUU -->
<s:url value="/updateBook" includeParams="all"/>

<p>●实验⑨	创建不包含contextPath的URL地址字符串</p>
<s:url value="/saveBook" includeContext="false"/><br />

</body>
</html>