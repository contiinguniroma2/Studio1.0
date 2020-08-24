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
					<li class="nav-item"><a class="nav-link"
						href="librarianHome.html">Update seats<span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="librarianTimetable.html">Time table</a></li>
					<li class="nav-item"><a class="nav-link"
						href="librarianNoticeboard.html">Noticeboard</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="ReportListLibrarian.html">Reports</a></li>
					<li class="nav-item"><a class="nav-link"
						href="librarianCheckBehavior.html">Check behavior</a></li>
					<li class="nav-item"><a class="nav-link"
						href="librarianStatistics.html">Statistics</a></li>
					<li>
						<!-- <a class="btn btn-outline-success d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="login.html">GUEST</a> -->








						<form action="librarianHome.html" name="librLogout" method="post">
							<div class="dropdown">
								<button class="btn btn-outline-success dropdown-toggle"
									type="button" id="dropdownMenuButton" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">Username</button>
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									<a class="dropdown-item" href="librSettings.html">Settings</a>
									<input class="dropdown-item" id="librLogout" name="librLogout"
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


	<!-- CONTENT -->


	<div>

		<div class="container" id="Report details:">
			<h1 align=center>
				<br>
				<br>Report details:
			</h1>
		</div>

		<div class="container" id="Report details:">
			<label for="reportTitle">Title</label> 
			<input
				readonly class="form-control" id="reportTitle" name="reportTitle" type="text"
				value="">
		
			<div class="form-group">
				<label for="reportDescription">Description</label>
				 <textarea
				readonly class="form-control" id="reportDescription" name="reportDescription"></textarea>
			</div>
		</div>
		<div id="divStudentDetailsBack">
			<button id="btnStudentDetailsBack" name="btnStudentDetailsBack" type="button" class="btn btn-success mr-auto">Back</button>
		</div>

	</div>


	<!-- jQuery e plugin JavaScript  -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>

<%
 if(request.getParameter("add") != null) {%>
 <jsp:forward page="ReportListStudent.jsp"/> <%
 }%>

