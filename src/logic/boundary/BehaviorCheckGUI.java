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

public class BehaviorCheckGUI extends LibrarianGUI {
	List<Button> btnListUsers;
	List<Button> btnListFeedback;
	
	public BehaviorCheckGUI() {
		btnListUsers = new ArrayList<>(); //lista contenente tanti bottoni quanti sono gli utenti
		btnListFeedback = new ArrayList<>(); //lista contenente tanti bottoni quanti sono i feedbacks

	}

	public Button createBtnCheckBehavior(String nameBtn) {
		Button btnUser = new Button(nameBtn);
		btnUser.setMinWidth(300);
		btnUser.setMinHeight(40);
		return btnUser;
	}

	public Button createBtnCheckBehaviorFeed(String nameBtn) {
		Button btnFeed = new Button(nameBtn);
		btnFeed.setMinWidth(300);
		btnFeed.setMinHeight(40);
		return btnFeed;
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
		ScrollPane spFeed = new ScrollPane();
	

		VBox vBoxUser = createPanel(createBtnCheckBehavior("user556"), createBtnCheckBehavior("user383"),
				createBtnCheckBehavior("user202"), createBtnCheckBehavior("user35285"),
				createBtnCheckBehavior("usr2"), createBtnCheckBehavior("usr54"), createBtnCheckBehavior("user234"),
				createBtnCheckBehavior("user5648"), createBtnCheckBehavior("user568"),
				createBtnCheckBehavior("user5348"), createBtnCheckBehavior("user46575"),
				createBtnCheckBehavior("user534"), createBtnCheckBehavior("user5623335"));
		vBoxUser.setMaxSize(300, 300);
		vBoxUser.setAlignment(Pos.TOP_CENTER);
		vBoxUser.setSpacing(0);

		VBox vBoxFeed = createPanel(createBtnCheckBehaviorFeed("I cessi puzzano"),
				createBtnCheckBehaviorFeed("Pagate la luce"), createBtnCheckBehaviorFeed("Spiegatele le cose!"),
				createBtnCheckBehaviorFeed("Non trovo parcheggio"), createBtnCheckBehaviorFeed("Prese guaste"),
				createBtnCheckBehaviorFeed("Fermata autobus lontana"), createBtnCheckBehaviorFeed("Non ci sono bar"),
				createBtnCheckBehaviorFeed("Wi fi ottimo"), createBtnCheckBehaviorFeed("Sala giochi al piano terra"),
				createBtnCheckBehaviorFeed("Non ci sono lampade"), createBtnCheckBehaviorFeed("Wi fi non funzionante"),
				createBtnCheckBehaviorFeed("Giardino non curato"));
		vBoxFeed.setMaxSize(300, 300);
		vBoxFeed.setAlignment(Pos.TOP_CENTER);
		vBoxFeed.setSpacing(0);

		spUsers.setContent(vBoxUser);
		spUsers.setMinSize(300, 300);
		spUsers.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		spUsers.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		spFeed.setContent(vBoxFeed);
		spFeed.setMinSize(300, 300);
		spFeed.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
		spFeed.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

		hBoxColumns.getChildren().addAll(spUsers, spFeed);

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