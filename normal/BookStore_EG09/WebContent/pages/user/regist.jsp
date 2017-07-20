<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>尚硅谷会员注册页面</title>
<%@ include file="/WEB-INF/include/base.jsp" %>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
<script type="text/javascript">
	$(function(){
		/* var reg = /a/;
		var flag = reg.test("abcdefg");
		alert(flag); */
		//var count = 0;
		//点击图片后更新验证码
		$("#code_id").click(function(){
			this.src = "code.jpg?1="+Math.random();
		});
		
		//验证用户名输入的用户名、密码、确认密码、电子邮件、验证码
		//为注册按钮绑定单击响应函数
		$("#sub_btn").click(function(){
			
			//获取用户输入的用户名、密码、确认密码、电子邮件、验证码
			var username = $("[name=username]").val();
			var password = $("[name=password]").val();
			var repwd = $("[name=repwd]").val();
			var email = $("[name=email]").val();
			var code = $("[name=code]").val();
			
			//alert(username+"--"+password+"--"+repwd+"--"+email+"--"+code);
			//验证内容是否符合规则，需要使用正则表达式
			
			//创建正则表达式
			var nameReg = /^[A-Za-z0-9_-]{3,16}$/;
			var pwdReg = /^[a-z0-9_-]{3,18}$/;
			var emailReg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
			
			//验证用户名
			if(!nameReg.test(username)){
				alert("请输入3-16位，包括字母、数字、_、-的用户名！！");
				//没通过验证，不提交表单
				return false;
			}
			
			//验证密码
			if(!pwdReg.test(password)){
				alert("请输入6-18位，包括字母、数字、_、-的密码！！");
				//没通过验证，不提交表单
				return false;
			}
			
			//确认密码
			if(repwd != password){
				alert("两次输入的密码不一致!!");
				//没通过验证，不提交表单
				return false;
			}
			
			//电子邮箱
			if(!emailReg.test(email)){
				alert("请输入正确格式的电子邮箱地址！！");
				//没通过验证，不提交表单
				return false;
			}
			
			//验证码
			if(code==""){
				alert("请输入验证码！！");
				//没通过验证，不提交表单
				return false;
			}
			
			
		});
		
		//为name=username的input绑定change事件
		$("[name=username]").change(function(){
			
			//获取用户输入的用户名
			var username = this.value;
			//设置请求信息
			var url = "${pageContext.request.contextPath}/client/UserServlet";
			//设置请求参数
			var param = {"method":"checkUsername","username":username};
			//发送请求
			$.post(url,param,function(data){
				if(data==0){
					//用户名已存在
					//显示错误消息
					$(".errorMsg").html("用户名已经存在");
					//将按钮变为不可用的状态
					$("#sub_btn").attr("disabled",true);
					
				}else if(data==1){
					//用户名可用
					//取消错误消息
					$(".errorMsg").html("");
					//将按钮变为不可用的状态
					$("#sub_btn").attr("disabled",false);
					
				}
			},"text");
			
		});
		
	});
</script>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
								${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="client/UserServlet?method=regist" method="post">
									<label>用户名称：</label>
									<input value="${param.username }" class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input value="${param.email }" class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 150px;" name="code"/>
									<img id="code_id" alt="" src="code.jpg" style="float: right; margin-right: 40px; width: 90px; height: 45px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<div id="bottom">
			<span>
				尚硅谷书城.Copyright &copy;2015
			</span>
		</div>
</body>
</html>