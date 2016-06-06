<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@include file="common.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%request.setCharacterEncoding("gb2312");
  request.setCharacterEncoding("UTF-8");
  String userid =(String)session.getAttribute("userid");
  String[][] info=(String[][])session.getAttribute("info");
  String[] area=new String[info.length];  
  %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Rate and Review</title>
<link rel="stylesheet" type="text/css" href="style.css" />

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4/jquery.min.js"></script>

</head>
<body>
<div id="wrap">
		
		<jsp:include page="header.jsp" flush="true">     
        <jsp:param name="userid" value="<%=userid %>"/> 
         </jsp:include>
		 <div class="center_content">
       	 <table>
       	        	 
  			<tr><td valign = "top" align="left">
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
			<c:forEach items="${info}" var="in">
			<br />
			<div class ="review_form">
			 
			 <table>
			 	
					<tr><td>
				
							<img src="images/Aventador.jpg" alt="Templatemo Pic 1" width="100" height="50" class="img-thumbnail img-responsive img_left"></td>
                          <td> 
                           
                           <form name="review" id="review" action="ratereview?userid=<%=userid%>&dealerid=${in[0]}&carid=${in[5]}" method="post">
                          <p><h3><label>${in[1]}</label></h3></p> 
                           <p><textarea id="review_area" name ="review" rows="3" cols = "30" >${in[4]}</textarea></p>
                                                     
                      <p>
								<span class="starRating">
        
								<input id="rating5" type="radio" name="rating" value="5">
       							<label for="rating5">5</label>
        
								<input id="rating4" type="radio" name="rating" value="4">
        						<label for="rating4">4</label>
        
								<input id="rating3" type="radio" name="rating" value="3" checked>
        						<label for="rating3">3</label>
        
								<input id="rating2" type="radio" name="rating" value="2">
        						<label for="rating2">2</label>
        
								<input id="rating1" type="radio" name="rating" value="1">
        						<label for="rating1">1</label>
      
								</span>
    
				</td><td></td><td></td><td></td><td></td><td valign="middle" style="padding:30px" align ="center" >
                    <input type="submit" id="save" name="save" class="myButton" value="Save"/>
                    </p>  
							</form>
                           </td>
                         
                           </tr>
                           
                       </table>
					
					</div>
					<br/>
					<br/>
					</c:forEach>
			

 </td>
</tr>
</table>
</div>
       <%@include file="footer.jsp"%>
</div>

</body>
</html>