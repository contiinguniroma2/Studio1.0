package logic.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;

public class ReportIssueForm extends StudentSearchSelectGUI {

	Button sendReport;
	TextField reportTitle;
	TextField reportDescription;

	public ReportIssueForm(Main main, int i) {

		sendReport = createBtn("Send");
		reportTitle = new TextField();
		reportTitle.setPromptText("Max 128 characters...");
		reportTitle.setPrefSize(300, 20);
		reportDescription = new TextField();
		reportDescription.setPromptText("Max 1024 characters...");
		reportDescription.setPrefSize(300, 300);
		backBtn = createBtn("Back");
		

		Label titleFeedPage = createLabel("Send feedback:", 24);
		Label titleLbl = new Label("Title:");
		Label contentLbl = new Label("Description:");

		HBox titlePagFeed = new HBox();
		titlePagFeed.getChildren().addAll(titleFeedPage);
		titlePagFeed.setAlignment(Pos.CENTER);
		titlePagFeed.setPadding(new Insets(20, 20, 20, 20));

		HBox sendBtnPanel = new HBox();
		sendBtnPanel.getChildren().addAll(backBtn, sendReport);
		sendBtnPanel.setSpacing(200);
		sendBtnPanel.setAlignment(Pos.CENTER);
		sendBtnPanel.setPadding(new Insets(20, 20, 0, 20));

		VBox contentFeedPanel = new VBox();
		contentFeedPanel.getChildren().addAll(titlePagFeed, titleLbl, reportTitle, contentLbl, reportDescription, sendBtnPanel);
		contentFeedPanel.setPadding(new Insets(0, 20, 0, 20));

		sendReport.setOnAction((event -> 
			sendReportClicked()
		));

		backBtn.setOnAction((event -> 
			backClicked(main, i)
		));

		BorderPane root = (BorderPane) main.getScene().getRoot();
		root.setCenter(contentFeedPanel);

	}
	
	public void sendReportClicked() {
		//TODO
	}
	
	public void backClicked(Main main, int i) {
		try {
			new StudentSearchLibPageGUI().createStudentSearchLibPageGUI(main, i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}