package logic.boundary;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import logic.application.Main;
import logic.control.StudentMainPageController;
import logic.control.StudentSettingsController;

public class StudentSettingsGUI extends StudentGUI {
	Button apply = createBtn("Apply");

	public void createStudentSettingsGUI(Main main) {

		Label title = createLabel("Settings:", 24);
		Label name = new Label("Name:");
		TextField nameField = new TextField();
		Label surname = new Label("Surname:");
		TextField surnameField = new TextField();
		Label email = new Label("Email:");
		TextField emailField = new TextField();
		Label password = new Label("Password:");
		TextField passwordField = new TextField();
		Label username = new Label("Username:");
		TextField usernameField = new TextField();
		Label phone = new Label("Phone:");
		TextField phoneField = new TextField();

		VBox box = createPanel(title, name, nameField, surname, surnameField, phone, phoneField, username,
				usernameField, email, emailField, password, passwordField, apply);

		BorderPane root = (BorderPane) main.getScene().getRoot();
		root.setCenter(box);

		apply.setOnAction((event -> {
			try {
				StudentSettingsController.getStudentSettingsController().getStudInfoB().setMail(emailField.getText());
				StudentSettingsController.getStudentSettingsController().getStudInfoB()
						.setPassword(passwordField.getText());
				StudentSettingsController.getStudentSettingsController().getStudInfoB()
						.setUsername(usernameField.getText());
				StudentSettingsController.getStudentSettingsController().getStudInfoB().setName(nameField.getText());
				StudentSettingsController.getStudentSettingsController().getStudInfoB()
						.setSurname(surnameField.getText());
				StudentSettingsController.getStudentSettingsController().getStudInfoB().setPhone(phoneField.getText());
				StudentSettingsController.getStudentSettingsController().updateStudentInfo();
				StudentMainPageController.getStudentMainPageController().updateStudentInfo();
				main.setNewStage(STUDENT);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

	}
	


}
