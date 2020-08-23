<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="logic.control.StudentMainPageController"%>
	<%@page import="logic.control.ReportIssueController"%>
	<%@page import="logic.entity.Student" %>
	<%@page import="logic.entity.Library"%>
	<%@page import="logic.entity.User"%>
	<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<%
 	request.getSession().setAttribute("reportIssueController", new ReportIssueController((Student)request.getSession().getAttribute("sessionUser"),(Library)request.getSession().getAttribute("currentLibrary")));
	((ReportIssueController)request.getSession().getAttribute("reportIssueController")).getStudentReports();
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
					<li class="nav-item active"><a class="nav-link"
						href="studentHome.html">Search<span class="sr-only">(current)</span></a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="studentBookmarks.html">Bookmarks</a></li>
					<li class="nav-item"><a class="nav-link"
						href="studentMessages.html">Messages</a></li>
					<li>
						<form action="studentHome.html" name="studLogout" method="post">
							<div class="dropdown">
								<input class="btn btn-outline-success dropdown-toggle"
									type="button" id="dropdownMenuButton" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"
									value="<%out.println(((User)request.getSession().getAttribute("sessionUser")).getUsername());%>" />
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									<a class="dropdown-item" href="studentSettings.html">Settings</a>
									<input class="dropdown-item" id="studLogout" name="studLogout"
										type="submit" value="Log out">
								</div>
							</div>
						</form>
			</div>
	</div>
	<!-- END navbar -->


	<!-- CONTENT -->


	<div>

		<div class="container" id="titleReportsDiv">
			<h1 align=center>
				<br>
				<br>Your reports:
			</h1>
		</div>


		<div class="table-wrapper-scroll-y my-custom-scrollbar"
			id="tableReportsDiv">

			<table id="tableBookings"
				class="table table-striped table-bordered table-sm"
				style="text-align: center;" cellspacing="20" width="100%">

				<thead>
					<tr>
						<th>Report id</th>
						<th>Object</th>

						<th><button type="button" class="btn btn-success mr-auto">Send
								report</button></th>
					</tr>
				</thead>

				<tbody>
					<% for(int i = 0; i < ((ReportIssueController)request.getSession().getAttribute("reportIssueController")).getSessionUser().getReports().size(); i++) { %>
		       			<tr>
							<td><label><%=((ReportIssueController)request.getSession().getAttribute("reportIssueController")).getSessionUser().getReports().get(i).getReportId()%></label></td>
							<td><label><%=((ReportIssueController)request.getSession().getAttribute("reportIssueController")).getSessionUser().getReports().get(i).getTitle()%></label></td>
							<td><button type="button"
									class="btn btn-outline-success btn-rounded btn-sm m-0">Open</button>
								<button type="button"
									class="btn btn-outline-danger btn-rounded btn-sm m-0">Delete</button></td>
						</tr>
	   				<% } %>

				</tbody>

			</table>
		</div>
	</div>

	</div>

	<!-- jQuery e plugin JavaScript  -->
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>

