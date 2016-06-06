<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%request.setCharacterEncoding("gb2312");
  request.setCharacterEncoding("UTF-8");
  String userid =(String)session.getAttribute("userid");
  String numusers =(String)session.getAttribute("numusers");
  String numcars =(String)session.getAttribute("numcars"); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User Home Page</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>
<body>
<div id="wrap">
		
		<jsp:include page="header.jsp" flush="true">     
        <jsp:param name="userid" value="<%=userid %>"/> 
         </jsp:include>
		 <div class="index_center">
		 <br/>
		 <br/>
			<div align="center">
			<table cellpadding="10" bgcolor="#a81f22" border="2" style="font-family:Georgia, Garamond, Serif;color:white;font-style:italic;">
				<tr>
				<td >
				<font color="white">
				<label>Number of Cars:</label></font>
				</td><td><%=numcars %></td>
				<td>
				<label>Number of Users:</label></font>
				</td>
				<td><%=numusers %></td>
				</tr>
			</table>
			
			
			</div>
				
			
				   
				</div>
				<div align="center">
				<a  href="setbuyer?userid=<%=userid%>" class="myButton" style="text-align:center">Buy A Car</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <a href="setseller?userid=<%=userid%>" class="myButton"style="text-align:center">Sell A Car</a>	
				</div>
				
       <%@include file="footer.jsp"%>
</div>

</body>
</html>