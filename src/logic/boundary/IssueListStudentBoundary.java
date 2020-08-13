package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import logic.control.ReportIssueController;
import logic.entity.Student;
import logic.entity.User;
import logic.pattern.Observer;

public class IssueListStudentBoundary extends BaseStudentBoundary implements Observer{
	
	@FXML private Button btnDelete;
	@FXML private Button btnOpen;
	@FXML private Button btnSendReport;
	@FXML private ListView<String> lvReports;
	private ReportIssueController reportIssueController;
	private User sessionUser;
	
	public IssueListStudentBoundary(Student sessionStudent) {
		this.sessionUser=sessionStudent;
		this.reportIssueController=new ReportIssueController(sessionStudent);
		sessionStudent.attachObserver(this);
	}
	
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
		this.lbUser.setText(this.sessionUser.getUsername());
		//lvReports.getItems().addAll("Prova", "BOH");
		this.reportIssueController.getStudentReports();
	}

	@Override
	public void update() {
		for(int i=0;i<this.sessionUser.getReports().size();i++) {
			if(!lvReports.getItems().contains(sessionUser.getReports().get(i).getMainInfoForStudent()))
			this.lvReports.getItems().add(sessionUser.getReports().get(i).getMainInfoForStudent());
		}
		
	}
	
	
}