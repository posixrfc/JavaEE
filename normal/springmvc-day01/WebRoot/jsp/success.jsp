<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
	success.jsp<br/>
	成功<br/>
	${requestScope.message}<br/>
	姓名：${requestScope.emp.username}<br/>
	性别：${requestScope.emp.gender}<br/>
	
	入职时间：${requestScope.emp.hiredate}<br/>
	<hr/>
	入职时间：<fmt:formatDate 
				value="${requestScope.emp.hiredate}"
				type="date"
				dateStyle="medium"
			/>
	
	<!-- 
		1)fmt:formatDate 来源于 http://java.sun.com/jsp/jstl/fmt
		2)fmt:formatDate作用是格式化日期的显示，例如：2015年5月10日 星期日
		3)value表示需要格式化的值
		4)type表示显示日期,时间,都显示
		  type=date表示只显示日期
		  type=time表示只显示时间
		  type=both表示日期时间均显示
		5)dateStyle表示显示日期的格式：short/medium/default/long/full
	-->
	
  </body>
</html>
