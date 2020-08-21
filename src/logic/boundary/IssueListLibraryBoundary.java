package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import logic.application.Main;
import logic.constants.FxmlConstants;
import logic.control.ReportIssueController;
import logic.entity.Library;
import logic.pattern.Observer;

public class IssueListLibraryBoundary extends FxmlGUI implements Observer {

	@FXML private Button btnDelete;
	@FXML private Button btnOpen;
	@FXML private Button btnBack;
	@FXML private Label lbStatus;
	@FXML private Label lbUser;
	@FXML private ListView<String> lvReports;
	private ReportIssueController reportIssueController;
	private Scene homeLibrarianGuiScene;
	private Main main;
	
	public IssueListLibraryBoundary(Library sessionLibrary, Scene homeLibrarianGuiScene, Main main) {
		this.reportIssueController=new ReportIssueController(sessionLibrary);
		this.homeLibrarianGuiScene= homeLibrarianGuiScene;
		this.main=main;
		sessionLibrary.attachObserver(this);
	}
	
	@FXML
	public void openClicked(ActionEvent event) {
		this.reportIssueController.fillBeanWithSelectedReport(parseReportId(this.lvReports.getSelectionModel().getSelectedItem()));
		guiLoader(FxmlConstants.REPORT_DETAILS_LIBRARIAN_GUI,new ReportDetailsLibrarianBoundary(this.reportIssueController,this),event);
	}
	
	@FXML
	public void deleteClicked(ActionEvent event) {
		this.reportIssueController.deleteReport(parseReportId(this.lvReports.getSelectionModel().getSelectedItem()));
	}
	
	@FXML
	public void backClicked(ActionEvent event) {
		main.getStage().setScene(this.homeLibrarianGuiScene);
		main.getStage().show();
	}
	
	private long parseReportId(String selectedItem) {
		String[] splittedStrings=selectedItem.split("    ");
		return Long.parseLong(splittedStrings[0]);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.lbUser.setText(this.reportIssueController.getSessionUser().getUsername());
		this.reportIssueController.getLibraryReports();
	}

	@Override
	public void update() {
		for(int i=0;i<this.reportIssueController.getSessionUser().getReports().size();i++) {
			if(!lvReports.getItems().contains(this.reportIssueController.getSessionUser().getReports().get(i).getMainInfoForLibrarian())) {
				this.lvReports.getItems().add(this.reportIssueController.getSessionUser().getReports().get(i).getMainInfoForLibrarian());
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