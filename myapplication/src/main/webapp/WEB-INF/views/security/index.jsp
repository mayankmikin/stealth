<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>STUDY BRO Login</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="/bootstrap/css/styles.css" rel="stylesheet">
	</head>
	<body>
	<table>
	<thead>
	</thead>
	<tbody>
	<tr>
	<td>
	inside securty 
	<button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#loginModal">Login</button>
	</td>
	<td>
	<a href="<c:url value="/user/register.html" />">Register</a>
	</td>	
	</tr>	
	</tbody>
	</table>
	</body>
</html>