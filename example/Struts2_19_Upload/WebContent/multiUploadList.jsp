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
	
	<s:actionerror/>
	
	<!-- 在使用相同的name属性值进行多文件上传时，即使仅仅一个上传框出错也会在每一个长传框位置显示错误消息 -->
	<!-- 要解决这个问题可以将主题设置为simple，并使用s:fielderror标签显示错误消息 -->
	<s:fielderror name="logo"/>

	<s:form action="/multiListUpload" enctype="multipart/form-data" theme="simple">
	
		<!-- name属性值设置为相同 -->
		图标1<s:file name="logo" label="图标1"/><br />
		图标2<s:file name="logo" label="图标2"/><br />
		图标3<s:file name="logo" label="图标3"/><br />
		<s:submit value="上传"/>
	
	</s:form>

</body>
</html>