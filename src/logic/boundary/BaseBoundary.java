package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public abstract class BaseBoundary extends FxmlGUI{
	
	@FXML protected Button btnBack;
	@FXML protected Button btnLogout;
	@FXML protected Button btnUserPic;
	@FXML protected Label lbStatus;
	@FXML protected Label lbUser;
	@FXML protected ImageView ivBtnUserPic;
	
	public abstract void backClicked(ActionEvent event);
	
	public abstract void userProfileClicked(ActionEvent event);
	
	public void logoutClicked(ActionEvent event) {
		//TODO
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//default
	}

}