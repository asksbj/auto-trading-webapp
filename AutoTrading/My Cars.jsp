<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userid=(String)session.getAttribute("userid");
String[][] info=(String[][])session.getAttribute("info");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User login</title>
<link rel="stylesheet" type="text/css" href="style.css" />
  </head>
  <body>
     <div id="wrap">
  <jsp:include page="header.jsp" flush="true">     
        <jsp:param name="userid" value="<%=userid %>"/> 
         </jsp:include>     
       <div class="center_content">
    
           <table>
       	        	 
  			<tr>
  			<td valign="top" style="text-align:left;">
  			<div id='cssmenu'>

				<ul> 
					<li class='active'><a href='index.jsp'><span>Home</span></a></li>
  					 <li><a href='getbought?userid=<%=userid%>'><span>My Cars</span></a></li>
   					 <li><a href='getsave?userid=<%=userid%>'><span>Favorites</span></a></li>
   					 <li><a href='rate?userid=<%=userid%>'><span>Rate and Review</span></a></li>
   					 <li><a href='Userprofile.jsp'><span>Edit Profile</span></a></li>
				</ul>
			</div></td>
			<td>
			 <div class ="dealer_form">
			 <table class = "table-2" cellspacing="15">
			 <tr>
			 		<th>Car ID</th><th>Make</th><th>Model</th><th>Dealer Name</th><th>Status</th></tr>
					<c:forEach items="${info}" var="in">
					<tr> 
                           <td><label>${in[0]}</label> </td>
                          <td><label>${in[1]}</label></td> 
                        <td><label>${in[2]}</label></td>
                        <td><label>${in[3]}</label></td>
                        <td><label>${in[4]}</label></td>
                  </tr>	
					  		</c:forEach>						            
					</table>
					</div>
			
			
			</td>
			</tr>
			</table>
			</div>
			</div>

  </body>
</html>
