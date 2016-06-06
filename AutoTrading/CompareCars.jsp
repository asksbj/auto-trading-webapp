<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Compare Cars</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<%String[][] info=(String[][])session.getAttribute("info");
String userid =(String)session.getAttribute("userid"); %>
  </head>
  	
  <body>
  <div id="wrap">
  <jsp:include page="header.jsp" flush="true">     
        <jsp:param name="userid" value="<%=userid %>"/> 
         </jsp:include>     
       <div class="center_content">
       	  
       	 <table>
       	        	 
  			<tr><td valign = "top"><div id='cssmenu'>

				<ul>
  					 <li class='active'><a href='index.jsp'><span>Home</span></a></li>
  					 <li><a href='BuyACar.jsp'><span>Buy A Car</span></a></li>
   					 <li><a href='CompareCars.jsp'><span>Compare Cars</span></a></li>
   					 <li><a href='bestdealer?userid=<%=userid%>'><span>Best Dealers</span></a></li>
   					 <li><a href='popularcar?userid=<%=userid%>'><span>Popular Cars</span></a></li>
					
				</ul>
			</div></td>
			<td>
			<div class ="compare_form">
			 
			 <table style="font-family:Georgia, Garamond, Serif;color:black;font-style:italic;">
			 	
					<tr><td>
				
							<img src="images/slide1.jpg" alt="Templatemo Pic 1" width="100" height="50" class="img-thumbnail img-responsive img_left">
                           </td></tr><tr>
                           	<td>Make:<label><%=info[0][0] %></label></td></tr><tr>
                          	 <td>Model:<label><%=info[0][1] %></label> </td></tr><tr>
                          	 <td>Year:<label><%=info[0][2] %></label> </td></tr><tr>
                            <td>MPG: <label><%=info[0][3] %></label></td></tr><tr>
                           <td>Mileage:<label><%=info[0][5] %></label></td></tr><tr>
                            <td colspan ="2">Drive Type:</td></tr>
                            <tr><td><label><%=info[0][4] %></label></td></tr><tr>
                           <td>Price:<label><%=info[0][6] %></label></td></tr><tr>
                      
                        </tr><tr><td align ="center">
					  		 <a  href="savecompare?userid=<%=userid %>&carid=<%=info[0][7] %>" class="myButton" style="text-align:center">Save</a>
					  		</td></tr><tr>
					  		 </tr><tr><td align ="center">
					  		 <a  href="removecompare?userid=<%=userid %>&carid=<%=info[0][7] %>" class="myButton" style="text-align:center">Remove</a>
					  		</td></tr><tr>
					  		</tr><tr>
					  		<td align ="center"><a  href="bookcompare?userid=<%=userid%>&carid=<%=info[0][7] %>&price=<%=info[0][6] %>&soldby=<%=info[0][8]%>" class="myButton" style="text-align:center">Book</a></td>
					  		</tr>						            
					</table>
					
					</div>
			</td><td>
			<div class ="compare_form">
			 
			 <table style="font-family:Georgia, Garamond, Serif;color:black;font-style:italic;">
			 	
					<tr><td>
				
							<img src="images/Aventador.jpg" alt="Templatemo Pic 1" width="100" height="50" class="img-thumbnail img-responsive img_left">
                           </td></tr><tr>
                           	<td>Make:<label><%=info[1][0] %></label></td></tr><tr>
                          	 <td>Model:<label><%=info[1][1] %></label> </td></tr><tr>
                          	 <td>Year:<label><%=info[1][2] %></label> </td></tr><tr>
                            <td>MPG: <label><%=info[1][3] %></label></td></tr><tr>
                           <td>Mileage:<label><%=info[1][5] %></label></td></tr><tr>
                            <td colspan =2>Drive Type:</td></tr>
                            <tr><td><label><%=info[1][4] %></label></td></tr><tr>
                           <td>Price:<label><%=info[1][6] %></label></td></tr><tr>
                      
                        </tr><tr><td align ="center">
					  		 <a  href="savecompare?userid=<%=userid %>&carid=<%=info[1][7] %>" class="myButton" style="text-align:center">Save</a>
					  		</td></tr><tr>
					  		 </tr><tr><td align ="center">
					  		 <a  href="removecompare?userid=<%=userid %>&carid=<%=info[1][7] %>" class="myButton" style="text-align:center">Remove</a>
					  		</td></tr><tr>
					  		</tr><tr>
					  		<td align ="center"><a  href="bookcompare?userid=<%=userid%>&carid=<%=info[1][7] %>&price=<%=info[1][6] %>&soldby=<%=info[1][8]%>" class="myButton" style="text-align:center">Book</a></td>
					  		</tr>						            
					</table>
					
					</div>
			
			</td><td>
			
			<div class ="compare_form">
			 
			 <table style="font-family:Georgia, Garamond, Serif;color:black;font-style:italic;">
			 	
					<tr><td>
				
							<img src="images/Aventador.jpg" alt="Templatemo Pic 1" width="100" height="50" class="img-thumbnail img-responsive img_left">
                           </td></tr><tr>
                           	<td >Make:<label><%=info[2][0] %></label></td></tr><tr>
                          	 <td>Model:<label><%=info[2][1] %></label> </td></tr><tr>
                          	 <td>Year:<label><%=info[2][2] %></label> </td></tr><tr>
                            <td>MPG: <label><%=info[2][3] %></label></td></tr><tr>
                           <td>Mileage:<label><%=info[2][5] %></label></td></tr><tr>
                            <td colspan =2>Drive Type:</td></tr>
                            <tr><td><label><%=info[2][4] %></label></td></tr><tr>
                           <td>Price:<label><%=info[2][6] %></label></td></tr><tr>
                      
                        </tr><tr><td align ="center">
					  		 <a  href="savecompare?userid=<%=userid %>&carid=<%=info[2][7] %>" class="myButton" style="text-align:center">Save</a>
					  		</td></tr><tr>
					  		 </tr><tr><td align ="center">
					  		 <a  href="removecompare?userid=<%=userid %>&carid=<%=info[2][7] %>" class="myButton" style="text-align:center">Remove</a>
					  		</td></tr><tr>
					  		</tr><tr>
					  		<td align ="center"><a  href="bookcompare?userid=<%=userid%>&carid=<%=info[2][7] %>&price=<%=info[2][6] %>&soldby=<%=info[2][8]%>" class="myButton" style="text-align:center">Book</a></td>
					  		</tr>						            
					</table>
					
					</div>
			</td>
			</tr>
			</table>
		</div>
	
 <%@include file="footer.jsp" %> 
  </div>
  </body>
</html>
