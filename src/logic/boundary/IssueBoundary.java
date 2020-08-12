package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

public class IssueBoundary implements Initializable {
	
	@FXML protected Button btnBack;
	@FXML protected Button btnDelete;
	@FXML protected Button btnOpen;
	@FXML protected Button btnSearchSeat;
	@FXML protected Button btnMessages;
	@FXML protected Button btnLogout;
	@FXML protected Button btnUserPic;
	@FXML protected ListView<String> lvReports;
	@FXML protected Label lbStatus;
	@FXML protected ImageView ivBtnUserPic;
	@FXML protected Label lbUser;
	//protected ReportIssueController reportIssueController;
	
	public void openClicked() {
		//TODO
	}
	
	public void deleteClicked() {
		//TODO
	}
	
	public void backClicked() {
		//TODO
	}
	
	public void searchSeatClicked() {
		//TODO
	}
	
	public void logoutClicked() {
		//TODO
	}
	
	public void messagesClicked() {
		//TODO
	}
	
	public void userProfileClicked() {
		//TODO
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		lvReports.getItems().addAll("Prova", "BOH");
		//new del controller
		
	}
	
	
}