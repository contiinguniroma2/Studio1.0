package logic.boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import logic.control.ReportIssueController;
import logic.exceptions.ReportDeleteException;

public abstract class IssueListBoundary extends FxmlGUI{
	
	@FXML protected Button btnDelete;
	@FXML protected Button btnOpen;
	@FXML protected Button btnBack;
	@FXML protected Label lbStatus;
	@FXML protected Label lbUser;
	@FXML protected ListView<String> lvReports;
	protected ReportIssueController reportIssueController;
	
	@FXML
	public abstract void openClicked(ActionEvent event); 
	
	@FXML
	public abstract void backClicked(ActionEvent event);
	
	@FXML
	public void deleteClicked(ActionEvent event) {
		try {
			this.reportIssueController.deleteReport(parseReportId(this.lvReports.getSelectionModel().getSelectedItem()));
		} catch (ReportDeleteException e) {
			this.lbStatus.setText("Report delete failed");
			e.printStackTrace();
		}
	}
	
	public long parseReportId(String selectedItem) {
		String[] splittedStrings=selectedItem.split("    ");
		return Long.parseLong(splittedStrings[0]);
	}
	

}
