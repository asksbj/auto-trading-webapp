<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Get A Quote</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<%String userid=(String)session.getAttribute("userid");
String price=(String)session.getAttribute("price"); 
String make=(String)session.getAttribute("make");
String model=(String)session.getAttribute("model");
String year=(String)session.getAttribute("year");
String mileage=(String)session.getAttribute("mileage");
String boughtyear=(String)session.getAttribute("boughtyear");
String singleowner=(String)session.getAttribute("singleowner");%>
</head>
  
  <body>
  <div id="wrap">
		<jsp:include page="header.jsp" flush="true">     
        <jsp:param name="userid" value="<%=userid %>"/> 
         </jsp:include>   
		    <div class="center_content">
          <table>
       	       	 
  			<tr><td valign = "top" style="text-align:left;"><div id='cssmenu'>

				<ul>
  					 <li class='active'><a href='setseller?userid=<%=userid%>'><span>Home</span></a></li>
  					 <li><a href='GetAQuote.jsp?userid=<%=userid%>'><span>Get A Qoute</span></a></li>
   					 <li class='last'><a href='Add new car.jsp?userid=<%=userid%>'><span>Add a New Car</span></a></li>
				</ul>
			</div></td>
			<td>
          <!-- <div align="left"><font color="red">${message}</font></div> 
            	<font color="red" style="text-align: left">${NameNotFoundException} ${ErrPwdException}</font>--> 
              	<div class="contact_form">
                <div class="form_subtitle">Get A Quote</div>
                 <form name="GetAQuote" id="GetAQuote" action="getaqoute?userid=<%=userid%>" method="post">          
                    <div class="form_row">
                    <label class="contact"><strong>Make:</strong></label>
                    <input type="text"  name="Make" class="contact_input" value="<%=make%>"/>
                    </div>  


                    <div class="form_row">
                    <label class="contact"><strong>Model:</strong></label>
                    <input type="text" name="Model" class="contact_input" value="<%=model%>"/>
                    </div>   
                    
                    <div class="form_row">
                    <label class="contact"><strong>Year:</strong></label>
                    <input type="text"  name="Year" class="contact_input" value="<%=year%>"/>
                    </div>    
                         
                    
                    <div class="form_row">
                    <label class="contact"><strong>Mileage:</strong></label>
                    <input type="text"  name="Mileage" class="contact_input" value="<%=mileage%>"/>
                    </div>
                      
                    <div class="form_row">
                    <label class="contact"><strong>BoughtYear:</strong></label>
                    <input type="text"  name="BoughtYear" class="contact_input" value="<%=boughtyear%>"/>
                    </div>  
                    
                     <div class="form_row">
                    <label class="contact"><strong>Single Owner:</strong></label>
                    <input type="text"  name="Single Owner" class="contact_input" value="<%=singleowner%>"/>
                    </div>   
                    
                    <br />
                    <br />
                    <div class="form_row">
                    <label class="contact"><strong>Quoted Price:</strong></label>
                    <label><font size="15"><%=price %></font></label>
                    </div>     	       
                                 
                    <div class="form_row">
                    <input type="submit"  class="quotebutton" value="Get a Quote" />
                    </div>   
                    
                  </form> </div>
              
                  </td></tr>
                  </table>
     </div>
        <%@include file="footer.jsp" %>  
</div>
  </body>
</html>
