<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userid=(String)session.getAttribute("registerid");
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.driver.*" %>
<%@page import="oracle.sql.*" %>
<%@page import="oracle.jdbc.OracleDriver"%>
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Customer Satisfaction Report</title>
<link rel="stylesheet" type="text/css" href="style.css" />
  <script language="javascript">
        var tbl = document.getElementById("table-2");
        if (tbl != null) {
            if (tbl.rows[0] != null) {
                tbl.rows[0].style.backgroundColor = "#365890";
                tbl.rows[0].style.color = "#FFFFFF";
            }
            for (var i = 1; i < tbl.rows.length; i++) {
                tbl.rows[i].style.cursor = "pointer";
                tbl.rows[i].onmousemove = function () { this.style.backgroundColor = "#FF2080"; this.style.color = "#FFFFFF"; };
                tbl.rows[i].onmouseout = function () { this.style.backgroundColor = ""; this.style.color = ""; };
            }
        }
    </script>
   
  </head>
  
  <body>
  <div id="wrap">
  <jsp:include page="header.jsp" flush="true">  
        <jsp:param name="userid" value="<%=userid %>"/> 
         </jsp:include>    
       <div class="center_content">


         <table>       	        	 
  			<tr><td><div id='cssmenu'>

				<ul>
  					 <li class='active'><a href='#'><span>Home</span></a></li>
  					 <li><a href='#'><span>Add New Car </span></a></li>
   					 <li><a href='totalsale?userid=<%=userid %>'><span>Total Sale Report</span></a></li>
   					 <li><a href='#'><span>Trend Analysis Report</span></a></li>
   					 <li><a href='#'><span>Customer Satisfaction Report</span></a></li>
					 <li class='last'><a href='#'><span></span></a></li>
				</ul>
			</div></td>
			<td>
      		<div>
			 <table id="table-2">
			 <tr>
			 		<th>Rank</th><th>Dealer ID</th><th>Dealer Name</th><th>Rating</th></tr>
			 		<tr>
			 		<td>i</td>
			 		<td>100000</td>
			 		<td>Shuyi</td>
			 		<td><img src="images/star-on.png"></td>
			 		</tr>	
			 		<tr>
			 		<td>i</td>
			 		<td>100000</td>
			 		<td>Shuyi</td>
			 		<td><img src="images/star-on.png"></td>
			 		</tr>
			 		<tr>
			 		<td>i</td>
			 		<td>100000</td>
			 		<td>Shuyi</td>
			 		<td><img src="images/star-on.png"></td>
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
