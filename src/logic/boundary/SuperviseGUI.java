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

	public Button createBtnSupervise(String nameBtn) {
		Button btnUser = new Button(nameBtn);
		btnUser.setMinWidth(400);
		btnUser.setMinHeight(40);
		return btnUser;
	}

	public VBox superviseGUI() {
		Label titleSupervisePage = createLabel("Studenti con cui hai interagito recentemente", 24);
		
		VBox content;

		HBox hBoxColumns = new HBox();
		hBoxColumns.setSpacing(20);
		hBoxColumns.setMaxHeight(300);

		ScrollPane spUsers = new ScrollPane();
	


		VBox vBoxUser = createPanel(createBtnSupervise("user556"), createBtnSupervise("user383"),
				createBtnSupervise("user202"), createBtnSupervise("user35285"),
				createBtnSupervise("usr2"), createBtnSupervise("usr54"), createBtnSupervise("user234"),
				createBtnSupervise("user5648"), createBtnSupervise("user568"),
				createBtnSupervise("user5348"), createBtnSupervise("user46575"),
				createBtnSupervise("user534"), createBtnSupervise("user5623335"));
		vBoxUser.setMaxSize(300, 300);
		vBoxUser.setAlignment(Pos.TOP_CENTER);
		vBoxUser.setSpacing(0);


		spUsers.setContent(vBoxUser);
		spUsers.setMinSize(300, 300);
		spUsers.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		spUsers.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		

		hBoxColumns.getChildren().addAll(spUsers);

		content = createPanel(titleSupervisePage, hBoxColumns);
		//content.setMaxWidth(500);
		//content.setPadding(new Insets(20, 0, 20, 0));
		
		
	
		return content;
	}

	public void createBehaviorCheckGUI(Main main) {

		root = (BorderPane) main.getScene().getRoot();
		root.setCenter(superviseGUI());
		main.getScene().setRoot(root);

	}
}
