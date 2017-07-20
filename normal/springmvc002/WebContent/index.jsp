<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/jquery-1.9.1.min.js"></script>

<script type="text/javascript">
	$(function(){
		$("#testJson").click(function(){
			var url = $(this).attr("href");
			var args = {};
			$.post(url,args,function(data){
				for(var i=0;i<data.length;i++){
					var id = data[i].id;
					var lastName = data[i].email;
					alert(id+" ; "+lastName);
				}
			})
			return false;
		})
	})
</script>

<body>
Restful style crud begin.<a href="${pageContext.request.contextPath}/testInit">testInit</a>
<br>
<hr>
<a href="${pageContext.request.contextPath}/emps">show All Employees</a>
<hr>
<a id="testJson" href="${pageContext.request.contextPath}/testJson">testJson</a>
<hr>
<form action="${pageContext.request.contextPath}/testRequestBody" method="post" enctype="multipart/form-data">
	file:<input type="file" name="file"/><br>
	password:<input type="password" name="password"/><br>
	note:<input type="text" name="note"/><br>
	<input type="submit" value="testRequestBody_commit">
</form>
<hr>
<a href="${pageContext.request.contextPath}/testResponseEntity">testResponseEntity</a>
<hr>
<a href="${pageContext.request.contextPath}/i18n">i18n</a>
<hr>
<a href="${pageContext.request.contextPath}/i18n2">i18n2</a>
<hr>
<a href="${pageContext.request.contextPath}/i18n3?locale=zh_CN">中文</a>
<a href="${pageContext.request.contextPath}/i18n3?locale=en_US">english</a>
<hr>
文件上传：<br>
<form action="${pageContext.request.contextPath}/testUpload" method="post" enctype="multipart/form-data">
	file1:<input type="file" name="file"/><br>
	file2:<input type="file" name="file"/><br>
	file3:<input type="file" name="file"/><br>
	<input type="submit" value="testUpload_commit">
</form>
<hr>
以下内容是异常处理部分：<br>
testHandlerExceptionResolver:<a href="${pageContext.request.contextPath}/testHandlerExceptionResolver?age=0">testHandlerExceptionResolver</a>
<hr>
testResponseStatusExceptionResolver:<a href="${pageContext.request.contextPath}/testResponseStatusExceptionResolver?userName=li5">testResponseStatusExceptionResolver</a>
<hr>
testSimpleMappingExceptionResolver:<a href="${pageContext.request.contextPath}/testSimpleMappingExceptionResolver?idx=5">testSimpleMappingExceptionResolver</a>
</body>
</html>