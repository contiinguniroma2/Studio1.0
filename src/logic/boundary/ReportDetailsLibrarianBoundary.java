package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.control.ReportIssueController;

public class ReportDetailsLibrarianBoundary extends IssueBoundary {
	
	@FXML private Button btnSolve;
	@FXML private Button btnReportUser;
	private IssueListLibraryBoundary issueListLibraryBoundary;
	
	public ReportDetailsLibrarianBoundary(ReportIssueController reportIssueController, IssueListLibraryBoundary issueListLibraryBoundary) {
		super(reportIssueController);
		this.reportIssueController=reportIssueController;
		this.issueListLibraryBoundary=issueListLibraryBoundary;
	}
	
	@FXML
	public void solveClicked(ActionEvent event) {
		//TODO
	}
	
	@FXML
	public void reportUserClicked(ActionEvent event) {
		//TODO
	}
	
	@Override
	public void backClicked(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Riempire la label lbUser con nome dell utente
		//passare il controller in qualche modo
		
	}

	
}