<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="page_nav">
	<!-- 第一种情况总页数小于等于5的 begin是 1， end是totalPage -->
	<!-- 第二种情况当前页面小于等于3的 begin是 1， end是5 -->
	<!-- 第三种情况当前页面大于3的 begin是 pageNumber-2， end是pageNumber+2-->
	<!-- 第四种情况 -->
	<c:choose>
		<c:when test="${page.totalPage <= 5 }">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="${page.totalPage}"></c:set>
		</c:when>
		<c:when test="${page.pageNumber <= 3 }">
			<c:set var="begin" value="1"></c:set>
			<c:set var="end" value="5"></c:set>
		</c:when>
		<c:otherwise>
			<c:set var="begin" value="${page.pageNumber-2 }"></c:set>
			<c:set var="end" value="${page.pageNumber+2 }"></c:set>
		</c:otherwise>
	</c:choose>
	
	<c:if test="${end > page.totalPage }">
		<c:set var="end" value="${page.totalPage }"></c:set>
		<c:set var="begin" value="${page.totalPage-4}"></c:set>
	</c:if>		
	

	<a href="${page.path }&pageNumber=1">首页</a>
	<a href="${page.path }&pageNumber=${page.pageNumber-1 }">上一页</a>
	<c:forEach begin="${begin}" end="${end}" var="index">
		
		<c:choose>
			<c:when test="${index == page.pageNumber }">
				【${index }】
			</c:when>
			<c:otherwise>
				<a href="${page.path }&pageNumber=${index }">${index }</a>
			</c:otherwise>
		</c:choose>				
	</c:forEach>
	<a href="${page.path }&pageNumber=${page.pageNumber+1 }">下一页</a>
	<a href="${page.path }&pageNumber=${page.totalPage}">末页</a>
	共${page.totalPage}页，${page.totalRecord}条记录 到第<input value="${page.pageNumber}" name="pn" id="pn_input"/>页
	<input type="button" value="确定" id="pn_btn">
	<script type="text/javascript">
		$(function(){
			//为按钮绑定一个单击响应函数
			$("#pn_btn").click(function(){
				//获取文本框中页码
				var pageNumber = $("#pn_input").val();
				//获取到页码以后需要跳转页面
				//通过修改window.location属性可使页面跳转
				window.location = "${page.path }&pageNumber="+pageNumber;
				
			});
		});
	</script>
</div>