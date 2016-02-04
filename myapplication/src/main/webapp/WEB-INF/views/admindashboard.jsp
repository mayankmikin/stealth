<%@ page language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
      
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    </head>
    <body>
      <div class="panel panel-default">
  <div class="panel-body">
     <div class="container">
     <div class="row">
    <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
 <form action="<c:url value="/admin/index.html" />" method="post">
            <div class="form-group">
              <input id="key" name="key" type="text" class="form-control input-lg" placeholder="Type this week KEY">
             
            </div>
       
            <div class="form-group">
             
             <input type="submit" class="btn btn-primary btn-lg btn-block"/>          
           
            </div>
     		</form>  
	</div>
</div>
     </div>
  </div>
</div> 
      
    </body>
</html>
