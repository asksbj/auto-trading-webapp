<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%String[][] info=(String[][])session.getAttribute("info");
String userid =(String)session.getAttribute("userid"); %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Popular Cars</title>
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
   					 <li><a href='PopularCar.jsp'><span>Popular Cars</span></a></li>
					
				</ul>
			</div></td>
			<td>
			<c:forEach items="${info}" var="in">
			<div class ="contact_form">
			 
			 <table>
			 	
					<tr><td>
				
							<img src="images/Aventador.jpg" alt="Templatemo Pic 1" width="100" height="50" class="img-thumbnail img-responsive img_left">
                           </td>
                           <td style="padding-left:20px"><p>Name: <label>${in[2]}</label></p>
                           <p>Make:<label>${in[1]}</label></p>
                           <p>Year:<label>${in[3]}</label></p>
                           
                           </td>
                    </tr><tr><td><h3><label></label></h3></td> 
                        
                        </tr><tr><td></td>
					  		<td align = "left">
					  		
					  		</td></tr>						            
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
