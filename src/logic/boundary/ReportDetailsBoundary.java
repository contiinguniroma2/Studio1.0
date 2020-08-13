package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.control.ReportIssueController;

public class ReportDetailsBoundary extends IssueLibraryBoundary {
	
	@FXML private Button btnSolve;
	@FXML private Button btnReportUser;
	private ReportIssueController reportIssueController;
	
	public void solveClicked() {
		//TODO
	}
	
	public void reportUserClicked() {
		//TODO
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Riempire la label lbUser con nome dell utente
		//passare il controller in qualche modo
		
	}
	
}