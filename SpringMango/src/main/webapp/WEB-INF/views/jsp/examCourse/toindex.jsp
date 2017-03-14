<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Mango-Index</title>
<meta name="menu" content="home" />
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		var url = "lists";
		$.get(url, function(data) {
			//alert("数据：" + data);
			$("h2").html(data);
			$("h2").html(data.msg);
		});
	});
</script>
</head>
<body>
	<h1>1234567890</h1>

	<label>保存新增</label>

	<form name="saveAddForm" method="post" action="/save">
		<table>
			<tr>
				<td>用户名:<input type="text" name="name" id="name"></td>
			</tr>
			<!-- <tr>
				<td>密码:<input type="password" name="password" id="addPassword"></td>
			</tr> -->
			<tr>
				<td><input type="submit" value="确定"></td>
			</tr>
		</table>
	</form>
	<h2></h2>
</body>
</html>
