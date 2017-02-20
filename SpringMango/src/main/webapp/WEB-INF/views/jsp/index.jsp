<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="../includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Mango-Index</title>
<meta name="menu" content="home" />
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#login").click(function() {
			//获取用户名称
			var userName = encodeURI($("#userName").val());
			//获取输入密码
			var password = encodeURI($("#password").val());
			$.ajax({
				type : "post",
				url : "login/login",
				dataType : "json",
				data : {
					userName : userName,
					password : password
				},
				success : function(strValue) {
					if (strValue.statusCode == 200) {
						alert("登录成功");
						window.location.href = "user";
					}
				}
			});
		});
	});
</script>
</head>

<body>

	<h1>请登录</h1>

	<div style="text-align: center">
		<img src="<c:url value='/resources/images/team.jpg'/>" />
	</div>

	<a href="toadd">点此添加</a>
	<a href="user">用户信息</a>
	<a href="useredit">用户修改</a>
	<a href="user/users">用户信息查询</a>
	<form name="loginForm" method="post" action="login/login">
		<table>
			<tr>
				<td>用户名:<input type="text" name="userName" id="userName"></td>
			</tr>
			<tr>
				<td>密码:<input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td>
					<!-- <input type="submit" value="登录" style="background-color: pink"> 
				<input type="reset" value="重置" style="background-color: red"></td> -->
					<input id="login" type="button" value="登录"
					style="background-color: pink">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
