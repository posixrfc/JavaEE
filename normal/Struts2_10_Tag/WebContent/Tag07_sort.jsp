<%@page import="com.atguigu.tag.comparator.BookComparator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.atguigu.tag.bean.Book"%>
<%@page import="java.util.List"%>
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
<center><p>==========实验==========</p></center>
<!-- sort标签：作用排序 -->
<p>●实验	分别按照bookName、author、price对Book List进行排序</p>
<%
	List<Book> bookList = new ArrayList<Book>();
	//Integer bookId, String bookName, String author, double price
	bookList.add(new Book(null,"CCC","author01",100));
	bookList.add(new Book(null,"EEE","author02",100));
	bookList.add(new Book(null,"AAA","author03",100));
	bookList.add(new Book(null,"BBB","author04",100));
	bookList.add(new Book(null,"DDD","author05",100));
	request.setAttribute("bookList", bookList);
%>
<s:iterator value="#request.bookList">
	<s:property value="bookName"/>:<s:property value="author"/>:<s:property value="price"/><br />
</s:iterator>

<p>========================</p>
<!-- Set set = new TreeSet(new BookComparator()); -->
<% BookComparator bc = new BookComparator(); %>
<% request.setAttribute("bc", bc); %>
<!-- comparator属性用于指定比较器对象 -->
<!-- source属性用于指定被排序的集合 -->
<!-- 默认将排序后的集合对象放入栈顶 -->
<s:sort comparator="#request.bc" source="#request.bookList">
	<s:iterator>
		<s:property value="bookName"/>:<s:property value="author"/>:<s:property value="price"/><br />
	</s:iterator>
</s:sort>

</body>
</html>