<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="../includes/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Mango-Index</title>
<meta name="menu" content="home" />
</head>

<body>

	<h1>ADD</h1>

	<div style="text-align: center">
		<img src="<c:url value='/resources/images/team.jpg'/>" />
	</div>

	<form name="loginForm" method="post" action="add">
		<table>
			<tr>
				<td>用户名:<input type="text" name="name" id="userName"></td>
			</tr>
			<tr>
				<td>密码:<input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="登录" style="background-color: pink"> 
				<input type="reset" value="重置" style="background-color: red"></td>
			</tr>
		</table>
	</form>
</body>
</html>
