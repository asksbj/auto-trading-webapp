<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String[][] info=(String[][])session.getAttribute("info");
String userid =(String)session.getAttribute("userid");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.driver.*" %>
<%@page import="oracle.sql.*" %>
<%@page import="oracle.jdbc.OracleDriver"%>
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>free-css-templates-211</title>
	<link rel="stylesheet" type="text/css" href="style.css" />
 </head>
  
  <body>
 	 <div id="wrap">
  		<jsp:include page="header.jsp" flush="true">     
        <jsp:param name="userid" value="<%=userid %>"/> 
         </jsp:include>   
     	<div class="center_content">
		<table>       	        	 
  			<tr><td valign="top"><div id='cssmenu'>
<ul>
   <li><a href='dealerhome?userid=<%=userid%>'><span>Home</span></a></li>
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
			</div>
				</td>
				<td><div class= "dealer_form">
				<div align="center">
			 		<table id="table-2">
			 			<tr><th>State</th><th>Total</th>
			 			</tr>
			 			<c:forEach items="${info}" var="in">
			 			<tr><td>${in[0]}</td><td>${in[1]}</td>
			 			</tr>
			 			</c:forEach>
			 			
			 		</table></div>
			 		</div>
			 	</td>
			 </tr>
		</table>
		</div>
	</div>
</body>
</html>
		
	
			 			
					
					
					