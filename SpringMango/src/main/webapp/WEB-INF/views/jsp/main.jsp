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
	<h1>您已登录</h1>

	<div style="text-align: center">
		<img src="<c:url value='/resources/images/team.jpg'/>" />
	</div>

	<a href="toadd">点此添加</a>
	<a href="user">用户信息</a>
	<a href="useredit">用户修改</a>
	<a href="user/users">用户信息查询</a>
</body>
</html>
