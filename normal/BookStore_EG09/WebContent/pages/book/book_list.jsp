<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>书城首页</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">
	$(function(){
		//为addCart绑定单击响应函数
		$(".addCart").click(function(){
			//该发送ajax请求，添加图书到购物车
			//client/CartServlet?method=add2Cart&bookId=${book.id}
			var url = "${pageContext.request.contextPath}/client/CartServlet";
			var param = {
							"method":"add2Cart",
							"bookId":this.id
						};
			$.post(url,param,function(data){
				
				//设置显示购物车中的商品总数
				$("#cartInfo").html('您的购物车中有 <span style="color: red">'+data.count+'</span> 件商品');
				//显示刚刚添加的图书
				$("#title_info").html('您刚刚将<span style="color: red">《'+data.title+'》</span>加入到了购物车中');
				
			},"json");
		});
	});
</script>
</head>
<body>
	 
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">网上书城</span>
			<%@ include file="/WEB-INF/include/user-info.jsp" %>
	</div>
	
	<div id="main">
		<div id="book">
			<div class="book_cond">
				<!-- 当我使用get请求时，表单中的请求参数将会覆盖掉action中的请求参数 -->
				<form action="client/BookClientServlet" method="get">
					<input type="hidden" name="method" value="findBookByPrice" />
					价格：<input type="text" name="min" value="${param.min }"> 元 - <input value="${param.max }" type="text" name="max"> 元 
					<input type="submit" value="查询" />
				</form>
			</div>
			<div style="text-align: center">
				<c:choose>
					<c:when test="${empty cart || empty cart.cartItems }">
						<span id="cartInfo">您的购物车中没有商品</span>
					</c:when>
					<c:otherwise>
						<span id="cartInfo">您的购物车中有 <span style="color: red">${cart.totalCount }</span> 件商品</span>
					</c:otherwise>
				</c:choose>
				
				<div id="title_info">
					<c:if test="${!empty title }">
						您刚刚将<span style="color: red">《${title }》</span>加入到了购物车中
					</c:if>
				</div>
			</div>
			<c:choose>
				<c:when test="${empty page.data }">
					<h1>当前数据库中没有图书</h1>
				</c:when>
				<c:otherwise>
					<c:forEach items="${page.data }" var="book">
						<div class="b_list">
							<div class="img_div">
								<img class="book_img" alt="" src="${pageContext.request.contextPath}${book.imgPath }" />
							</div>
							<div class="book_info">
								<div class="book_name">
									<span class="sp1">书名:</span>
									<span class="sp2">${book.title }</span>
								</div>
								<div class="book_author">
									<span class="sp1">作者:</span>
									<span class="sp2">${book.author }</span>
								</div>
								<div class="book_price">
									<span class="sp1">价格:</span>
									<span class="sp2">￥${book.price }</span>
								</div>
								<div class="book_sales">
									<span class="sp1">销量:</span>
									<span class="sp2">${book.sales }</span>
								</div>
								<div class="book_amount">
									<span class="sp1">库存:</span>
									<span class="sp2">${book.stock }</span>
								</div>
								<div class="book_add">
								<%-- 	<a style="color: blue" href="client/CartServlet?method=add2Cart&bookId=${book.id}">加入购物车</a> --%>
									<button id="${book.id}" class="addCart">加入购物车</button>
								</div>
							</div>
						</div>
					</c:forEach>
				</c:otherwise>
			</c:choose>
			
			
			
			
		</div>
		
		<%@ include file="/WEB-INF/include/page.jsp" %>
	
	</div>
	
	<div id="bottom">
		<span>
			尚硅谷书城.Copyright &copy;2015
		</span>
	</div>
</body>
</html>