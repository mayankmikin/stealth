<!DOCTYPE html>
<html>
  <head>
    <title>Device Properties Example</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="cordova.js"></script>
 <script>
 $(document).ready(function() {
	   /*  $.ajax({
	        url: "http://rest-service.guides.spring.io/greeting"
	    }).then(function(data) {
	       $('.greeting-id').append(data.id);
	       $('.greeting-content').append(data.content);
	    }); */
	    
	});
 
 
 function calljson() {

<%-- 	 var appURL = "<%= "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>";
 --%>	
 var appURL = "<%= "http://localhost:8080" %>";
	 var user=$('#username').val();
	 	var pass=$('#password').val();
	    var ajaxurl = appURL + "/rest/login.html?username="+user+"password="+pass;
	    
	    $.support.cors = true;
	    $.ajax({
	        type: "GET",
	        url: ajaxurl,
	        dataType: "json",
	        error: function (err) {
	            alert("Refresh Again");
	        },
	        success: function (data) {
	            jsondata = data;
	            console.log(data);
	        }
	    });
 }
    </script>
  </head>
  <body>
    <div class="row">
    <div>
 
            <div class="form-group">
              <input id="username" name="username" type="text" placeholder="Email or username">
             
            </div>
            <div >       
              <input id="password" name="password" type="password"  placeholder="Password">
            </div>
            <div class="form-group">
             <!--  <button class="btn btn-primary btn-lg btn-block" type="submit">Sign In</button> -->
             <input type="submit" class="btn btn-primary btn-lg btn-block" onsubmit="calljson()"/> 
              
            </div>
 
  </div>
</div>

  </body>
</html>
