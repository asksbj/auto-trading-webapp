<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User login</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<div id="wrap">
		<%@include file="header.jsp" %>
       <div class="center_content">
      	<div class="left_content">
       		<div align ="left" class="crumb_nav">
           	 <a href="login.jsp">Login</a> &gt;&gt; 
            </div>
            <div class="title"><span class="title_icon"><img src="images/bullet1.gif" alt="" title="" /></span>User Login</div>
        
        	<div class="feat_prod_box_details">
            <p class="details">
            	
            </p>
            <div align="center"><font color="red">${message}</font></div>
            	<font color="red" style="text-align: center">${NameNotFoundException} ${ErrPwdException}</font>
              	<div class="contact_form">
                <div class="form_subtitle">User login</div>
                 <form name="login" id="loginForm" action="login" method="post"> 
                     
                    <div class="form_row">
                    <label class="contact"><strong>Username:</strong></label>
                    <input type="text"  name="name" class="contact_input" />
                    
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>Password:</strong></label>
                    <input type="password" name="password" class="contact_input" />
                    </div>                     

                    <div class="form_row">
                        <div class="terms">
                        <input type="checkbox" name="terms" />
                        Remember Password
                        </div>
                    </div> 
                    <div class="form_row">
                   <a class="register" href="reg.jsp">Signup</a>
                    <input type="submit" class="register" value="Login" style="margin-right:80px;"/>
                    
                     
                    
                    </div>   
                    
                  </form>     
                </div>  
            
            </div>	
            
              

            

            
        <div class="clear"></div>
        </div><!--end of left content-->
        
        <!--end of right content-->
  
       <div class="clear"></div>
       </div><!--end of center content-->
        <%@include file="footer.jsp" %>  
</div>

</body>
</html>