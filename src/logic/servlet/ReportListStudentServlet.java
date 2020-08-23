package logic.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.control.ReportIssueController;
import logic.entity.Library;
import logic.entity.Student;

public class ReportListStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected ReportIssueController reportIssueController;
	
	public ReportListStudentServlet(Student sessionStudent,Library currentLibrary) {
		super();
		this.reportIssueController=new ReportIssueController(sessionStudent, currentLibrary);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		//Da fare
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
		//Da fare
	}

}
