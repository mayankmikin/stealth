<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
      
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<link rel="author" href="https://plus.google.com/u/0/109859280204979591787/about"/>

        <title>${project_name}</title>
        <meta name="description" content="">
       
	

        <link rel="stylesheet" href="/bootstrap/css/normalize.css">
        <link rel="stylesheet" href="/bootstrap/css/main.css">
        
        <style type="text/css">
			body {
				font-family: 'Open Sans', sans-serif;
			}
		</style>
    </head>
    <body class="loading">
       
       	 	<!-- <header>
        	
			<h4>Study Bro: Please scroll down,choose your subject, enter CID and hit "SUBMIT" button </h4>
		</header> -->
		
		
       	<div id="preload">
	       	<img src="/bootstrap/img/bcg_slide-1.jpg">
	       	<img src="/bootstrap/img/bcg_slide-2.jpg">
	       	<img src="/bootstrap/img/bcg_slide-3.jpg">
	       	
       	</div>       	 
	        <section id="slide-1" class="homeSlide">
	        	<div class="bcg">
		        	<div class="hsContainer">
			    		<div class="hsContent">
			    		<h2>Track APP</h2>
				    		<h1>Enter Your CID no. here </h1>
<form id="trackapp-index" name="trackapp-index" method="get" action="<c:url value="/track/index.html" />">
				    		<input type="text" id="t_cid" name="t_cid" placeholder="CID" />
				    		<input type="submit" class="btn btn-primary btn-lg btn-block"/>
			</form>
			    		</div>
		        	</div>
	        	</div>
		    </section>
		    
		    <section id="slide-2" class="homeSlide">
		    	<div class="bcg">
			    	<div class="hsContainer">
			    		<div class="hsContent">
			    			<h2>Asset Management</h2>
				    		<h1>Enter Your CID no. here </h1>
<form id="maths-index" name="maths-index" method="get" action="<c:url value="/maths/index.html" />">
				    		<input type="text" id="m_cid" name="m_cid" placeholder="CID" />
				    		<input type="submit" class="btn btn-primary btn-lg btn-block"/>
				    		</form>
			    		</div>
		        	</div>
		    	</div>
		    </section>
		    
			<section id="slide-3" class="homeSlide">
				<div class="bcg">
			    	<div class="hsContainer">
		    			<div class="hsContent">
		    				<h2>Admin Panel</h2>
				    		<h1>Enter Your CID no. here </h1>
<form id="chemistry-index" name="chemistry-index" method="get" action="<c:url value="/chemistry/index.html" />">
				    		<input type="text" id="c_cid" name="c_cid" placeholder="CID" />
				    		<input type="submit" class="btn btn-primary btn-lg btn-block"/>
				    		</form>
			    		</div>
			    	</div>
			    	
			    </div>
			</section>
			
			<!-- <section id="slide-4" class="homeSlide">
				<div class="bcg">
			    	<div class="hsContainer">
		    			<div class="hsContent">
				    		<h2>and share mine.</h2>
			    		</div>
			    	</div>
			    	
			    </div>
			</section> -->		    
		
        <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.9.1.min.js"><\/script>')</script>
        <script src="/bootstrap/js/imagesloaded.js"></script>
        <script src="/bootstrap/js/skrollr.js"></script>
        <script src="/bootstrap/js/_main.js"></script>
    </body>
</html>
