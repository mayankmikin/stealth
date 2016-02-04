<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 .
 .
 .
 .
 <!-- Begin page content -->
    <div class="container">
      <div class="page-header">
        <h1>Welcome To <strong> ${project_Name}</strong></h1>
      </div>
      <p class="lead" align="center">Tracking Simplified</p>    
    <div class="row">
    Space to load the map 
    </div>
    <div id="map_canvas" style="margin-left:271px; background-color: #FFFFFF; height:475px; z-index:99;">
    </div>
    <script src="http://maps.googleapis.com/maps/api/js"></script>
    
       <script src="/bootstrap/mapjs/map.js"></script>         
  
</div>
