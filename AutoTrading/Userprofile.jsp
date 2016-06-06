<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User login</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<%String fname=(String)session.getAttribute("fname");
String lname=(String)session.getAttribute("lname");
String phone=(String)session.getAttribute("phone");
String email=(String)session.getAttribute("email");
String add=(String)session.getAttribute("add");  
String city=(String)session.getAttribute("city");  
String state=(String)session.getAttribute("state");
String country=(String)session.getAttribute("country"); 
int zipcode=Integer.parseInt((String)session.getAttribute("zipcode"));
String userid=(String)session.getAttribute("userid"); %>
</head>
  
  <body>
  <div id="wrap">
		<jsp:include page="header.jsp" flush="true">     
        <jsp:param name="userid" value="<%=userid %>"/> 
         </jsp:include>
		
       <div class="center_content">
      
          <table>
       	        	 
  			<tr><td valign="top" style="text-align:left;"><div id='cssmenu'>

				<ul>
  					 <li class='active'><a href='index.jsp'><span>Home</span></a></li>
  					 <li><a href='getbought?userid=<%=userid%>'><span>My Cars</span></a></li>
   					 <li><a href='getsave?userid=<%=userid%>'><span>Favorites</span></a></li>
   					 <li><a href='rate?userid=<%=userid%>'><span>Rate and Review</span></a></li>
   					 <li><a href='Userprofile.jsp'><span>Edit Profile</span></a></li>
					
				</ul>
			</div></td>
			<td>
                 	
                 <div align="left"><font color="red">${message}</font></div>
            	<font color="red" style="text-align: left">${NameNotFoundException} ${ErrPwdException}</font>
              	<div class="contact_form">
                <div class="form_subtitle">User Profile</div>
                 <form name="User Profile" id="SignUpform" action="updateuser" method="post">          
                    <div class="form_row">
                    <label class="contact"><strong>First Name:</strong></label>
                    <input type="text"  name="fname" class="contact_input" value="<%=fname%>"/>
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>Last Name:</strong></label>
                    <input type="text" name="lname" class="contact_input" value="<%=lname%>" />
                    </div> 
                    
                    <div class="form_row">
                    <label class="contact"><strong>Phone:</strong></label>
                    <input type="text" name="phone" class="contact_input" value="<%=phone%>" />
                    </div>  
                    
                    <div class="form_row">
                    <label class="contact"><strong>Email:</strong></label>
                    <input type="text" name="email" class="contact_input" value="<%=email%>" />
                    </div>  
                         
                    
                    <div class="form_row">
                    <label class="contact"><strong>Address:</strong></label>
                    <input type="text"  name="address" class="contact_input" value="<%=add%>" />
                    </div>
                      
                      
                     <div class="form_row">
                    <label class="contact"><strong>Zip Code:</strong></label>
                    <input type="text"  name="zipcode" class="contact_input" value="<%=zipcode%>"/>
                    </div>  
                    
                    <div class="form_row">
                    <label class="contact"><strong>City:</strong></label>
                    <input type="text"  name="city" class="contact_input" value="<%=city%>"/>
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>State:</strong></label>
                    <input type="text"  name="state" class="contact_input" value="<%=state%>"/>
                    </div>
                    
                     <div class="form_row">
                    <label class="contact"><strong>Country:</strong></label>
                    <input type="text"  name="country" class="contact_input" value="<%=country%>"/>
                    </div>       	       

                    <div class="form_row">
                    <label class="contact"><strong>Primary Purpose:</strong></label>
                    <input type="text"  name="Primary Purpose" class="contact_input" />
                    </div>
                    
                     <div class="form_row">
                    <label class="contact"><strong>Expected Daily Mileage:</strong></label>
                    <input type="text"  name="Expected Daily Mileage" class="contact_input" />
                    </div>  
                    
                     <div class="form_row">
                    <label class="contact"><strong>Price Range:</strong></label>
                    <input type="text"  name="Prize Range" class="contact_input" />
                    </div>  
                    
                     <div class="form_row">
                    <label class="contact"><strong>Intersted Brands:</strong></label>
                    <input type="text"  name="Intersted Brands" class="contact_input" />
                    </div>    
                   
                    
                    <div class="form_row">
                    <input type="submit" class="register" value="Edit" />
                    <input type="hidden" name="userid" value="<%=userid%>"/>
                    </div>   
                    
                  </form> </div>
                  </td></tr>
                  </table>
                </div>  
            
          	
            
              

            

            
        <div class="clear"></div>
       
  
       <div class="clear"></div>
       </div><!--end of center content-->
        <%@include file="footer.jsp" %>  

  </body>
</html>
