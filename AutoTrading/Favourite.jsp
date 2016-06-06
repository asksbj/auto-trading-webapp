<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
String[][] info=(String[][])session.getAttribute("info");
String userid=(String)session.getAttribute("userid");
int i=0;
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Favorites</title>
<link rel="stylesheet" type="text/css" href="style.css" />


  </head>
  	
  <body>
  <div id="wrap">
  <jsp:include page="header.jsp" flush="true">     
        <jsp:param name="userid" value="<%=userid %>"/> 
         </jsp:include>   
         <div class="crumb_nav">
           	 <a href="index.jsp">Homepage</a> &gt;&gt; UserProfile
            </div>   
       <div class="center_content">
       	  
       	 <table>
       	        	 
  			<tr><td valign = "top"><div id='cssmenu'>

				<ul>
  					 <li class='active'><a href='#'><span>Home</span></a></li>
  					 <li><a href='getbought?userid=<%=userid%>'><span>My Cars</span></a></li>
   					 <li><a href='getsave?userid=<%=userid%>'><span>Favorites</span></a></li>
   					 <li><a href='rate?userid=<%=userid%>'><span>Rate and Review</span></a></li>
   					 <li><a href='Userprofile.jsp'><span>Edit Profile</span></a></li>
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
                           
                          
                    </tr><tr><td><h3><label>${in[6]}</label></h3></td> 
                        <td colspan =2>Drive Type:<label>${in[2]}</label></td>
                        </tr><tr><td></td><td>  
                        <a  href="removesave?userid=<%=userid%>&carid=${in[5]}" class="myButton" style="text-align:center">Remove</a>
					  		</td>					            
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
