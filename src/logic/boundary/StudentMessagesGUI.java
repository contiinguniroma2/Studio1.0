package logic.boundary;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;

public class StudentMessagesGUI extends StudentGUI {

	public void createStudentMessagesGUI(Main main) {

		Label title = createLabel("Messages:", 24);

		ScrollPane scroll = new ScrollPane();
		scroll.setMinSize(265, 100);

		VBox listMessages = new VBox();
		listMessages.setMinWidth(250);

		for (int i = 0; i < 10; i++) {
			HBox panel = new HBox();
			panel.setMinWidth(250);
			Button nameLib = new Button("Message " + i);
			nameLib.setMinSize(215, 40);
			Button replyBtn = new Button();
			replyBtn.setGraphic(createImg("src/resources/reply.png"));
			replyBtn.setMinSize(30, 40);
			panel.getChildren().addAll(nameLib, replyBtn);
			listMessages.getChildren().add(panel);
		}

		scroll.setContent(listMessages);

		VBox content = createPanel(title, scroll);
		content.setPadding(new Insets(20, 0, 20, 0));

		BorderPane root = (BorderPane) main.getScene().getRoot();
		root.setCenter(content);

	}

}
