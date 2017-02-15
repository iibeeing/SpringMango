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

	<h1>USER修改</h1>

	<div style="text-align: center">
		<img src="<c:url value='/resources/images/team.jpg'/>" />
	</div>
	<div>
		<label>保存修改</label>
		<form name="saveModifyForm" method="put" action="user/">
			<input type="hidden" name="id" value="1">
			<table>
				<tr>
					<td>用户名:<input type="text" name="name" id="modifyName"></td>
				</tr>
				<tr>
					<td>密码:<input type="password" name="password" id="modifyPassword"></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="登录" style="background-color: pink"> 
						<input type="reset" value="重置" style="background-color: red"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<label>保存修改2</label>
		<form name="saveModifyForm2" method="post" action="user/edit/">
			<input type="hidden" name="id" value="1">
			<table>
				<tr>
					<td>用户名:<input type="text" name="name" id="modifyName2"></td>
				</tr>
				<tr>
					<td>密码:<input type="password" name="password" id="modifyPassword2"></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录" style="background-color: pink"> 
							<input type="reset" value="重置" style="background-color: red"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<label>删除</label>
		<form name="deleteForm" method="delete" action="user/">
			<input type="hidden" name="id" value="1">
		</form>
	</div>
</body>
</html>
