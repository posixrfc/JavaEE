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

	<table>
		<s:if test="#request.empList == null || #request.empList.empty">
			<tr>
				<td>当前没有数据可以显示</td>
			</tr>
		</s:if>
		<s:else>
			<tr>
				<th>编号</th>
				<th>姓名</th>
				<th>部门</th>
				<th>更新</th>
				<th>删除</th>
			</tr>
			<s:iterator value="#request.empList">
				
				<tr>
				
					<td>
						<s:property value="empId"/>
					</td>
					<td>
						<s:property value="empName"/>
					</td>
					<td>
						<s:property value="department.deptName"/>
					</td>
					<td>
						<s:a action="editUI?empId=%{empId}">更新</s:a>
					</td>
					<td>
						<s:a action="removeEmp?empId=%{empId}">删除</s:a>
					</td>
				
				</tr>
				
			</s:iterator>
		</s:else>
	</table>
	
	<br /><br />
	
	<s:a action="addUI">添加员工</s:a>

</body>
</html>