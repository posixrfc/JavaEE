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

	<s:form action="saveEmp">
	
		<s:textfield name="empName" label="员工姓名"/>
		
		<!-- 下拉列表的作用是是注入deptId值 -->
		<!-- 1.保存员工信息时要使用模型驱动，栈顶是Employee对象 -->
		<!-- 2.Employee对象的部门属性名：department -->
		<!-- 3.使用department.deptId方式给栈顶对象的级联属性赋值 -->
		<s:select name="department.deptId" 
				  list="#request.deptList" 
				  listKey="deptId" 
				  listValue="deptName"/>
		
		<s:submit value="保存"/>
	
	</s:form>

</body>
</html>