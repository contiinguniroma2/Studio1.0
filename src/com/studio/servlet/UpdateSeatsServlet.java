package com.studio.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.bean.LibrBean;
import logic.control.LibraryMainPageController;

/**
 * Servlet implementation class UpdateSeatsServlet
 */
public class UpdateSeatsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSeatsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibrBean libraryBean = LibraryMainPageController.getLibraryMainPageController().getLibrInfoB();
		request.setAttribute("libraryBean", libraryBean);
		request.setAttribute("free", libraryBean.getCapacity()-libraryBean.getPostiOccupati()-LibraryMainPageController.getLibraryMainPageController().getBooks().size());
        request.setAttribute("booked", LibraryMainPageController.getLibraryMainPageController().getBooks().size());
        request.getRequestDispatcher("librarianHome.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean addButtonPressed = request.getParameter("+") != null;
		String input = null;
		if(addButtonPressed) {
			input="+";
		}
		else {
			input="-";
		}
		LibraryMainPageController.getLibraryMainPageController().updateSeats(input);
		try {
			LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		LibrBean libraryBean = LibraryMainPageController.getLibraryMainPageController().getLibrInfoB();
		request.setAttribute("libraryBean", libraryBean);
		request.setAttribute("free", libraryBean.getCapacity()-libraryBean.getPostiOccupati()-LibraryMainPageController.getLibraryMainPageController().getBooks().size());
        request.setAttribute("booked", LibraryMainPageController.getLibraryMainPageController().getBooks().size());
        request.getRequestDispatcher("librarianHome.jsp").forward(request, response);
	}

}
