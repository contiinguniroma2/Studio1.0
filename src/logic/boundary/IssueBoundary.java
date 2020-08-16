package logic.boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.control.ReportIssueController;

public class IssueBoundary implements Initializable {
	
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
		this.lbUser.setText(this.reportIssueController.getSessionUser().getUsername());
		this.tvTitle.setText(this.reportIssueController.getReportBean().getTitle());
		this.tvDescription.setText(this.reportIssueController.getReportBean().getDescription());
	}
	
	
}