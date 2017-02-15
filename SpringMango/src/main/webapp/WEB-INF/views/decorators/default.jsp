<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=UTF-8"%>
<%@ include file="../includes/taglibs.jsp"%>
<!doctype html>
<html>
<head>
	<title><sitemesh:write property='title' /></title>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK"/>
	<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/style.css'/>" />
	<sitemesh:write property='head' />
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
</head>		
    <div id="page">
        <div id="header">
            <jsp:include page="../includes/header.jsp"/>
        </div>
        <div id="content">
        	<ul id="tabmenu">
        		<li><a href="<c:url value='/'/>" class="current">首页</a></li>
        	</ul>
			<div id="tabcontent">
				<sitemesh:write property='body'></sitemesh:write>
			</div>
        </div>
        <div id="footer">
            <jsp:include page="../includes/footer.jsp"/>
        </div>
    </div>
</body>
</html>
