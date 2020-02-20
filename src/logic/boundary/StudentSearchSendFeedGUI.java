package logic.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;

public class StudentSearchSendFeedGUI extends StudentSearchSelectGUI {

	Button sendFeedback;
	TextField titleFeed;
	TextField contentFeed;

	public StudentSearchSendFeedGUI() {

		sendFeedback = createBtn("Send");
		titleFeed = new TextField();
		titleFeed.setPromptText("Max 30 characters...");
		titleFeed.setPrefSize(300, 20);
		contentFeed = new TextField();
		contentFeed.setPromptText("Max 512 characters...");
		contentFeed.setPrefSize(300, 300);
		backBtn = createBtn("Back");

	}

	public void createStudentSearchSendFeedGUI(Main main, int i) {

		Alert alertFeed = new Alert(AlertType.CONFIRMATION);

		Label titleFeedPage = createLabel("Send feedback:", 24);
		Label titleLbl = new Label("Title:");
		Label contentLbl = new Label("Description:");

		HBox titlePagFeed = new HBox();
		titlePagFeed.getChildren().addAll(titleFeedPage);
		titlePagFeed.setAlignment(Pos.CENTER);
		titlePagFeed.setPadding(new Insets(20, 20, 20, 20));

		HBox sendBtnPanel = new HBox();
		sendBtnPanel.getChildren().addAll(backBtn, sendFeedback);
		sendBtnPanel.setSpacing(200);
		sendBtnPanel.setAlignment(Pos.CENTER);
		sendBtnPanel.setPadding(new Insets(20, 20, 0, 20));

		VBox contentFeedPanel = new VBox();
		contentFeedPanel.getChildren().addAll(titlePagFeed, titleLbl, titleFeed, contentLbl, contentFeed, sendBtnPanel);
		contentFeedPanel.setPadding(new Insets(0, 20, 0, 20));

		sendFeedback.setOnAction((event -> {
			try {
				alertFeed.setTitle("Feedback");
				alertFeed.setHeaderText("Sending feedback:");
				alertFeed.setContentText("Are you sure you want to send this feedback?");
				if (alertFeed.showAndWait().get() == ButtonType.OK) {
					// Invia feedback
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		backBtn.setOnAction((event -> {
			try {
				new StudentSearchLibPageGUI().createStudentSearchLibPageGUI(main, i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		BorderPane root = (BorderPane) main.getScene().getRoot();
		root.setCenter(contentFeedPanel);

	}
}
