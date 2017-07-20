<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>演示二个控制器</title>
  </head>
  <body>
	
	<a href="${pageContext.request.contextPath}/index.action" style="text-decoration:none">首页</a> 
	
	<hr/>
	
	<form action="${pageContext.request.contextPath}/add.action" method="POST">
		<table border="2" align="center">
			<tr>
				<th>姓名</th>
				<td><input type="text" name="username"/></td>				
			</tr>
			<tr>
				<th>性别</th>
				<td>
					<input type="radio" name="gender" value="男"/>男
					<input type="radio" name="gender" value="女" checked/>女
				</td>				
			</tr>
			<tr>
				<th>入职时间</th>
				<td>
					<input type="text" name="hiredate" value="2015-5-10"/>
				</td>				
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="提交"/>
				</td>
			</tr>
		</table>
	</form>
	
  </body>
</html>





