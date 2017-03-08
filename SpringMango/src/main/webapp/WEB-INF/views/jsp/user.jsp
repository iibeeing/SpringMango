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
		$("#jsdelete").click(function() {
			//$(this).hide();
			var saveData = {
				"id" : "1"
			};
			/* $.ajax({
				type : "DELETE",
				url : "user/",
				data : JSON.stringify(saveData),
				contentType : "application/json",
				dataType : "json",
				success : function(data) {
					alert(data);
				}
			});  */
			$.ajax({
				type : "post",
				url : "user/2",
				data : {
					id : "1",_method:"delete"
				},
				contentType : "application/x-www-form-urlencoded",
				//contentType : "application/json",
				dataType : "json",
				success : function(data) {
					alert(data);
				}
			});
		});
	});
</script>
</head>
<body>

	<h1>USER(${user.principal})</h1>
	<div style="text-align: center">
		<img src="<c:url value='/resources/images/team.jpg'/>" />
	</div>
	<div>
	
	<a href="student/toindex">点此进入学生信息页面</a>
	
	
		<label>保存新增</label>
		
		<form name="saveAddForm" method="post" action="user/">
			<table>
				<tr>
					<td>用户名:<input type="text" name="username" id="addName"></td>
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
	<div>
		<label>保存修改</label>
		<form name="saveModifyForm" method="post" action="user/6">
			<input type="hidden" name="_method" value="put">
			<table>
				<tr>
					<td>用户名:<input type="text" name="name" id="modifyName">
									  <input type="hidden" name="id" value="5">
					</td>
				</tr>
				<tr>
					<td>密码:<input type="password" name="password" id="modifyPassword"></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录"
						style="background-color: pink"> <input type="reset"
						value="重置" style="background-color: red"></td>
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
					<td>密码:<input type="password" name="password"
						id="modifyPassword"2></td>
				</tr>
				<tr>
					<td><input type="submit" value="登录"
						style="background-color: pink"> <input type="reset"
						value="重置" style="background-color: red"></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<label>删除</label>
		<form name="deleteForm" method="post" action="user/1">
			<input type="hidden" name="_method" value="DELETE"> 
			<!-- <input type="hidden" name="id" value="2">  -->
			<tr>
				<td><input type="submit" value="DELETE"></td>
			</tr>
		</form>
	</div>
	<div>
		<button id="jsdelete">JS删除00</button>
	</div>
</body>
</html>
