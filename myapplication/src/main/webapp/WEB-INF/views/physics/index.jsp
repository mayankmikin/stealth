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
        <h1>Welcome To <strong>STUDY BRO</strong></h1>
      </div>
      <p class="lead" align="center">Physics explained in a very simple manner</p>    
    
<div class="row">
<!-- class 11 -->
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="/bootstrap/img/physics.jpg" alt="physics">
      <div class="caption">
        <h3 align="center">Class XI</h3>
        <p align="center">Check out all new Physics Tutorials</p>
        <p align="center"><a href="<c:url value="/physics/class11index.html" />" class="btn btn-primary" role="button">View Now</a></p>
      </div>
    </div>
  </div>
   <!-- for class 12 -->
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="/bootstrap/img/physics.jpg" alt="physics">
      <div class="caption">
        <h3 align="center">Class XII</h3>
        <p align="center">Check out all new Physics Tutorials</p>
        <p align="center"><a href="<c:url value="/physics/class12index.html" />" class="btn btn-primary" role="button">View Now</a></p>
      </div>
    </div>
  </div>
  <!-- for questions and answers -->
  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <img src="/bootstrap/img/physics.jpg" alt="physics">
      <div class="caption">
        <h3 align="center">Solved Questions</h3>
        <p align="center">Check out all new Physics Tutorials</p>
        <p align="center"><a href="#" class="btn btn-primary" role="button">View Now</a></p>
      </div>
    </div>
  </div>
  
</div>



</div>
