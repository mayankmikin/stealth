


<html>
	<head>
		<title>studybro signup</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
		<script src="js/jquery.min.js"></script>
		<script src="js/jquery.dropotron.min.js"></script>
		<script src="js/jquery.scrolly.min.js"></script>
		<script src="js/jquery.scrollgress.min.js"></script>
		<script src="js/skel.min.js"></script>
		<script src="js/skel-layers.min.js"></script>
		<script src="js/init.js"></script>
		<script src="jsp_pages/js/validation.js"></script>
		<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
		<script src="//code.jquery.com/jquery-1.9.1.js"></script>
  		<script src="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"></script>
		
		<noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
			<link rel="stylesheet" href="css/style-wide.css" />
			<link rel="stylesheet" href="css/style-noscript.css" />
			<link rel="stylesheet" href="css/registration.css" />
	</noscript>
		
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
		<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
		<style type="text/css">
		.center {
    			  text-align:center;
    			  position:relative;
    			  top:40px;
				 }
		.errors {
					color:#900;
					font-size: 15px;
				};
		</style> 
		
	<!-- 	to check password matches or not  -->
		<script type="text/javascript">
		// Get the first HTML element by passing 0 to .get()
			function checkPass(pass2){
		      var pass1 =$("#password").val();
		      var pass2=$("#password2").val();
		      if(pass1!=pass2)
		    	  {
		    	  alert('Password didnot match');
		    	  location.reload();		    	 
		            return false;
		    	  }
		      else
		    	  {
		    	  	return true;
		    	  }
		}
		
		</script>
		<script type="text/javascript">
		$(document).ready(function() { $("#name").focus();});
		</script>
		 <!--  script  to check user exists or not  -->
	<script>
$(document).ready(function() {
   $('#password').focus(function(event) {
      var mail = $("#email").val();
      var num = $("#phoneno").val();
      $.getJSON('mailAction', {
        emailId: mail,
        phoneno:num
      }, function(jsonResponse) {
        $('#ajaxResponse').text(jsonResponse.dummyMsg);
        $('#phoneInfo').text(jsonResponse.nummsg);
        var t=$("#ajaxResponse").html();
        var n=$("#phoneInfo").html();
        if((t!="User Available")||(n=="number exists"))
   	 		{
        	alert('User exists with this email id or Phoneno exists for the user. Form will reset now please use different email id');
        	location.reload();
   	 	
   	 		}
      });
      });
});
</script>

 

	
		<!-- 
	validation jquery -->
	<script type="text/javascript">

	$(document).ready(function(){
		   $("#register-form").validate({
			   errorClass:"errors", 
		        rules : {
		                name : {
		                        required : true,
		                        minlength : 4,
		                        maxlength : 20,
		                },
		                email: {
		                		required: true,
		                		email:true ,               		
		                		/*  uniqueUserName: true */
		                },
		                password: {
	                        required: true,
	                        minlength: 5
	                    },
	                    phoneno:{
	                    	required: true,
	                    	minlength:10,
	                    	maxlength:10
	                    },
	                    pincode:{
	                    		digits:true
	                    },
	                    checkbox:{
	                    	
	                    	required:true
	                    }
		                
		   
		        },
		        messages : {
		                name : {
		                        required : "Please enter a name",
		                        minlength : $.format("Minimum {0} characters required!"),
		                        maxlength : $.format("Maximum {0} characters allowed!")
		                },
		                password: {
	                        required: "Please provide a password",
	                        minlength: "Your password must be at least 5 characters long"
	                    },
	                    phoneno : {
	                        required : "Please enter a correct phone number",
	                        minlength : $.format("Minimum {10} characters required!"),
	                        maxlength : $.format("Maximum {10} characters allowed! do not put Zero(0) or +91 before mobile number")
	                	},
	                	email: {
	                		required:"Please provide a valid email ID",
	                		 /* uniqueUserName: "This Username is taken already", */
	                	},
	                	pincode:{
	                		digits: "this field can only contain numbers"
	    		        },
	                	checkbox:{
	                		required:"Please check our Terms and Conditions"
	                	}
	                	
		        },/* message ends here */
		        
		        debug:true,
		        submitHandler: function(form) {
		            form.submit();
		        }
		  }); /* validatemethod is over */

	});

	</script>
	<script>
	function validateEmail(email){
        var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;

        if (reg.test(email.value) == false) 
        {
            alert('Invalid Email Address');
            return false;
        }
        return true;

}
	</script>	
	
		
	</head>
	<body class="contact">

	
	<div class="center">
	<a href="../..//login.action" class="button small">Go Home</a>
	</div>
	

		<!-- Main -->
			<article id="main">

				<header class="special container">
					<span class="icon fa-user-plus"></span>
					<h2>Register free account</h2>					
				</header>

				<!-- One -->
					<section class="wrapper style4 special container 50%">

						<!-- Content -->
							<div class="content">
							<p>Fill the user details given below</p>
								<form id="register-form" name="register-form" action="/register.action" method="post">
<table class="wwFormTable">
									<div class="row 50%">
										<div class="6u 12u(mobile)">										
											<tr>
    <td class="tdLabel"></td>
    <td><input type="text" name="name" value="" id="name" placeholder="Name"/></td>
</tr>

										</div>
										
										<div class="12u">
											<tr>
    <td class="tdLabel"></td>
    <td
><input type="text" name="phoneno" value="" id="phoneno" placeholder="Phone number"/></td>
</tr>

											
										</div>
										</div>
									<div class="row 50%">										
										<div class="6u 12u(mobile)">
											<tr>
    <td class="tdLabel"></td>
    <td
><input type="text" name="email" value="" id="email" onblur="validateEmail(this)" placeholder="Email"/></td>
</tr>

											</div>
										</div>
										<div class="row 50%">
										<div class="6u 12u(mobile)">
											<tr>
    <td class="tdLabel"></td>
    <td
><input type="password" name="password" id="password" placeholder="Password"/></td>
</tr>
											
										</div>
										</div>
									<div class="row 50%">
										<div class="6u 12u(mobile)">
											<tr>
    <td class="tdLabel"></td>
    <td
><input type="password" name="password2" id="password2" onblur="checkPass(this)" placeholder="Confirm Password"/></td>
</tr>
															
										</div>										
												</div>				
									<div class="row 50%">
										<div class="12u">
											<tr>
    <td class="tdLabel"></td>
    <td
><input type="text" name="address" value="" id="address" placeholder="Address" rows="7"/></td>
</tr>

										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<tr>
    <td class="tdLabel"></td>
    <td
><input type="text" name="pincode" value="" id="pincode" placeholder="Pincode"/></td>
</tr>

										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<tr>
    <td class="tdLabel"></td>
    <td
><input type="text" name="city" value="" id="city" placeholder="City"/></td>
</tr>

										</div>
									</div>
									
									<div class="row 50%">
										<div class="12u">
											<tr>
    <td class="tdLabel"></td>
    <td
><input type="text" name="state" value="" id="state" placeholder="State"/></td>
</tr>

										</div>
									</div>
									<div class="row 50%">
										<div class="12u">
											<tr>
    <td class="tdLabel"></td>
    <td
><input type="text" name="country" value="" id="country" placeholder="Country"/></td>
</tr>

										</div>
									</div>
									<div class="row 50%">				
						
										<div class="12u">
								<tr>
    <td class="tdLabel"></td>
    <td
><select name="gender" id="gender" placeholder="Gender">
    <option value="-1"
    >Select</option>
    <option value="Male">Male</option>
    <option value="Female">Female</option>


</select>
</td>
</tr>
 									
									</div>
									</div>	
									<div class="row">
										<div class="12u">
											<ul class="buttons">
												<li><tr>
    <td colspan="2"><div align="center"><input type="submit" id="register-form_0" value="Register" class="class java.util.HashMap"/>
</div></td>
</tr>

												<!-- <input type="button" value="Reset form" onclick="reset(this)"> -->
												</li>												
											</ul>											
										</div>										
									</div>
								</table></form>




							</div>
					</section>
			
			</article>

		<span id="ajaxResponse" class="errors"></span>
		<span id="phoneInfo" class="errors"></span>
			<marquee bgcolor=#003366  height=20><font color="white"> Maths Tutorials For Class XII absolutely <strong>FREE</strong></font></marquee>



	
	
	</body>
</html>