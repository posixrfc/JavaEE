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
<!-- push标签作用：将数据“临时”的压入对象栈栈顶 -->
<!-- 临时：在标签执行开始时压入，在标签结束时还会弹出 -->
<p>●实验①	将一个普通字符串压入值栈栈顶，并验证</p>
<s:push value="'CommonStr'">
	<s:property/><br/>
</s:push>
--<s:property/>--<br />

<p>●实验②	将一个从值栈中取出的对象压入值栈栈顶，并验证</p>
<s:push value="happyMessage">
	<s:property/><br/>
</s:push>

</body>
</html>