<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">我的订单</span>
			<%@ include file="/WEB-INF/include/user-info.jsp" %>
	</div>
	
	<div id="main">
		
		<c:choose>
			<c:when test="${empty list }">
				<h1>当前用户还没有产生订单！</h1>
			</c:when>
			<c:otherwise>
				<table style="width: 80%">
					<c:forEach items="${list }" var="order">
						<tr style="background-color: #bfa;">
							<td>订单号</td>
							<td>日期</td>
							<td>数量</td>
							<td>金额</td>
							<td>状态</td>
						</tr>	
						<tr>
							<td>${order.id }</td>
							<td>
								<!-- fmt:formatDate标签 用来格式化时间，value是要格式化的时间，pattern是时间的格式-->
								<fmt:formatDate value="${order.orderTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
							</td>
							<td>${order.totalCount }</td>
							<td>${order.totalAmount }</td>
							<td>
								<c:choose>
									<c:when test="${order.state==0 }">
										未发货
									</c:when>
									<c:when test="${order.state==1 }">
										<a href="client/OrderClientServlet?method=takeBook&orderId=${order.id}">确认收货</a>
									</c:when>
									<c:when test="${order.state==2 }">
										<span style="color: green">交易完成</span>
									</c:when>
								</c:choose>
							</td>
						</tr>	
						<tr>
							<td colspan="5">
								<table style="margin: 0">
									<tr>
										<td>图片</td>
										<td>书名</td>
										<td>作者</td>
										<td>单价</td>
										<td>数量</td>
										<td>合计</td>
									</tr>
									<c:forEach items="${order.orderItems }" var="item">
										<tr>
											<td><img src="${pageContext.request.contextPath }${item.book.imgPath}"> </td>
											<td>${item.book.title}</td>
											<td>${item.book.author}</td>
											<td>${item.book.price}</td>
											<td>${item.count}</td>
											<td>${item.amount}</td>
										</tr>
									</c:forEach>
								</table>
							</td>
						</tr>
					</c:forEach>	
				</table>
			</c:otherwise>
		</c:choose>
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>