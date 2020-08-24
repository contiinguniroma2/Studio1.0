package logic.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.bean.ReportBean;
import logic.control.ReportIssueController;
import logic.exceptions.EmptyTextFieldException;
import logic.exceptions.ReportDeleteException;

public class ReportListStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public ReportListStudentServlet() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReportIssueController reportIssueController=(ReportIssueController) request.getSession().getAttribute("reportIssueController");
		for (Integer i=0; i<reportIssueController.getSessionUser().getReports().size(); i++) {
			if (request.getParameter("btnOpen".concat((reportIssueController.getSessionUser().getReports().get(i).getReportId()).toString())) != null) {
					ReportBean selectedReport=null;
					try {
						selectedReport = new ReportBean(reportIssueController.getSessionUser().getReports().get(i).getTitle(),reportIssueController.getSessionUser().getReports().get(i).getDescription());
					} catch (EmptyTextFieldException e) {
						e.printStackTrace();
					}
					request.getSession().setAttribute("selectedReport",selectedReport);
					request.getRequestDispatcher("StudentReportDetails.jsp").forward(request, response);
				
			
			}
			if (request.getParameter("btnDelete".concat((reportIssueController.getSessionUser().getReports().get(i).getReportId()).toString())) != null) {
				try {
					reportIssueController.deleteReport(reportIssueController.getSessionUser().getReports().get(i).getReportId());
					request.getRequestDispatcher("ReportListStudent.jsp").forward(request, response);
				} catch (ReportDeleteException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		
		
	}
	

}
