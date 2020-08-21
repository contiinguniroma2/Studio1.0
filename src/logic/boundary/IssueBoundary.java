package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import logic.constants.FxmlConstants;
import logic.control.ReportIssueController;

public class IssueBoundary extends FxmlGUI {
	
	@FXML protected TextField tvTitle;
	@FXML protected TextArea tvDescription;
	@FXML protected Button btnBack;
	@FXML protected Label lbUser;
	@FXML protected Label lbStatus;
	protected ReportIssueController reportIssueController;
	protected IssueListStudentBoundary issueListStudentBoundary;
	
	public IssueBoundary(ReportIssueController reportIssueController, IssueListStudentBoundary issueListStudentBoundary) {
		this.reportIssueController=reportIssueController;
		this.issueListStudentBoundary=issueListStudentBoundary;
	}
	
	public IssueBoundary(ReportIssueController reportIssueController) {
		this.reportIssueController=reportIssueController;
	}
	
	public void backClicked(ActionEvent event) {
		guiLoader(FxmlConstants.ISSUE_LIST_STUDENT_GUI, this.issueListStudentBoundary, event);
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.lbUser.setText(this.reportIssueController.getSessionUser().getUsername());
		this.tvTitle.setText(this.reportIssueController.getReportBean().getTitle());
		this.tvDescription.setText(this.reportIssueController.getReportBean().getDescription());
	}
	
	
}