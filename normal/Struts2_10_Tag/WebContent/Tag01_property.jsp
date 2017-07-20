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
	<center><p>==========实验==========</p></center>
	<!-- 作用：执行OGNL表达式 -->
<p>●实验①	读取对象栈中对象的属性值</p>
<s:property value="[0].happyMessage"/><br />
<s:property value="happyMessage"/><br />

<p>●实验②	访问Map栈，读取Session域中对象的属性值</p>
<% session.setAttribute("sessionName", "sessoinValue"); %>
<s:property value="#session.sessionName"/><br />

<p>●实验③	访问Map栈，通过attr读取域对象中的属性值</p>
<%-- pageContext.setAttribute("attrName", "attrPageValue"); --%>
<%-- request.setAttribute("attrName", "attrReqValue"); --%>
<% session.setAttribute("attrName", "attrSessionValue"); %>
<% application.setAttribute("attrName", "attrAppValue"); %>
<s:property value="#attr.attrName"/><br />

<p>●实验④	访问Map栈，读取请求参数的值</p>
<s:property value="#parameters.userName"/><br /><!-- Map<String,String[]> -->
<s:property value="#parameters.userName[0]"/><br />

<p>●实验⑤	不指定value属性，返回栈顶对象</p>
<s:property/>

<p>●实验⑥	通过value属性值找不到数据，使用default属性的值</p>
<s:property value="notExists" default="执行OGNL表达式没有结果时的默认值"/>

</body>
</html>