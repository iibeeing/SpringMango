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
</head>
<body>
	<h1>登录</h1>
	<div style="text-align: center">
		<!-- <img src="/resources/images/team.jpg"/> -->
		<img src="<c:url value='/images/team.jpg'/>" />
	</div>
	<div>
		<form name="saveAddForm" method="post" action="/SpringMango/login">
			<table>
				<tr>
					<td>用户名:<input type="text" name="userName" id="addName"></td>
				</tr>
				<tr>
					<td>密码:<input type="password" name="password" id="addPassword"></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录"
						style="background-color: pink"> <input type="reset"
						value="重置" style="background-color: red"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
