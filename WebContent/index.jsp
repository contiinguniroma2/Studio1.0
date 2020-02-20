<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%
  if(request.getParameter("user") != null) { %>
  	<jsp:forward page="login.jsp"/> <%
  }
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

    <!-- navbar -->
    <div class="container">
      <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="index.html">Stud.io<span class="sr-only">(current)</span></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
      </nav>
    </div>
    <!-- END navbar -->

    <div class="row">
	<div class="container" id="logo">
      <p><img src="img/logo_button.png" align=center></p>
    </div>
    <div class="container" align="center">
    
    
    
    
    
    
    <form action="index.jsp" name="indexPage" method="post">
      <h1 align=center><br><br>LOGIN</h1>
      <h3 align=center>Please select a user:</h3>
      <p class="text-center">
        <input class="btn btn-success mx-auto" role="button" name="user" type="submit"
               id="user" value="User">
        <input class="btn btn-success mx-auto" role="button" name="guest" type="submit"
               id="guest" value="Guest">
      </p>
    </form>
    
    
    
    
    
    </div>
    </div>
	
	<div class="row">
    <div class="container">
      <h3 align=center><br>if you are not registered yet:<br></h3>
      <p class="text-center">
        <a href="signIn_selectUser.html" class="btn btn-success mx-auto" role="button">Sign in</a>
      </p>
    </div>
    </div>

    <!-- jQuery e plugin JavaScript  -->
   <script src="http://code.jquery.com/jquery.js"></script>
   <script src="js/bootstrap.min.js"></script>
</body>
</html>