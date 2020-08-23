<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Stud.io</title>
</head>
<body>
 <!-- navbar -->
    <div class="container">
      <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">Stud.io</a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav ml-auto"> <!-- "ml-auto" consente di allineare item a destra-->
         
            <li class="nav-item active">
            <form action="UpdateSeatsServlet" name="UpdateSeatsForm" method="GET">
              <a><input class="btn btn-secondary" type="submit" role="button" value="Update seats"></a>
              </form>
            </li>
            <li class="nav-item">
              <a class="btn btn-secondary" href="librarianTimetable.html">Time table</a>
            </li>
            <li class="nav-item">
              <a class="btn btn-secondary" href="librarianNoticeboard.html">Noticeboard</a>
            </li>
            <li class="nav-item">
             <form action="SuperviseServlet" name="SuperviseForm" method="GET">
              <a><input class="btn btn-success mx-auto" type="submit" role="button" value="Recent students"></a>
              </form>
            </li>
            <li class="nav-item">
              <a class="btn btn-secondary" href="librarianStatistics.html">Statistics</a>
            </li>
            <li class="nav-item">
              <a class="btn btn-secondary" href="librarianSettings.html">Settings</a>
            </li>
            <li class="nav-item">
              <a class="btn btn-secondary" href="index.html">Log out</a>
            </li>
           </ul>
          </div>
        </nav>
     </div>
    <!-- END navbar -->

 

</body>
</html>