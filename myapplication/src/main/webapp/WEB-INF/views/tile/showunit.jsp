<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="<c:url value="/static/style/global.css" />" />
<link type="text/css" rel="stylesheet" href="<c:url value="/static/style/jquery-ui.css" />" />
<script type="text/javascript" src="<c:url value="/static/script/jquery-1.8.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/script/jquery-ui.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/script/global.js" />"></script>
</head>
<body>
    <div class="wrap">
        <div class="header"><tiles:insertAttribute name="header-content" />
        </div>
        <div class="intern"><tiles:insertAttribute name="intern-content" />
        </div>
        <!-- <div class="push"></div> -->
    </div>
    <div class="footer"><tiles:insertAttribute name="footer-content" />
    </div>
</body>
</html>
