<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="logic.control.StudentMainPageController" %> 
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
              <form action="studentHome.html" name="studLogout" method="post">
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
    <!-- END navbar -->


    <!-- CONTENT -->    


		<div>

			    <div class="container" id="titleReportsDiv">
			    	<h1 align=center><br><br>Your reports:</h1> 
			    </div>
		

			    <div class="table-wrapper-scroll-y my-custom-scrollbar" id="tableReportsDiv">

				    <table id="tableBookings" class="table table-striped table-bordered table-sm" style="text-align: center;" cellspacing="20" width="100%">

					  <thead>
					    <tr>
					      <th>Report id</th>
					      <th>Object</th>

					      <th><button type="button" class="btn btn-success mr-auto">Send report</button>
                </th>
					    </tr>
					  </thead>

					  <tbody>

					    <tr>
					    	<td>1234</td>
					    	<td>Bagno rotto</td>
					    	<td>
						      	<button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">Open</button>
						      	<button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">Delete</button>
					  		</td>
					    </tr>

					    <tr>
					      <td>1235</td>
					    	<td>Montascale rotto</td>
					    	<td>
						      	<button type="button" class="btn btn-outline-success btn-rounded btn-sm m-0">Open</button>
						      	<button type="button" class="btn btn-outline-danger btn-rounded btn-sm m-0">Delete</button>
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

