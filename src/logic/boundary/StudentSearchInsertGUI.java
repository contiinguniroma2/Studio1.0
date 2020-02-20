package logic.boundary;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;
import logic.bean.StudBean;
import logic.control.LoginController;
import logic.control.StudentSearchInsertController;

public class StudentSearchInsertGUI extends StudentGUI {
	Button librarySearchButton;
	TextField location;
	StudBean studInfo;

	public StudentSearchInsertGUI() {
		librarySearchButton = new Button();
		location = new TextField();
		studInfo = LoginController.getLoginController().getStudBean();
	}

	public Scene createStudentSearchInsertGUI(Main main) {

		Label searchPanelTitle = createLabel("Search a seat:", 24);
		VBox searchPanel = createPanel();

		librarySearchButton.setPrefSize(30, 40);
		librarySearchButton.setGraphic(createImg("src/resources/searchLens.png"));

		HBox searchBar = new HBox();
		searchBar.setPrefWidth(300);
		// QUIDUBBIO PRIMA ERA TEXTFIELD LOCATION SONAR NON PIACE
		location = new TextField();
		location.setPromptText("Insert your position here...");
		location.setPrefSize(300, 40);

		searchBar.getChildren().addAll(location, librarySearchButton);

		searchPanel.getChildren().addAll(searchPanelTitle, searchBar, loadPrefers());

		librarySearchButton.setOnAction((event -> {
			try {

				StudentSearchInsertController.getStudentSearchInsertController()
						.searchLibrariesWithCity(location.getText());
				StudentSearchSelectGUI studentSearchSelectGUI = new StudentSearchSelectGUI();
				studentSearchSelectGUI.createStudentSearchSelectGUI(main);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		root.setCenter(searchPanel);
		return (new Scene(root, 800, 600));

	}

}