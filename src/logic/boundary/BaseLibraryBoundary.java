package logic.boundary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public abstract class BaseLibraryBoundary extends BaseBoundary{
	
	@FXML protected Button btnUpdateSeats;
	@FXML protected Button btnNoticeBoard;
	@FXML protected Button btnTimeTable;
	@FXML protected Button btnServices;
	@FXML protected Button btnUserBehavior;
	@FXML protected Button btnStatistics;
	
	public void statisticsClicked(ActionEvent event) {
		//TODO
	}
	
	public void userBehaviorClicked(ActionEvent event) {
		//TODO
	}
	
	public void timeTableClicked(ActionEvent event) {
		//TODO
	}
	
	public void servicesClicked(ActionEvent event) {
		//TODO
	}
	
	public void noticeBoardClicked(ActionEvent event) {
		//TODO
	}
	
	@Override
	public void userProfileClicked(ActionEvent event) {
		// TODO Auto-generated method stub
	}
	
	public void updateSeatsClicked(ActionEvent event) {
		//TODO
	}
	
}
	