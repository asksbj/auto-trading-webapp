<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userid=(String)session.getAttribute("registerid");
String[][] info=(String[][])session.getAttribute("info");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.driver.*" %>
<%@page import="oracle.sql.*" %>
<%@page import="oracle.jdbc.OracleDriver"%>
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Dealer Home Page</title>
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
  			<td valign="top">
  				<div id='cssmenu'>
<ul>
   <li><a href='DealerHomepage.jsp'><span>Home</span></a></li>
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

      <div class ="dealer_form" >
			 <table id = "table-2"  style="width:100%" >
			 <tr>
			 		<th>Buyer ID</th><th>Buyer Name</th><th>Car ID</th><th>Car Price</th></tr>
					<c:forEach items="${info}" var="in">
					<tr> 
                           <td><label>${in[1]}</label> </td>
                          <td><label>${in[2]}</label></td> 
                        <td><label>${in[0]}</label></td>
                        <td><label>${in[3]}</label></td>
                        <td><a  href="confirmbook?userid=<%=userid %>&carid=${in[0]}" class="myButton" style="text-align:center">Confirm</a><td>
                        <td><a  href="denybook?userid=<%=userid %>&carid=${in[0]}" class="myButton" style="text-align:center">Deny</a><td>
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
