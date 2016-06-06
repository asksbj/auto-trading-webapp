<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User login</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<%String userid =request.getParameter("userid"); %>
</head>
  
  <body>
   <div id="wrap">
 <jsp:include page="header.jsp" flush="true">     
        <jsp:param name="userid" value="<%=userid %>"/> 
         </jsp:include>      
       <div class="center_content">
     
           <table>
       	        	 
  			<tr>
  			<td valign="top">	<div id='cssmenu'>
<ul>
   <<li><a href='dealerhome?userid=<%=userid%>'><span>Home</span></a></li>
   <li><a href='Addnewcar.jsp?userid=<%=userid%>'><span>Add New Car</span></a></li>
   <li><a href='totalsale?userid=<%=userid%>'><span>Sold Cars</span></a></li>
  <li class='has-sub'><a href='#'><span>Reports</span></a>
            <ul>
            	<li><a href='trendtype?userid=<%=userid %>'><span>Trend Analysis</span></a></li>
              <li><a href='trendtotal?userid=<%=userid %>' class='last'><span>Sale Per State</span></a></li>
            </ul>
         </li>
               
   <li class='last'><a href='manage?userid=<%=userid%>'><span>Manage Cars</span></a></li>
</ul>
			</div></td>
			<td>
		
       		    <div align="left"><font color="red">${message}</font></div>
            	<font color="red" style="text-align: left">${NameNotFoundException} ${ErrPwdException}</font>
              	<div class="contact_form">
                <div class="form_subtitle">Add New Car</div>
                 <form name="AddNewCar" id="SignUpform" action="addnewcarr?userid=<%=userid%>" method="post">          
                    <div class="form_row">
                    <label class="contact"><strong>Make:</strong></label>
                    <input type="text"  name="make" class="contact_input" />
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>Model:</strong></label>
                    <input type="text" name="model" class="contact_input" />
                    </div>     
                         
                    
                    <div class="form_row">
                    <label class="contact"><strong>Mileage:</strong></label>
                    <input type="text"  name="mileage" class="contact_input" />
                    </div>
                      
                    <div class="form_row">
                    <label class="contact"><strong>Year:</strong></label>
                    <input type="text"  name="year" class="contact_input" />
                    </div>       	       

                    <div class="form_row">
                    <label class="contact"><strong>Expected Price:</strong></label>
                    <input type="text"  name="price" class="contact_input" />
                    </div>  
                    
                    <div class="form_row">
                    <label class="contact"><strong>Image:</strong></label>
                    <input type="textarea"  name="Image" class="contact_input" />
                    </div>  
                    
                    <div class="form_row">
                    <input type="submit" class="register" value="Add" />
                    </div>   
                    
                  </form>     
                </div>  
            </td>
            </tr>
            </table>
	          
          </div><!--end of center content-->
        <%@include file="footer.jsp" %>  
</div>
  </body>
</html>
