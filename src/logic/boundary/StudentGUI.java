package logic.boundary;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;
import logic.bean.StudentBean;
import logic.control.StudentMainPageController;

public class StudentGUI extends GuiSUPER {
	protected BorderPane root;
	protected Button settingsBtn;
	protected Button searchBtn;
	protected Button messagesBtn;
	protected ImageView studentHomeImg;
	protected Button logOutStud;
	protected Button refresh;
	protected Alert alert;
	protected StudentBean studInfoB;

	protected StudentGUI() {
		settingsBtn = new Button();
		settingsBtn.setGraphic(createImg("src/resources/student.png"));
		settingsBtn.setMaxSize(100, 100);
		searchBtn = createBtn("Search seat");
		messagesBtn = createBtn("Messages");
		studentHomeImg = createImg("src/resources/logo_button2.png");
		logOutStud = createBtn("Log out");
		refresh = new Button("", createImg("src/resources/icons8-aggiorna-30.png"));
		alert = new Alert(AlertType.WARNING);
		studInfoB = new StudentBean();
	}

	public void createBannedRoot(Main main) {
		HBox topPanel = createTopPanel(studentHomeImg,
				StudentMainPageController.getStudentMainPageController().getStudInfo().getUsername());

		VBox leftNotifiedStudent = createPanel(logOutStud);
		leftPadding(leftNotifiedStudent, 20);

		logOutStud.setOnAction((event -> {
			try {
				// alert conferma log out
				alert.setTitle("Log out");
				alert.setHeaderText("Warning!");
				alert.setContentText("Are you sure you want to log out?");
				if (alert.showAndWait().get() == ButtonType.OK) {
					main.setNewStage(START);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		root = new BorderPane(null, topPanel, null, null, null);
	}

	public void createNotifiedRoot(Main main) {
		createBannedRoot(main);

		VBox leftNotifiedStudent = createPanel(settingsBtn, messagesBtn, logOutStud);
		leftPadding(leftNotifiedStudent, 20);

		settingsBtn.setOnAction((event -> {
			try {
				new StudentSettingsGUI().createStudentSettingsGUI(main);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		messagesBtn.setOnAction((event -> {
			try {
				new StudentMessagesGUI().createStudentMessagesGUI(main);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		root.setLeft(leftNotifiedStudent);

	}

	public void createRootStudentGUI(Main main) {

		createNotifiedRoot(main);

		VBox leftStudent = createPanel(refresh, settingsBtn, searchBtn, messagesBtn, logOutStud);
		leftPadding(leftStudent, 20);

		searchBtn.setOnAction((event -> {
			try {
				// INSERIRE ALERT PER CONFERMA LOGOUT
				main.setNewStage("StudentGUI");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		refresh.setOnAction((event -> {
			try {
				StudentMainPageController.getStudentMainPageController().updateStudentInfo();
				main.setNewStage(STUDENT);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		root.setLeft(leftStudent);

	}

}
