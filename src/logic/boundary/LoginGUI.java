package logic.boundary;

import java.util.logging.Logger;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import logic.application.Main;
import logic.control.LibraryMainPageController;
import logic.control.LoginController;
import logic.control.StudentMainPageController;
import logic.pattern.BannedState;
import logic.pattern.NotifiedState;
import javafx.scene.control.PasswordField;

public class LoginGUI extends GuiSUPER {
	static Logger myLogger = Logger.getLogger("logger");

	private LoginGUI() {

	}

	public static Scene createLogin(Main main) {

		Label titleLog = createLabel("Login:", 24);

		Button homeBtn = createBtn(PROJ_NAME);
		Button loginBtn = createBtn("Login");
		Label t1 = new Label("Please insert your credentials");
		Label email = new Label("Email:");
		Label password = new Label("Password:");
		TextField emailField = new TextField();
		PasswordField passwordField = new PasswordField();

		HBox topPanel = createTopPanel(homeBtn, "Login");

		VBox content = createPanel(titleLog, t1, email, emailField, password, passwordField, loginBtn);

		homeBtn.setOnAction((event -> {
			try {
				main.setNewStage(START);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		loginBtn.setOnAction((event -> {
			try {
				// CHIAMATA A METODO CONTROLLER (..., userCredentials) che dovra ritornare un
				// valore per fare aprire lo stage STUDENT o il LIBRARIAN
				if (LoginController.getLoginController().validateUser(emailField.getText(),
						passwordField.getText()) == 's') {
					StudentMainPageController.getStudentMainPageController()
							.setStudInfo(LoginController.getLoginController().getStudent());
					StudentMainPageController.getStudentMainPageController()
							.setStudInfoB(LoginController.getLoginController().getStudBean());
					if (LoginController.getLoginController().getStudent().getStateMachine()
							.getState() instanceof NotifiedState)
						main.setNewStage(NOTIFIEDSTUDENT);
					else if (LoginController.getLoginController().getStudent().getStateMachine()
							.getState() instanceof BannedState)
						main.setNewStage(BANNEDSTUDENT);
					else {
						StudentMainPageController.getStudentMainPageController().getBookMarks();
						main.setNewStage(STUDENT);
					}
				} else if (LoginController.getLoginController().validateUser(emailField.getText(),
						passwordField.getText()) == 'l') {
					LibraryMainPageController.getLibraryMainPageController()
							.setLibrInfo(LoginController.getLoginController().getLibrary());
					LibraryMainPageController.getLibraryMainPageController()
							.setLibrInfoB(LoginController.getLoginController().getLibrBean());
					LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
					main.setNewStage(LIBRARIAN);

				}

				t1.setTextFill(Color.web("#ff0000"));
				t1.setText("Credenziali errate");

			}

			catch (Exception e) {
				e.printStackTrace();
			}
		}));

		// ALLINEAMENTI
		BorderPane root = new BorderPane(content, topPanel, null, null, null);
		return (new Scene(root, 800, 600));

	}
}
