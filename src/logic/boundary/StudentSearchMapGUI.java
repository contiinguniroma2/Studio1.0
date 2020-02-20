package logic.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;

public class StudentSearchMapGUI extends StudentSearchSelectGUI {

	public StudentSearchMapGUI() {

		backBtn = createBtn("Back");

	}

	public void createStudentSearchMapGUI(Main main, int i) {

		Label titleMapSearch = createLabel("Map:", 24);

		HBox titleMapLib = new HBox();
		titleMapLib.getChildren().addAll(titleMapSearch);
		titleMapLib.setAlignment(Pos.CENTER);
		titleMapLib.setPadding(new Insets(20, 20, 20, 20));

		HBox backPanel = new HBox();
		backPanel.getChildren().addAll(backBtn);
		backPanel.setAlignment(Pos.BOTTOM_CENTER);

		VBox mapPane = new VBox();
		ImageView mapImg = createImg("src/resources/mappaRugantino.png");
		mapPane.getChildren().addAll(mapImg);
		mapPane.setPadding(new Insets(0, 20, 20, 20));
		mapPane.setAlignment(Pos.CENTER);

		VBox contentMapPanel = new VBox();
		contentMapPanel.getChildren().addAll(titleMapLib, mapPane, backPanel);
		contentMapPanel.setPadding(new Insets(0, 20, 20, 20));
		contentMapPanel.setAlignment(Pos.CENTER);

		backBtn.setOnAction((event -> {
			try {
				new StudentSearchLibPageGUI().createStudentSearchLibPageGUI(main, i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		BorderPane root = (BorderPane) main.getScene().getRoot();
		root.setCenter(contentMapPanel);

	}
}
