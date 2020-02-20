<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="logic.control.StudentMainPageController" %>   
    
 <%
  if(request.getParameter("studLogout") != null) { %>
  	<jsp:forward page="index.jsp"/> <%
  }
%>      


 <%
  if(request.getParameter("bookSeat") != null) { %>
  	<jsp:forward page="studentHome.jsp"/> <%
  }
%>  

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stud.io</title>
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
</head>
  <body>


    <div class="container">
      <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Stud.io</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto"> 
            <li class="nav-item active">
              <a class="nav-link" href="studentHome.html">Search<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="studentBookmarks.html">Bookmarks</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="studentMessages.html">Messages</a>
            </li>
            <li>
              <form action="studentHome.jsp" name="studLogout" method="post">
	              <div class="dropdown">
	                <input class="btn btn-outline-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" value="<%out.println(StudentMainPageController.getStudentMainPageController().getStudInfo().getUsername());%>"/>
	                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	                  <a class="dropdown-item" href="studentSettings.html">Settings</a>
	                  <input class="dropdown-item" id="studLogout" name="studLogout" type="submit" 
               			value="Log out">
               		</div>
               		</div>
              </form>  
                </div>
     </div>




	<form action="studentResultLibrPage.jsp" name="bookBtn" method="post">
    <div class="row" align="center">
    <div class="container" id="listAttr" align="center">
    
    	<h1 align=center><br><br>Library:</h1>
    
      	<div class="table-wrapper-scroll-y my-custom-scrollbar">

				    <table id="tableLib" class="table table-striped table-bordered table-sm" style="content-align: center;" cellspacing="20" width="100%">
					  <tbody>
      					<tr><td><p class="text-justify" align="center">Name:   <%out.println(StudentMainPageController.getStudentMainPageController().getLibrInfo().getName());%> </td>
        				</tr>
        				<tr><td><p class="text-justify" align="center">Address:   <%out.println(StudentMainPageController.getStudentMainPageController().getLibrInfo().getIndirizzo());%> </td>
        				</tr>
        				<tr><td><p class="text-justify" align="center">City:   <% out.println(StudentMainPageController.getStudentMainPageController().getLibrInfo().getCity());%> </td>
        				</tr>
        				<tr><td><p class="text-justify" align="center">Mail:   <%out.println(StudentMainPageController.getStudentMainPageController().getLibrInfo().getMail());%> </td>
        				</tr>
        				<tr><td><p class="text-justify" align="center">Phone:   <% out.println(StudentMainPageController.getStudentMainPageController().getLibrInfo().getPhone());%> </td>
        				</tr>
        				<tr><td><p class="text-justify" align="center">Capacity:   <%out.println(String.valueOf(StudentMainPageController.getStudentMainPageController().getLibrInfo().getCapacity()));%> </td>
        				</tr>
        			</tbody>
        			</table>
        </div>
     </div>
     </div>
    
	<div class="row">
		<div class="container" id="librPageButtons">
			<p class="text-center">
				<input class="btn btn-success mx-auto" role="button" id="bookSeat" name="bookSeat" type="submit" 
               value="Book seat">
				<a href="" class="btn btn-success mx-auto" role="button">Send feedback</a>
				<a href="" class="btn btn-success mx-auto" role="button">Timetable</a>
				<a href="" class="btn btn-success mx-auto" role="button">Noticeboard</a>
				<a href="" class="btn btn-success mx-auto" role="button">Map</a>
			</p>
		</div>
	</div>
	
	</form>
	

   <script src="http://code.jquery.com/jquery.js"></script>
   <script src="js/bootstrap.min.js"></script>

  </body>
</html>