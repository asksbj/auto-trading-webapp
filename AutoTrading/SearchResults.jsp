<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%List make=(List)session.getAttribute("make");
List mpg=(List)session.getAttribute("mpg"); 
List drivetype=(List)session.getAttribute("drivetype");
List price=(List)session.getAttribute("price");
String[][] info=(String[][])session.getAttribute("info");
String userid =(String)session.getAttribute("userid");
int i=0;
 %>
 <script>
  function change(str)
 {
 var carid=str;
 document.getElementById("myButton1").value="Saved";
 window.location.href="save?userid="+<%=userid%>+"&carid="+carid;
 }
 </script>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Search Results</title>
<link rel="stylesheet" type="text/css" href="style.css" />


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
   					 <li><a href='getcompare?userid=<%=userid%>'><span>Compare Cars</span></a></li>
   					 <li><a href='bestdealer?userid=<%=userid%>'><span>Best Dealers</span></a></li>
   					 <li><a href='popularcar?userid=<%=userid%>'><span>Popular Cars</span></a></li>
					
				</ul>
			</div></td>
			<td>
			<c:forEach items="${info}" var="in">
			<div class ="contact_form">
			 
			 <table>
			 	
					<tr><td>
				
							<img src="images/Aventador.jpg" alt="Templatemo Pic 1" width="100" height="50" class="img-thumbnail img-responsive img_left">
                           </td>
                           <td>MPG: <label>${in[0]}</label></td>
                           <td>Make:<label>${in[1]}</label> </td>
                           </tr><tr><td></td>
                           <td>Mileage:<label>${in[4]}</label></td>
                           <td>Price:<label>${in[3]}</label></td>
                           
                          
                    </tr><tr><td><h3><label>${in[5]}</label></h3></td> 
                        <td colspan =2>Drive Type:<label>${in[2]}</label></td></tr>
                        
                        <tr><td></td><td colspan ="6">Dealer:<label>${in[8]}</label></td>
                        </tr><tr><td></td><td>  
                        <a  href="compare?userid=<%=userid%>&carid=${in[7]}" class="myButton" style="text-align:center">Compare</a>
					  		</td>
					  		<td>
					  		 <input type="button" id ="myButton1" onclick ="change(${in[7]})" class="myButton" style="text-align:center" value="Save"/>
					  		</td>
					  		<td align = "left">
					  		
					  		</td>
                                                        <td><a  href="book?userid=<%=userid%>&carid=${in[7]}&price=${in[3]}&soldby=${in[6]}" class="myButton" style="text-align:center">Book</a></td>
                                                        </tr>						            
					</table>
					
					</div>
					</c:forEach>
			</td>
			</tr>
			</table>
		</div>
	
 <%@include file="footer.jsp" %> 
  </div>
  </body>
</html>
