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

		<div class="container" id="titleReports">
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
						<th>User</th>
						<th></th>
					</tr>
				</thead>

				<tbody>

					<tr>
						<td>1234</td>
						<td>Bagno rotto</td>
						<td>Bobbe</td>
						<td>
							<button type="button"
								class="btn btn-outline-success btn-rounded btn-sm m-0">Open</button>
							<button type="button"
								class="btn btn-outline-danger btn-rounded btn-sm m-0">Delete</button>
						</td>
					</tr>

					<tr>
						<td>1235</td>
						<td>Montascale rotto</td>
						<td>Malle</td>
						<td>
							<button type="button"
								class="btn btn-outline-success btn-rounded btn-sm m-0">Open</button>
							<button type="button"
								class="btn btn-outline-danger btn-rounded btn-sm m-0">Delete</button>
						</td>
					</tr>

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

