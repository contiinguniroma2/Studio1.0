package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import logic.control.ReportIssueController;

public class ReportFormBoundary extends IssueStudentBoundary {
	
	@FXML private Button btnSendReport;
	private ReportIssueController reportIssueController;
	
	public void sendReportClicked() {
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Riempire la label lbUser con nome dell utente
		//passare il controller in qualche modo
		
	}
	
}