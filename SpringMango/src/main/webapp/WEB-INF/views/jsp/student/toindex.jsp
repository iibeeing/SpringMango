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
		alert("ab");
		var url = "list";
 		$.get(url, function(data) {
			alert("数据：" + data);
		});
	});
</script>
</head>
<body>
	<h1>1234567890</h1>
</body>
</html>
