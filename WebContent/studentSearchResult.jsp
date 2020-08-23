<%@ page import="logic.control.StudentSearchInsertController"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="logic.control.StudentMainPageController"%>
<%@ page import="java.util.List"%>
<%@ page import="logic.entity.Library"%>

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
						<!-- <a class="btn btn-outline-success d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="login.html">GUEST</a> -->
						<div class="dropdown">
							<input class="btn btn-outline-success dropdown-toggle"
								type="button" id="dropdownMenuButton" data-toggle="dropdown"
								aria-haspopup="true" aria-expanded="false"
								value="<%out.println(StudentMainPageController.getStudentMainPageController().getStudInfo().getUsername());%>" />>
							<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								<a class="dropdown-item" href="studentSettings.html">Settings</a>
								<a class="dropdown-item" href="index.html">Logout</a>
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
				<br>Results:
			</h1>
		</div>
	</div>


	<form action="studentSearchResult.jsp" name="studentResultList"
		method="post">
		<div class="row">
			<div class="container" id="listLib">

				<div class="table-wrapper-scroll-y my-custom-scrollbar">

					<table id="tableBookings"
						class="table table-striped table-bordered table-sm"
						style="text-align: center;" cellspacing="20" width="100%">
						<thead>
							<tr>
								<th>Library:</th>
								<th>Free seats:</th>
							</tr>
						</thead>

						<tbody>

							<% 
					  	List<Library> biblioteche = StudentSearchInsertController.getStudentSearchInsertController().getLibrInfo();
  
					  	for(int i=0; i<biblioteche.size(); i++){
					        %><tr>
								<td><input class="btn btn-success mx-auto"
									id="<%out.println(biblioteche.get(i).getName());%>"
									role="button" name="bib" type="submit"
									value="<%out.println(biblioteche.get(i).getName());%>">
								</td>
								<td>
									<%out.println(biblioteche.get(i).getCapacity());%>
								</td>
							</tr>
							<%  }
					   	%>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</form>


	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>


<%		
	  if(request.getParameter("bib") != null) { 
		  StudentMainPageController.getStudentMainPageController().setLibrInfo(biblioteche.get(0));
			  %>
<jsp:forward page="studentSearchLibrPage.jsp" />
<%
	  }
	  
	
%>

