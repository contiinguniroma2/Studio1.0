package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class IssueListStudentBoundary extends BaseStudentBoundary {
	
	@FXML private Button btnDelete;
	@FXML private Button btnOpen;
	@FXML private Button btnSendReport;
	@FXML private ListView<String> lvReports;
	//private ReportIssueController reportIssueController;
	
	public void openClicked() {
		//TODO
	}
	
	public void deleteClicked() {
		//TODO
	}
	
	@Override
	public void backClicked() {
		// TODO Auto-generated method stub
		
	}
	
	public void sendReportClicked() {
		//TODO
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Riempire la label lbUser con nome dell utente
		lvReports.getItems().addAll("Prova", "BOH");
		//new del controller reportIssue
		
	}
	
	
}