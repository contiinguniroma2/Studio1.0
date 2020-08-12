+package logic.boundary;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public abstract class BaseBoundary implements Initializable{
	
	@FXML protected Button btnBack;
	@FXML protected Button btnLogout;
	@FXML protected Button btnUserPic;
	@FXML protected Label lbStatus;
	@FXML protected Label lbUser;
	@FXML protected ImageView ivBtnUserPic;
	
	public abstract void backClicked();
	
	public abstract void userProfileClicked();
	
	public void logoutClicked() {
		//TODO
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//default
	}

}