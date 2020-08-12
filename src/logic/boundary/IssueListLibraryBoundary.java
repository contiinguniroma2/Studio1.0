package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class IssueListLibraryBoundary extends BaseLibraryBoundary {

	@FXML private Button btnDelete;
	@FXML private Button btnOpen;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//Riempire la label lbUser con nome, via, citta, telefono della biblioteca
		lvReports.getItems().addAll("Prova", "BOH");
		//new del controller reportIssue
	}

}
