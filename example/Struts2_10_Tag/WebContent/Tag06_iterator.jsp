<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
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
<p>●实验①	遍历List集合</p>
<% 
	List<String> strList = Arrays.asList("AAA","KKK","QQQ","JJJ");
	request.setAttribute("strList", strList);
%>
<!-- value属性：指定要遍历的集合对象 -->
<!-- iterator标签会自动将遍历得到的每一个对象临时压入栈顶 -->
<s:iterator value="#request.strList">
	<s:property/><br />
</s:iterator>
<br />
<p>========================</p>
<!-- 如果没有指定value属性，会自动将栈顶对象作为要遍历的集合 -->
<s:push value="#request.strList">
	<s:iterator>
		<s:property/><br />
	</s:iterator>
</s:push>
<br />
<p>========================</p>
<!-- 以var属性指定的字符串作为键，将遍历得到的对象存入Map栈 -->
<s:iterator value="#request.strList" var="myStr">
	<s:property value="#myStr"/>:<s:property/><br />
</s:iterator>

<s:debug/>

<p>●实验②	遍历Map集合</p>
<%
	Map<String,String> dataMap = new HashMap<String,String>();
	dataMap.put("key01", "val01");
	dataMap.put("key02", "val02");
	dataMap.put("key03", "val03");
	dataMap.put("key04", "val04");
	dataMap.put("key05", "val05");
	request.setAttribute("dataMap", dataMap);
%>
<!-- 遍历Map得到的每一个元素也是Entry类型的。 -->
<s:iterator value="#request.dataMap">
	<s:property value="class.name"/>:<s:property value="key"/>:<s:property value="value"/><br />
</s:iterator>

<p>●实验③	在偶数个元素的后面加@</p>
<!-- status对象的类型：org.apache.struts2.views.jsp.IteratorStatus -->
<s:iterator value="#request.strList" status="myStatus">
	<s:property/>
	<s:if test="#attr.myStatus.even">@</s:if>
	<br />
</s:iterator>

</body>
</html>