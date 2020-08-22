package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.constants.FxmlConstants;
import logic.control.ReportIssueController;
import logic.entity.Library;
import logic.entity.Student;

public class IssueListStudentBoundary extends IssueListBoundary{
	
	@FXML private Button btnSendReport;
	private StudentSearchResultFxmlGUI studentSearchResultFxmlGui;
	
	public IssueListStudentBoundary(Student sessionStudent, Library currentLibrary, StudentSearchResultFxmlGUI studentSearchResultFxmlGui) {
		this.studentSearchResultFxmlGui=studentSearchResultFxmlGui;
		this.reportIssueController=new ReportIssueController(sessionStudent,currentLibrary);
		sessionStudent.attachObserver(this);
	}
	
	@FXML
	public void openClicked(ActionEvent event) {
		this.reportIssueController.fillBeanWithSelectedReport(parseReportId(this.lvReports.getSelectionModel().getSelectedItem()));
		guiLoader(FxmlConstants.ISSUE_GUI,new IssueBoundary(this.reportIssueController,this),event);
	}
	
	
	@FXML
	public void backClicked(ActionEvent event) {
		guiLoader(FxmlConstants.STUDENT_SEARCH_RESULT_GUI,this.studentSearchResultFxmlGui,event);
		
	}
	
	@FXML
	public void sendReportClicked(ActionEvent event) {
		guiLoader(FxmlConstants.REPORT_FORM_GUI,new ReportFormBoundary(this.reportIssueController,this),event);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.lbUser.setText(this.reportIssueController.getSessionUser().getUsername());
		this.reportIssueController.getStudentReports();
	}

	
	
}