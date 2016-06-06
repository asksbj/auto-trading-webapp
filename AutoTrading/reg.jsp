<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>free-css-templates-211</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<script type="text/javascript">
	function enable(){
		var terms = document.getElementById("terms");
		var register = document.getElementById("register");
		if(terms.checked){
			register.disabled=false;
		}
	}
	function checkName(){
		var patrn=/^[^`~!@#$%^&*()+-=|\\\[\]\{\}:;\'\,.<>/? 0-9]{2,19}$/; 
		if (!patrn.exec(s)){
			 
			 return false;
		}else{	 
			 return true;
		}
	}
	function checkAll(){
		document.register_form.register.submit();
	}
</script>
</head>
<body>
<div id="wrap">
		
		<%@include file="header.jsp" %>    
       <div class="center_content">
       	
            	
           <div class="contact_form">
                <div class="form_subtitle">Create New Account</div>
                 <form name="register_form" action="register" method="post">          
                    <div class="form_row">
                    <label class="contact"><strong>User Name:</strong></label>
                    <input type="text" id="name" name="name" class="contact_input" />
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>Password:</strong></label>
                    <input type="password" id="password1" name="password" class="contact_input" />
                    </div> 
					
					<div class="form_row">
                    <label class="contact"><strong>Confirm Password:</strong></label>
                    <input type="password" id="password2" name="password" class="contact_input" />
                    </div> 
					
                    <div class="form_row">
                    <label class="contact"><strong>Email:</strong></label>
                    <input type="text" id="email" name="email" class="contact_input" />
                    </div>

					<div class="form_row">
                    <label class="contact"><strong>First Name:</strong></label>
                    <input type="text" id="FirstName" name="firstName" class="contact_input" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>Last Name:</strong></label>
                    <input type="text" id="LastName" name="lastName" class="contact_input" />
                    </div>
					
					
                    <div class="form_row">
                    <label class="contact"><strong>Phone Number:</strong></label>
                    <input type="text" id="phone" name="phone" class="contact_input" />
                    </div>                    
                    
                    <div class="form_row">
                    <label class="contact"><strong>Zip Code:</strong></label>
                    <input type="text" id="zipCode" name="zipcode" class="contact_input" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>Country:</strong></label>
                    <input type="text" id="country" name="country" class="contact_input" />
                    </div>
                    
                     <div class="form_row">
                    <label class="contact"><strong>State:</strong></label>
                    <input type="text" id="state" name="state" class="contact_input" />
                    </div>
                    
                     <div class="form_row">
                    <label class="contact"><strong>City:</strong></label>
                    <input type="text" id="city" name="city" class="contact_input" />
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>Street Address:</strong></label>
                   <textarea name ="address"> </textarea>
                   <!--<input type="text" id="address" name="address" class="contact_input" />-->
                    </div>
                    
                                    

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" id="terms" name="terms" onclick="enable()" />
                         I Agree the terms and Conditions <a href="">click here to read</a>                        </div>
                    </div> 

                    
                    <div class="form_row">
                    <input type="submit" id="register" name="register" class="register" value="sign up" disabled="disabled" onclick="checkAll()" />
                    </div>   
                  </form>     
                </div>   
                </div> 
         <div class="clear"></div>
       <!--end of center content-->
      <%@include file="footer.jsp" %> 
</div>

</body>
</html>