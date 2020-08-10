package logic.boundary;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;
import logic.control.SuperviseController;

public class SuperviseGUI extends LibrarianGUI {
	List<Button> infoAccountBtnList;
	SuperviseController superviseController;
	// InfoAccountSelectedGUI infoAccount;

	public SuperviseGUI() {
		infoAccountBtnList = new ArrayList<>(); //lista contenente tanti bottoni quanti sono gli utenti

	}

	public Button createBtnCheckBehavior(String nameBtn) {
		Button btnUser = new Button(nameBtn);
		btnUser.setMinWidth(300);
		btnUser.setMinHeight(40);
		return btnUser;
	}

	public VBox checkBehaviorGUI() {
		Label titleCheckBehavior = createLabel("User behavior", 24);
		Label labelUsers = createLabel("Registred users:", 16);
		Label labelFeedback = createLabel("Feedback:", 16);

		VBox content;

		HBox hBoxTitleColumns = new HBox();
		hBoxTitleColumns.getChildren().addAll(labelUsers, labelFeedback);
		hBoxTitleColumns.setSpacing(225);
		hBoxTitleColumns.setAlignment(Pos.CENTER);

		HBox hBoxColumns = new HBox();
		hBoxColumns.setSpacing(20);
		hBoxColumns.setMaxHeight(300);

		ScrollPane spUsers = new ScrollPane();
	


		VBox vBoxUser = createPanel(createBtnCheckBehavior("user556"), createBtnCheckBehavior("user383"),
				createBtnCheckBehavior("user202"), createBtnCheckBehavior("user35285"),
				createBtnCheckBehavior("usr2"), createBtnCheckBehavior("usr54"), createBtnCheckBehavior("user234"),
				createBtnCheckBehavior("user5648"), createBtnCheckBehavior("user568"),
				createBtnCheckBehavior("user5348"), createBtnCheckBehavior("user46575"),
				createBtnCheckBehavior("user534"), createBtnCheckBehavior("user5623335"));
		vBoxUser.setMaxSize(300, 300);
		vBoxUser.setAlignment(Pos.TOP_CENTER);
		vBoxUser.setSpacing(0);


		spUsers.setContent(vBoxUser);
		spUsers.setMinSize(300, 300);
		spUsers.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		spUsers.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		

		hBoxColumns.getChildren().addAll(spUsers);

		content = createPanel(titleCheckBehavior, hBoxTitleColumns, hBoxColumns);
		content.setPadding(new Insets(20, 0, 20, 0));
		
		
		

		return content;
	}

	public void createBehaviorCheckGUI(Main main) {

		root = (BorderPane) main.getScene().getRoot();
		root.setCenter(checkBehaviorGUI());
		main.getScene().setRoot(root);

	}
}
