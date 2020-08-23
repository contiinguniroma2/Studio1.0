<%@ page import="logic.control.StudentSearchInsertController"%>
<%@ page import="logic.control.LoginController"%>
<%@ page import="logic.control.StudentMainPageController"%>
<%@ page import="logic.control.LibraryMainPageController"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stud.io</title>
<link href="css/style.css" type="text/css" rel="stylesheet">
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
</head>
<body>

	<!-- navbar -->
	<div class="container">
		<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">Stud.io</a>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto">
					<!-- "ml-auto" consente di allineare item a destra-->
					<li class="nav-item active"><a class="nav-link"
						href="studentHome.html">Search<span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="studentBookmarks.html">Bookmarks</a></li>
					<li class="nav-item"><a class="nav-link"
						href="studentMessages.html">Messages</a></li>
					<li>

						<form action="studentHome.jsp" name="studLogout" method="post">
							<div class="dropdown">
								<input class="btn btn-outline-success dropdown-toggle"
									type="button" name="studId" id="dropdownMenuButton"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false"
									value="<%out.println(StudentMainPageController.getStudentMainPageController().getStudInfo().getUsername());%>" />
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									<a class="dropdown-item" href="studentSettings.html">Settings</a>
									<input class="dropdown-item" id="studLogout" name="studLogout"
										type="submit" value="Log out">
						</form>
			</div>
	</div>
	</li>
	</ul>
	</div>
	</nav>
	</div>
	<!-- END navbar -->

	<div class="row">
		<div class="container" id="search">
			<h1 align=center>
				<br>
				<br>SEARCH A SEAT
			</h1>
			<h3 align=center>Enter your address and look for the place to
				study closest to you:</h3>


			<form class="form-inline my-2 my-lg-0" action="studentHome.jsp"
				name="studLogout" method="post">
				<input class="form-control ml-auto mr-1" id="searchField"
					name="searchField" type="text" value=""
					placeholder="Insert your position..."> <input
					class="btn btn-success mr-auto" id="searchBtn" name="searchBtn"
					type="submit" value="Search">
			</form>


		</div>
	</div>

	<div class="row">
		<div class="container" id="logo">
			<p>
				<img src="img/logo3.jpg" align=center>
			</p>
		</div>
	</div>

	<!-- jQuery e plugin JavaScript  -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>


<%
  if(request.getParameter("studLogout") != null) { %>
<jsp:forward page="index.jsp" />
<%
  }
%>



<%

  if(request.getParameter("searchBtn") != null) { 
    
    try {
    	StudentSearchInsertController.getStudentSearchInsertController()
		.searchLibrariesWithCity(request.getParameter("searchField"));
    	 %><jsp:forward page="studentSearchResult.jsp" />
<%
      }
    catch (Exception e) {
      e.printStackTrace();
    }
    
  }

%>
