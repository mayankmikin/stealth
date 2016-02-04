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
<script type="text/javascript" src="<c:url value="/static/script/jquery-1.8.2.min.js" />"></script>
<script type="text/javascript">
    var appURL = "<%= "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>";
</script>
<script type="text/javascript" src="<c:url value="/static/script/drawing.js" />"></script>
<script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?key=<spring:message code="GOOGLE_KEY" />&sensor=false&libraries=drawing"></script>
</head>
<body onload="initgeo()">
    <div class="wrap">
        <div class="header"><tiles:insertAttribute name="header-content" />
        </div>
        <div class="intern"><tiles:insertAttribute name="intern-content" />
        </div>
        <div class="push"></div>
    </div>
    <div class="footer"><tiles:insertAttribute name="footer-content" />
    </div>
</body>
</html>
