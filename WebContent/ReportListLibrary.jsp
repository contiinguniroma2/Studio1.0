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
        <a class="navbar-brand">Biblioteca ${libraryBean.getName()}</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
  
          <ul class="navbar-nav ml-auto"> <!-- "ml-auto" consente di allineare item a destra-->
         
            <li class="nav-link active">
            <form action="UpdateSeatsServlet" name="UpdateSeatsForm" method="GET">
              <a><input class="btn btn-secondary" type="submit" role="button" value="Update seats"></a>
              </form>
            </li>
            <li class="nav-link">
              <a class="btn btn-secondary" href="librarianTimetable.html">Time table</a>
            </li>
            <li class="nav-link">
              <a class="btn btn-secondary" href="librarianNoticeboard.html">Noticeboard</a>
            </li>
            <li class="nav-link">
             <form action="SuperviseServlet" name="SuperviseForm" method="GET">
              
              <a><input class="btn btn-secondary" type="submit" role="button" value="Recent students"></a>
              </form>
            </li>
            <li class="nav-item active">
             <a class="btn btn-success mx-auto" href="ReportListLibrarian.html">Reports</a></li>
            <li class="nav-link">
              <a class="btn btn-secondary" href="librarianStatistics.html">Statistics</a>
            </li>
            <li class="nav-link">
              <a class="btn btn-secondary" href="librarianSettings.html">Settings</a>
            </li>
            <li class="nav-link">
              <a class="btn btn-secondary" href="index.html">Log out</a>
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

