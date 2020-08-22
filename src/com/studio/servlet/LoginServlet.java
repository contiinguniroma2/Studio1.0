package com.studio.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.bean.LibrBean;
import logic.bean.StudentBean;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	    	if (loginController.validateUser(request.getParameter("emailLogin"), request.getParameter("passwordLogin")) == 's') {
	    	    StudentMainPageController.getStudentMainPageController().setStudInfo(loginController.getStudent());
		        StudentMainPageController.getStudentMainPageController().setStudInfoB(loginController.getStudentBean());
		        StudentBean studentBean = loginController.getStudentBean();
		        request.setAttribute("studentBean", studentBean);
		        
		        request.getRequestDispatcher("studentHome.jsp").forward(request, response);
		        
	    	}	
		    else if (loginController.validateUser(request.getParameter("emailLogin"), request.getParameter("passwordLogin")) == 'l') {
		    	LibraryMainPageController.getLibraryMainPageController().setLibrInfo(loginController.getLibrary());
		        LibraryMainPageController.getLibraryMainPageController().setLibrInfoB(loginController.getLibrBean());
		        LibrBean libraryBean = loginController.getLibrBean();
		        request.setAttribute("libraryBean", libraryBean);
		        LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
		        request.setAttribute("free", libraryBean.getCapacity()-libraryBean.getPostiOccupati()-LibraryMainPageController.getLibraryMainPageController().getBooks().size());
		        request.setAttribute("booked", LibraryMainPageController.getLibraryMainPageController().getBooksBean());   //Ritorna List<BookSeatBean>
		        request.getRequestDispatcher("librarianHome.jsp").forward(request, response);
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
