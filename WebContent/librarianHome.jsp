<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ page import="logic.control.LibraryMainPageController" %>   
<%@ page import="java.lang.String" %>   
    
<%
  if(request.getParameter("librLogout") != null) { %>
  	<jsp:forward page="index.jsp"/> <%
  }
%>   
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Stud.io</title>
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">


    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Num', '% on total'],
          ['Busy',      14],
          ['Booked', 4],
          ['Free', 48]
        ]);

        var options = {
          is3D: true,
          colors: ['#B22222', '#FFA500', '#008000']
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }
    </script>


</head>
 <body>

    <!-- navbar -->
    <div class="container">
      <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Stud.io</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto"> <!-- "ml-auto" consente di allineare item a destra-->
            <li class="nav-item active">
              <a class="nav-link" href="librarianHome.html">Update seats<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="librarianTimetable.html">Time table</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="librarianNoticeboard.html">Noticeboard</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="librarianCheckBehavior.html">Check behavior</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="librarianStatistics.html">Statistics</a>
            </li>
            <li>
              <!-- <a class="btn btn-outline-success d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3" href="login.html">GUEST</a> -->
              
              
              
              
              
              
              
              
              <form action="librarianHome.jsp" name="librLogout" method="post">
	              <div class="dropdown">
	                <button class="btn btn-outline-success dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Username</button>
	                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	                  <a class="dropdown-item" href="librSettings.html">Settings</a>
	                  <input class="dropdown-item" id="librLogout" name="librLogout" type="submit" 
               value="Log out">
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
    
    
    
    
    
    
    
    
    
    
    <form action="librarianHome.jsp" name=updateSeatsBtn method="post">
    <div class="row" id="updateSeatsContent">
 		<div class="col-6" id="updateSeatsContentColSx">
 			<div class="row">
			    <div class="container" id="titleUpdateSeats">
			    	<h1 align=center><br><br>Update seats:</h1> 
			    </div>
			</div>
			
				<div class="container" id="updateSeats" style=" text-align: center;">
					<div id="piechart_3d" style="width: 700px; height: 350px; align-content: center;">
					</div>
					<!-- button + e - da inserire -->
					<div class="container" id="buttonUpdateSeats" style=" text-align: center; vertical-align: top;">
				        <a href="#" class="btn btn-outline-success mx-auto" role="button" style="width: 100px; height: 50px;">+</a>
				        <a href="#" class="btn btn-outline-danger mx-auto" role="button" style="width: 100px; height: 50px;">-</a>
					</div>
			    </div>
			
		</div>
		</form>
		
		
		
		
		
		
		
		
		
		
		


		<div class="col-6">

			    <div class="container" id="titleBookings">
			    	<h1 align=center><br><br>Bookings:</h1> 
			    </div>
		

			    <div class="table-wrapper-scroll-y my-custom-scrollbar" id="tableBookingsDiv">

				    <table id="tableBookings" class="table table-striped table-bordered table-sm" style="text-align: center;" cellspacing="20" width="100%">

					  <thead>
					    <tr>
					      <th>Username</th>
					      <th>Time</th>
					      <th>Check</th>
					    </tr>
					  </thead>

					  <tbody>

					    <tr>
					      <td>
					        <button type="button" class="btn btn-teal btn-rounded btn-sm m-0">Username1</button>
					      </td>
					      <td>12.34</td>
					      <td><button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">V</button><button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">X</button></td>
					    </tr>

					    <tr>
					      <td>
					        <button type="button" class="btn btn-teal btn-rounded btn-sm m-0">Username2</button>
					      </td>
					      <td>12.36</td>
					      <td><button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">V</button><button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">X</button></td>
					    </tr>

					    <tr>
					      <td>
					        <button type="button" class="btn btn-teal btn-rounded btn-sm m-0">Username3</button>
					      </td>
					      <td>12.37</td>
					      <td><button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">V</button><button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">X</button></td>
					    </tr>

					    <tr>
					      <td>
					        <button type="button" class="btn btn-teal btn-rounded btn-sm m-0">Username4</button>
					      </td>
					      <td>12.37</td>
					      <td><button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">V</button><button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">X</button></td>
					    </tr>

					    <tr>
					      <td>
					        <button type="button" class="btn btn-teal btn-rounded btn-sm m-0">Username5</button>
					      </td>
					      <td>12.38</td>
					      <td><button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">V</button><button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">X</button></td>
					    </tr>

					    <tr>
					      <td>
					        <button type="button" class="btn btn-teal btn-rounded btn-sm m-0">Username6</button>
					      </td>
					      <td>12.40</td>
					      <td><button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">V</button><button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">X</button></td>
					    </tr>

					    <tr>
					      <td>
					        <button type="button" class="btn btn-teal btn-rounded btn-sm m-0">Username7</button>
					      </td>
					      <td>12.42</td>
					      <td><button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">V</button><button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">X</button></td>
					    </tr>

					    <tr>
					      <td>
					        <button type="button" class="btn btn-teal btn-rounded btn-sm m-0">Username8</button>
					      </td>
					      <td>12.43</td>
					      <td><button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">V</button><button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">X</button></td>
					    </tr>

					    <tr>
					      <td>
					        <button type="button" class="btn btn-teal btn-rounded btn-sm m-0">Username9</button>
					      </td>
					      <td>12.45</td>
					      <td><button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">V</button><button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">X</button></td>
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


<%
 if(request.getParameter("add") != null) {
	 LibraryMainPageController.getLibraryMainPageController().updateSeats("+");
	 LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
	 %> <jsp:forward page="librarianHome.jsp"/> <%
 }

if(request.getParameter("del") != null) {
	 LibraryMainPageController.getLibraryMainPageController().updateSeats("-");
	 LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
	 %> <jsp:forward page="librarianHome.jsp"/> <%
}
 
%>