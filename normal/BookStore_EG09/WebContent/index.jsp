<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	由于在index.jsp中显示页面必须得的先经过Servlet，所以不在index.jsp中显示图书列表，
	而是在book_list.jsp中显示，在index.jsp应该做一个转发的操作，将请求转发到Servlet
--%>
<jsp:forward page="/client/BookClientServlet?method=findBook"></jsp:forward>