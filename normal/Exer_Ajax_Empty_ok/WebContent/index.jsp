<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>三级联动</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/script/jquery-1.7.2.js"></script>
<script type="text/javascript">
	$(function(){
		
		//1.页面已加载就读取省份的信息
		var url = "${pageContext.request.contextPath }/ProvinceServlet";
		var type = "json";
		//2.发送请求
		$.post(url,function(data){
			//遍历对象数组
			for(var i=0 ; i<data.length ; i++){
				
				//获取省份的id和名字
				var name = data[i].name;
				var id = data[i].id;
				//创建option
				$("<option value='"+id+"'>"+name+"</option>").appendTo("[name=province]");
			}
			
		},type);
		
		//给省份的下拉列表绑定响应函数
		$("[name=province]").change(function(){
			
			//将已有信息清空
			$("[name=city]").children(":gt(0)").remove();
			//清空区县信息
			$("[name=district]").children(":gt(0)").remove();
			
			//发送请求加载城市信息
			var pid = this.value;
			//设置请求地址
			var url = "${pageContext.request.contextPath }/CityServlet";
			//设置请求参数
			var param = {"pid":pid};
			//发送请求
			$.post(url , param , function(data){
				
				//遍历
				for(var i=0 ; i<data.length ; i++){
					//获取城市的id和name
					var name = data[i].name;
					var id = data[i].id;
					//创建option
					$("<option value='"+id+"'>"+name+"</option>").appendTo("[name=city]");
				}
				
				
			},"json");
			
		});
		
		//给城市的下拉列表绑定响应函数
		$("[name=city]").change(function(){
			
			//删除之前的信息
			$("[name=district]").children(":gt(0)").remove();
			
			//获取城市id
			var cid = this.value;
			//设置请求地址
			var url = "${pageContext.request.contextPath }/DistrictServlet";
			//设置请求参数
			var param = {"cid":cid};
			//发送请求
			$.post(url , param ,function(data){
				//遍历信息
				for(var i=0 ; i<data.length ; i++){
					//获取区县的id和name
					var name = data[i].name;
					var id = data[i].id;
					//创建option
					$("<option value='"+id+"'>"+name+"</option>").appendTo("[name=district]");
				}
				
			} , "JSON");
		});
	});
</script>
</head>
<body>
<select name="province">
	<option>请选择省...</option>
</select>
<select name="city">
	<option>请选择市...</option>
</select>
<select name="district">
	<option>请选择区县...</option>
</select>
</body>
</html>