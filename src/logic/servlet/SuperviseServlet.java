package logic.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.bean.LibrBean;
import logic.control.LibrarianSuperviseController;
import logic.control.SuperviseController;

/**
 * Servlet implementation class SuperviseServlet
 */
public class SuperviseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibrarianSuperviseController superviseController;
	private List<String> usernameList;
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuperviseServlet() {
        super();
        superviseController = new SuperviseController();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		LibrBean libraryBean = (LibrBean)request.getSession().getAttribute("libraryBean");
		usernameList = superviseController.fillSupervisePage(libraryBean.getMail());
		request.setAttribute("usernameList", usernameList);
		request.getRequestDispatcher("SupervisePage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
