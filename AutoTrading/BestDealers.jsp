<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String[][] info=(String[][])session.getAttribute("info");
String userid =(String)session.getAttribute("userid"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Best Dealers</title>
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
   					 <li><a href='BestDealers.jsp'><span>Best Dealers</span></a></li>
   					 <li><a href='popularcar?userid=<%=userid%>'><span>Popular Cars</span></a></li>
					
				</ul>
			</div></td>
			<td align ="center" style="padding:70px;">
			
			<div class ="best_dealers_form"> 
			 <table class="table-2">
			 	<c:forEach items="${info}" var="in">
					<tr><td style="border: 1px solid #9d060b">
				
							<img src="images/Honda_gainesville.jpg" alt="Templatemo Pic 1" width="100" height="50" class="img-thumbnail img-responsive img_left"></td>
                          <td colspan="3" style="border: 1px solid #9d060b">
                         <label>${in[2]}</label></td><td style="border: 1px solid #9d060b">
     						<label>Rating:${in[4]}</label>                           
						</td>
						</tr>	
						</c:forEach>	    
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
  