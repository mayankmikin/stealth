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
<script type="text/javascript" src="<c:url value="/static/script/global.js" />"></script>
</head>
<body>
    <div class="wrap">
        <div class="header"><tiles:insertAttribute name="header-content" />
        </div>
        <div class="intern">
            <div class="pageheader"><a href="#">Home</a> &raquo; <span style="font-size:0.9em;">Transport Dashboard</span></div>
            <div class="pageheader">
                <a href="<c:url value="<%= session.getAttribute(\"HOME_URL\").toString() %>" />"><spring:message code="HOME" /></a> &raquo; 
                <span class="lbl03"><spring:message code="ACCOUNT_LINK" /></span>
            </div>
            <div style="text-align: left; min-height: 100%; height: auto !important; height: 100%; z-index: 9;">
                <div style="float: left; width: 100%">
                    <div style="margin-left: 250px; background-color: #FFFFFF; min-height: 650px; height: auto !important; height: 100%; z-index: 99;">
                        <div style="padding:5px 0px;">A</div>
                    </div>
                </div>
                <div style="float: left; background-color: #FCFCFC; padding:0px 10px; margin-left:-100%; width: 220px; min-height: 650px; height: auto !important; height: 100%;">
                    <div style="padding:5px 0px;">Navbar</div>
                </div>
            </div>
        </div>
        <div class="push"></div>
    </div>
    <div class="footer"><tiles:insertAttribute name="footer-content" />
    </div>
</body>
</html>