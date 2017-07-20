<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<script type="text/javascript">

	$(function(){
		$(".delA").click(function(){
			
			//获取到图书的名字
			var title = $(this).parents("tr").find("td:eq(0)").html();
			
			if(!confirm("确认删除《"+title+"》吗？")){
				return false;
			}
			
		});
		
		$("#clear").click(function(){
			if(!confirm("确认清空购物车吗？？？")){
				return false;
			}
		});
		
		$(".count_input").change(function(){
			//获取用户填写的新的数量
			var count = this.value;
			
			//是否是一个非数字
			//isNaN函数当参数是一个数字时返回false
			//当参数不是一个数字时返回true
			var reg = /^[0-9]+$/;
			if(isNaN(count) || count < 1 || !reg.test(count)){
				//不是一个数字,变为默认值
				this.value = this.defaultValue;
				alert("请输入正确的数字！！");
				return;
			}else {
				//向Servlet发送请求，发送请求就是修改window.loaction的值
				//当IE使用window.location跳转地址时，他是不会发送referer头
				/* window.location = "${pageContext.request.contextPath}/client/CartServlet?"+
						"method=updateCount&count="+count+"&bookId="+this.id; */
						
				//当填写的数量通过验证时，发送AJAX请求修改购物商品的数量
				var url = "${pageContext.request.contextPath}/client/CartServlet";
				var param = {
								"method":"updateCount",
								"count":count,
								"bookId":this.id
				};
				
				//获取图书小计金额的单元格
				var $td = $(this).parents("tr").find("td:eq(3)");
				
				//发送请求
				$.post(url,param,function(data){
					//修改页面中的信息
					//修改商品总数
					$("#t_count").html(data.totalCount);
					//修改商品总金额
					$("#t_amount").html(data.totalAmount);
					//修改图书金额
					$td.html(data.amount);
					
				},"json");
			}
			
		});
	});

</script>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
			<span class="wel_word">购物车</span>
			<%@ include file="/WEB-INF/include/user-info.jsp" %>
	</div>
	
	<div id="main">
		
		<c:choose>
			<c:when test="${empty cart || empty cart.map}">
				<br /><br /><br /><br /><br /><br /><br />
				<h1 align="center">您还没有购物，快点买吧！</h1>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>商品名称</td>
						<td>数量</td>
						<td>单价</td>
						<td>金额</td>
						<td>操作</td>
					</tr>	
					<c:forEach items="${cart.cartItems }" var="cartItem">
						<tr>
							<td>${cartItem.book.title }</td>
							<td><input id="${cartItem.book.id }" class="count_input" type="text" value="${cartItem.count }" style="width: 30px;text-align: center"> </td>
							<td>${cartItem.book.price }</td>
							<td>${cartItem.amount }</td>
							<td><a class="delA" href="client/CartServlet?method=delCartItem&bookId=${cartItem.book.id}">删除</a></td>
						</tr>	
					</c:forEach>	
					
					
					
				</table>
				
				<div class="cart_info">
					<span class="cart_span">购物车中共有<span id="t_count" class="b_count">${cart.totalCount }</span>件商品</span>
					<span class="cart_span">总金额<span class="b_price" id="t_amount">${cart.totalAmount }</span>元</span>
					<span class="cart_span"><a id="clear" href="client/CartServlet?method=clear">清空购物车</a></span>
					<span class="cart_span"><a href="client/OrderClientServlet?method=checkout">去结账</a></span>
				</div>
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