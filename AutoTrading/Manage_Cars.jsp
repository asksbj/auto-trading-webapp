<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String[][] info=(String[][])session.getAttribute("info");
String userid =(String)session.getAttribute("userid");
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
  			<td valign="top">
  			<div id='cssmenu'>
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
			</div></td>
			<td>
			 <div class ="dealer_form">
			 <table class = "table-2" cellspacing="15">
			 <tr>
			 		<th>Car ID</th><th>Make</th><th>Model</th><th>Year</th><th>Price</th>
					<tr> 
					<c:forEach items="${info}" var="in">
                           <td><label>${in[0]}</label> </td>
                          <td><label>${in[1]}</label></td> 
                        <td><label>${in[2]}</label></td>
                        <td><label>${in[3]}</label></td>
                        <td><label>${in[4]}</label></td>
                       <td align ="left">
					  		 <a  href="deletemanage?userid=<%=userid%>&carid=${in[0]}" id ="myButton1" class="myButton" style="text-align:center">Delete</a>
					  		</td>
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
