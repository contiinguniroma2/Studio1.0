package com.studio.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.control.LibraryMainPageController;
import logic.control.LoginController;
import logic.control.StudentMainPageController;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	LoginController loginController; 
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        loginController = new LoginController();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	    	if (loginController.validateUser(request.getParameter("emailLogin"), request.getParameter("passwordLogin")) == 's') {
	    	    StudentMainPageController.getStudentMainPageController().setStudInfo(loginController.getStudent());
		        StudentMainPageController.getStudentMainPageController().setStudInfoB(loginController.getStudentBean());
		        response.sendRedirect("studentHome.jsp");
		        
	    	}	
		    else if (loginController.validateUser(request.getParameter("emailLogin"), request.getParameter("passwordLogin")) == 'l') {
		    	LibraryMainPageController.getLibraryMainPageController().setLibrInfo(loginController.getLibrary());
		        LibraryMainPageController.getLibraryMainPageController().setLibrInfoB(loginController.getLibrBean());
		        response.sendRedirect("librarianHome.jsp");
	        }
		    else {
		    	response.sendRedirect("erroreLogin.html");
		    }
		}
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}

}
