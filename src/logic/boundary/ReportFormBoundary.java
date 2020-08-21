package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.bean.ReportBean;
import logic.constants.FxmlConstants;
import logic.control.ReportIssueController;
import logic.exceptions.ReportSaveException;

public class ReportFormBoundary extends IssueBoundary {

	@FXML private Button btnSendReport;
	
	public ReportFormBoundary(ReportIssueController reportIssueController,
			IssueListStudentBoundary issueListStudentBoundary) {
		super(reportIssueController, issueListStudentBoundary);
		this.issueListStudentBoundary=issueListStudentBoundary;
		this.reportIssueController=reportIssueController;
	}
	
	@FXML
	public void sendReportClicked(ActionEvent event) {
		try {
			this.reportIssueController.sendReport(new ReportBean(tvTitle.getText(),tvDescription.getText()));
		} catch (ReportSaveException e) {
			this.lbStatus.setText("Report send failed check the fields and try again.");
			this.btnSendReport.setText("Try again");
			e.printStackTrace();
		}
		
		guiLoader(FxmlConstants.ISSUE_LIST_STUDENT_GUI,this.issueListStudentBoundary,event);

	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.btnSendReport.setText("Send");
		this.lbUser.setText(this.reportIssueController.getSessionUser().getUsername());
	}

	
	
}