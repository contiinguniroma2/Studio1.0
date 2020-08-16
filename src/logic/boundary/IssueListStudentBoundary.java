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
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.control.ReportIssueController;
import logic.entity.Library;
import logic.entity.Student;
import logic.pattern.Observer;

public class IssueListStudentBoundary implements Observer, Initializable{
	
	@FXML private Button btnDelete;
	@FXML private Button btnOpen;
	@FXML private Button btnSendReport;
	@FXML private Button btnBack;
	@FXML private Label lbStatus;
	@FXML private Label lbUser;
	@FXML private ListView<String> lvReports;
	private ReportIssueController reportIssueController;
	private StudentSearchResultFxmlGUI studentSearchResultFxmlGui;
	
	public IssueListStudentBoundary(Student sessionStudent, Library currentLibrary, StudentSearchResultFxmlGUI studentSearchResultFxmlGui) {
		this.studentSearchResultFxmlGui=studentSearchResultFxmlGui;
		this.reportIssueController=new ReportIssueController(sessionStudent,currentLibrary);
		sessionStudent.attachObserver(this);
	}
	
	@FXML
	public void openClicked(ActionEvent event) {
		this.reportIssueController.fillBeanWithSelectedReport(parseReportId(this.lvReports.getSelectionModel().getSelectedItem()));
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxml/IssueGUI.fxml"));
		loader.setController(new IssueBoundary(this.reportIssueController,this));
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
	
	private long parseReportId(String selectedItem) {
		String[] splittedStrings=selectedItem.split("    ");
		return Long.parseLong(splittedStrings[0]);
	}

	@FXML
	public void deleteClicked(ActionEvent event) {
		this.reportIssueController.deleteReport(parseReportId(this.lvReports.getSelectionModel().getSelectedItem()));
	}
	
	@FXML
	public void backClicked(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxml/StudentSearchResultGUI.fxml"));
		loader.setController(this.studentSearchResultFxmlGui);
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
	
	@FXML
	public void sendReportClicked(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxml/ReportFormGUI.fxml"));
		loader.setController(new ReportFormBoundary(this.reportIssueController,this));
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
		this.reportIssueController.getStudentReports();
	}

	@Override
	public void update() {
		for(int i=0;i<this.reportIssueController.getSessionUser().getReports().size();i++) {
			if(!lvReports.getItems().contains(this.reportIssueController.getSessionUser().getReports().get(i).getMainInfoForStudent())) {
				this.lvReports.getItems().add(this.reportIssueController.getSessionUser().getReports().get(i).getMainInfoForStudent());
			}
		}
		
		boolean itsIn;
		for(int i=0; i<this.lvReports.getItems().size(); i++) {
			itsIn=false;
			for(int j=0; j<this.reportIssueController.getSessionUser().getReports().size(); j++) {
				if(parseReportId(lvReports.getItems().get(i))==this.reportIssueController.getSessionUser().getReports().get(j).getReportId()) {
					itsIn=true;
					break;
				}
			}
			if(!itsIn) {
				lvReports.getItems().remove(i);
				break;
			}
			
		}
		
	}
	
	
}