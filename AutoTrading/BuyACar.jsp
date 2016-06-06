<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.sql.*"%>
<%@page import="oracle.jdbc.driver.*" %>
<%@page import="oracle.sql.*" %>
<%@page import="oracle.jdbc.OracleDriver"%>
<html>
  <head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Buy a Car</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<%List Make=(List)session.getAttribute("Make");
List Model=(List)session.getAttribute("Model"); 
List Year=(List)session.getAttribute("Year");
String gmake=(String)session.getAttribute("gmake");
String userid =(String)session.getAttribute("userid");
 %>
<script>
function submit1(str){
     document.getElementById("form1").submit(str);
  }
  
  function getmake(){
    var smake= document.getElementById("Make").selectedIndex;
    var gmake=document.getElementById("Make").options[smake].text;
    var smodel= document.getElementById("Model").selectedIndex;
    var gmodel=document.getElementById("Model").options[smodel].text;
    var syear= document.getElementById("Year").selectedIndex;
    var gyear=document.getElementById("Year").options[syear].text;
    var sprice= document.getElementById("Price").selectedIndex;
    var gprice=document.getElementById("Price").options[sprice].text;
    window.location.href="searchresults?gmake="+gmake+"&gmodel="+gmodel+"&gprice="+gprice+"&gyear="+gyear+"&userid=<%=userid%>";
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
  			<tr><td valign="top" ><div id='cssmenu'>

				<ul>
  					 <li class='active'><a href='index.jsp'><span>Home</span></a></li>
  					 <li><a href='BuyACar.jsp?userid=<%=userid%>'><span>Buy A Car</span></a></li>
   					 <li><a href='getcompare?userid=<%=userid%>'><span>Compare Cars</span></a></li>
   					 <li><a href='bestdealer?userid=<%=userid%>'><span>Best Dealers</span></a></li>
   					 <li><a href='popularcar?userid=<%=userid%>'><span>Popular Cars</span></a></li>
					 
				</ul>
			</div></td>
			<td>
		<div class="car_search_form">
		<div class="form_subtitle">Car Search</div>
     <form id="form1" action="getmodel">
     <input type="hidden" name="userid" value="<%=userid%>"/>
			<table>
			<tr><td>
			<div class="styled-select">
			<select name="Make" id="Make" onchange="submit1(this.value)">
			   <c:forEach items="${Make}" var="Makes">
			   <option value="${Makes}">${Makes}</option>
  				</c:forEach>
				 </select>
			</div></td></tr>
			<tr>
			<td>			
			<div class="styled-select">
			 <select name="Model" id="Model" >
			   <c:forEach items="${Model}" var="Models">
			   <option value="${Models}">${Models}</option>
  				</c:forEach>
				 </select>
			</div></td></tr>
			<tr>
			<td>			
			<div class="styled-select">
			 <select name="Year" id="Year" >
			   <c:forEach items="${Year}" var="Years">
			   <option value="${Years}">${Years}</option>
  				</c:forEach>
				 </select>
			</div></td></tr>
			<tr><td>
			<div class="styled-select">
			<select name="Price" id="Price">
  				<option name="price" value="volvo">Price</option>
  				<option name="price" value="p1">0-5000</option>
  				<option name="price" value="p2">5000-10000</option>
 				<option name="price" value="p3">10000-15000</option>
 				<option name="price" value="p4">15000-20000</option>
 				<option name="price" value="p5">20000-25000</option>
 				<option name="price" value="p6">25000-30000</option>
 				<option name="price" value="p7">30000-35000</option>
 				<option name="price" value="p8">35000-40000</option>
 				<option name="price" value="p9">40000-45000</option>
 				<option name="price" value="p10">45000-50000</option>
				 </select>
			</div></td>
			</tr>
			
			</table>
			</form>
			</td></tr>
			<tr><td></td><td align="center">
			<button onclick="getmake()" class ="myButton">Search</button>
			</td></tr>
			</div>
			</table>
		</div>
 
 <%@include file="footer.jsp" %> 
  </div>
  </body>
</html>
