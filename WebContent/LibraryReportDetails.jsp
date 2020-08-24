<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="logic.bean.ReportBean"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Stud.io</title>
    <link href="css/style.css" type="text/css" rel="stylesheet">
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">
<title>Insert title here</title>
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
             <a class="btn btn-success mx-auto" href="ReportListLibrarY.jsp">Reports</a></li>
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
    
    <div>

		<div class="container" id="Report details:">
			<h1 align=center>
				<br>
				<br>Report details:
			</h1>
		</div>

		<div class="container" id="Report details:">
			<form action="${pageContext.request.contextPath}/ReportDetailsLibraryServlet" name="reportLibraryDetails" method="POST">
			<label for="reportTitle">Title</label> 
			<input
				readonly class="form-control" id="reportLibraryDetailsTitle" name="reportLibraryDetailsTitle" type="text"
				value="<%out.println(((ReportBean)request.getSession().getAttribute("selectedReport")).getTitle());%>">
		
			<div class="form-group">
				<label for="reportDescription">Description</label>
				 <textarea readonly
				 class="form-control" id="reportLibraryDetailsDescription" name="reportLibraryDetailsDescription"><%=((ReportBean)request.getSession().getAttribute("selectedReport")).getDescription()%></textarea>
			</div> 
			<div id="divLibraryDetailsButtons">
				<input class="btn btn-success mx-auto" role="button" name="btnSolve" type="submit"
               id="btnSolve" value="Solve">
               <form action="${pageContext.request.contextPath}/SuperviseServlet" name="reportUserForm" method="POST">
               <input class="btn btn-success mx-auto" role="button" name="btnReportUser" type="submit"
               id="btnReportUser" value="Report user">
               </form>
			</div>
			</form>
		</div>
		

	</div>
       <!-- jQuery e plugin JavaScript  -->
   <script src="http://code.jquery.com/jquery.js"></script>
   <script src="js/bootstrap.min.js"></script>
</body>
</html>