<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>struts2+spring+jdbc+oracle</title>
  </head>
  <body>
	<form action="${pageContext.request.contextPath}/register.action" method="POST">
		<table border="2" align="center">
			<tr>
				<th>姓名</th>
				<td><input type="text" name="emp.username" value="哈哈"/></td>
			</tr>
			<tr>
				<th>薪水</th>
				<td><input type="text" name="emp.salary" value="5000"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="注册"/>
				</td>
			</tr>
		</table>
	</form>
  </body>
</html>





