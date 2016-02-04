<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">		
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js">
</script>
 <link rel="stylesheet" href="/bootstrap/css/normalize.css">
        <link rel="stylesheet" href="/bootstrap/css/main.css">
        
        <style type="text/css">
			body {
				font-family: 'Open Sans', sans-serif;
			}
		</style>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<!-- <script src="/bootstrap/js/imagesloaded.js"></script> -->
       <!--  <script src="/bootstrap/js/skrollr.js"></script>
        <script src="/bootstrap/js/_main.js"></script> -->
        <script src="/bootstrap/mapjs/map.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
   
    <div class="container">
       <tiles:insertAttribute name="header-content" />
       </div>
 <div class="container">
        <tiles:insertAttribute name="intern-content" />
      </div>

 <footer class="footer">
      <div class="container">
    <tiles:insertAttribute name="footer-content" />
</div>
    </footer>

	
</body>
</html>