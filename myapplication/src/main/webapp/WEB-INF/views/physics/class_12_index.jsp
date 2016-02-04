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
        <h1><strong>Class XI</strong></h1>
      </div>
      <p class="lead" align="center">Physics explained in a very simple manner</p> 
      <div class="panel-group">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" href="#collapse1">Chapter 1- <strong>Electrostatics</strong></a>
        </h4>
      </div>
      <script type="text/javascript">
      var choosen;
      
      function initialise()
      {
     	 var topselect=$('#topics').val();
     	 if(topselect=='please select')
     		 {
     		 	alert("bhai select to kar");
     		 }
     	 
     	 myfun();
     	 /* console.log($('#back').html()); */
     	 var content='';
     	 content +='<video id="videopanel" width="400" controls>';
     	 content +='<source src='+$('#m').html()+' type="video/mp4">';    
     	 content +='</video>';
     		$("chap1").append(content);
      }
      function myfun()
      {
	      var appURL = "<%= "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>";
	      
	      var ajaxurl = appURL +"/physics/dashjson.html?choose="+$('#topics').val();
	      console.log(ajaxurl);
	      $.support.cors = true;
	      
	      $.ajax({
	          type: "GET",
	          url: ajaxurl,
	         /*  dataType: 'json',  since we are returning a simple string so do n ot use Json it is used to fecth an object of
	         user defined class
	         */
	          error: function (err) 
	          {
	             alert("Refresh Again"+err);
	          },
	          success: function (data) 
	          {
	              /* jsondata = data; */
	             console.log(data);
	              $('#back').html(data);
	              var content='<video id="videopanel" width="400" controls>';
	              content+='<source src='+data+' type="video/mp4">';    
	             content+='</video>';
	              $('#m').html(content);
	                 /*  $.each(jsondata.res, function(i, item) 
	                   {
	                	    
	                   }); */
	          }
	      });
      }
                
      </script>
      <div id="collapse1" class="panel-collapse collapse">
        <div class="panel-body">        
          <table>
      <tbody>
      <tr>
      <td>Select Topic : </td>
      <td> 
      <select id="topics" name="type">
                                    <option value="please select">Please Select</option>
                                    <c:forEach items="${topics}" var="accountType">
                                    <option value="${accountType.key}">${accountType.value}</option>
                                    </c:forEach>
                                </select>
      <button data-toggle="collapse" data-target="#chap1" onclick="initialise()">Click to see video</button>
      </td>
      <td><div id="chap1" class="collapse">
		&nbsp; 
	<!-- <video id="videopanel" width="400" controls>
  <source src="" type="video/mp4">    
</video> -->

		</div>
		
		</td></tr>
		</tbody>
		</table>
        <span id="back"></span>
        <div id="m"></div>
        </div>
        <div class="panel-footer"><a href="#">Get Pdf notes of Electrostatics</a></div>
        </div>
        </div>
        </div>
        
    
      </div>
     
