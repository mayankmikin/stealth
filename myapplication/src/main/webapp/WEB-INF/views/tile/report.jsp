<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="<c:url value="/static/style/global.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/static/style/jquery-ui.css" />" />
 <!--  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css"> -->
<link rel="stylesheet" type="text/css" href="<c:url value="/static/style/main.css" />" />
<script type="text/javascript" src="<c:url value="/static/script/jquery-1.8.2.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/script/jquery-ui.min.js" />"></script>

<script type="text/javascript" src="<c:url value="/static/script/jquery-ui-timepicker-addon.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/script/jquery.autocomplete.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/script/jquery.searchabledropdown-1.0.8.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/script/jquery-ui-1.9.2.custom.min.js" />"></script>
<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<script type="text/javascript" src="<c:url value="/static/script/global.js" />"></script>
<style>
  .ui-autocomplete-loading {
    background: white url("images/ui-anim_basic_16x16.gif") right center no-repeat;
  }
  #city { width: 25em; }
  </style>
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