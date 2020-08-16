package logic.boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.bean.ReportBean;
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxml/IssueListStudentGUI.fxml"));
		loader.setController(this.issueListStudentBoundary);
		BorderPane nextParent = null;
		try {
			nextParent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
        Scene nextScene = new Scene(nextParent, 800, 600);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.btnSendReport.setText("Send");
		this.lbUser.setText(this.reportIssueController.getSessionUser().getUsername());
	}

	
	
}