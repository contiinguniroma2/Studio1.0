package logic.boundary;

import java.net.URL;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import logic.constants.FxmlConstants;
import logic.control.LibrarianSuperviseController;
import logic.control.ReportIssueController;
import logic.control.SuperviseController;
import logic.exceptions.ReportUpdateException;

public class ReportDetailsLibrarianBoundary extends IssueBoundary {
	
	@FXML private Button btnSolve;
	@FXML private Button btnReportUser;
	private IssueListLibraryBoundary issueListLibraryBoundary;
	private LibrarianSuperviseController superviseController;
	
	public ReportDetailsLibrarianBoundary(ReportIssueController reportIssueController, IssueListLibraryBoundary issueListLibraryBoundary) {
		super(reportIssueController);
		this.reportIssueController=reportIssueController;
		this.issueListLibraryBoundary=issueListLibraryBoundary;
		superviseController = new SuperviseController();
	}
	
	@FXML
	public void solveClicked(ActionEvent event) {
		try {
			this.reportIssueController.solveIssue();
		} catch (ReportUpdateException e) {
			this.lbStatus.setText("Report solving failed");
			e.printStackTrace();
		}
		this.backClicked(event);
	}
	
	@FXML
	public void reportUserClicked(ActionEvent event) {
		try {
			// alert confirm student report
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Confirmation report");
			alert.setHeaderText("Warning!");
			alert.setContentText("Are you sure you want to report account?");
			if (alert.showAndWait().get() == ButtonType.OK) {
				superviseController.increaseReportingCounter(this.reportIssueController.getReportBean().getStudentId(), this.reportIssueController.getSessionUser().getMail(), "feedback");
				this.reportIssueController.deleteReport(this.reportIssueController.getReportBean().getReportId());
			}
		} catch (NoSuchElementException e) {
			// if this exception is caught, no need to do anything
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		this.backClicked(event);
	}
	
	@Override
	public void backClicked(ActionEvent event) {
		guiLoader(FxmlConstants.ISSUE_LIST_LIBRARY_GUI, this.issueListLibraryBoundary, event);	
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.lbUser.setText(this.reportIssueController.getSessionUser().getName());
		this.tvTitle.setText(this.reportIssueController.getReportBean().getTitle());
		this.tvDescription.setText(this.reportIssueController.getReportBean().getDescription());
		
	}

	
}