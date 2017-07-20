<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	.centerText {text-align: center;}
	.textStyle {border: 1px solid black;}
	.btnStyle {border: 1px solid black;width:150px;}
	.btnStyle:hover {border: 1px solid black;width:150px;background-color: white;}
	.tableStyle {border: 1px solid black;border-collapse: collapse;margin: 50px auto 0px auto;}
	.tableStyle td {border: 1px solid black;padding: 5px;}
</style>
</head>
<body>
	<h3>当前在线人数是：${(applicationScope.onlineNum == null) ? 0 : applicationScope.onlineNum }</h3>

	<% 
		Object user = session.getAttribute("loginUser");
		if(user == null) {
	%>
			<form action="${pageContext.request.contextPath }/User_login.action" method="post">
				<table class="tableStyle">
					<tr>
						<td colspan="2" class="centerText">用户登录</td>
					</tr>
					<tr>
						<td>用户名</td><td><input class="textStyle" type="text" name="userName" /></td>
					</tr>
					<tr>
						<td>密码</td><td><input class="textStyle" type="password" name="userpwd" /></td>
					</tr>
					<tr>
						<td colspan="2" class="centerText"><input class="btnStyle" type="submit" value="登录" /></td>
					</tr>
				</table>
			</form>
	<%
		}else{
	%>
			欢迎您，<%=user %> <a href="${pageContext.request.contextPath }/User_logout.action">退出</a>
	<%
		}
	%>


</body>
</html>