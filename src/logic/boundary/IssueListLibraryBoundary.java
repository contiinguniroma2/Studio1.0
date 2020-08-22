package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import logic.application.Main;
import logic.constants.FxmlConstants;
import logic.control.ReportIssueController;
import logic.entity.Library;

public class IssueListLibraryBoundary extends IssueListBoundary {

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
		this.reportIssueController.readIssue();
		guiLoader(FxmlConstants.REPORT_DETAILS_LIBRARIAN_GUI,new ReportDetailsLibrarianBoundary(this.reportIssueController,this),event);
	}
	
	
	@FXML
	public void backClicked(ActionEvent event) {
		main.getStage().setScene(this.homeLibrarianGuiScene);
		main.getStage().show();
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.lbUser.setText(this.reportIssueController.getSessionUser().getName());
		this.reportIssueController.getLibraryReports();
	}


}