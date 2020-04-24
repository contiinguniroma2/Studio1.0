package logic.application;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.boundary.HomeLibrarianGUI;
import logic.boundary.StudentBannedGUI;
import logic.boundary.StudentNotifiedGUI;
import logic.boundary.StudentSearchInsertGUI;
import javafx.scene.Scene;

public class Main extends Application implements RequestNewStage {
	//prova
	protected Stage stage;
	protected Scene scene;

	@Override
	public void start(Stage primaryStage) {
		try {
			this.stage = primaryStage;
			setNewStage("StartGUI");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void setNewStage(String guiName) {

		switch (guiName) {

		case ("StartGUI"):
			scene = logic.boundary.StartGUI.createStart(this);
			break;

		case ("LoginGUI"):
			scene = logic.boundary.LoginGUI.createLogin(this);
			break;

		case ("RegistrationGUI"):
			scene = logic.boundary.RegistrationGUI.createRegistration(this);
			break;

		case ("RegStudentSettingsGUI"):
			scene = logic.boundary.RegStudentSettingsGUI.createRegStudentSettings(this);
			break;

		case ("RegLibrarianSettingsGUI"):
			scene = logic.boundary.RegLibrarianSettingsGUI.createRegLibrarianSettings(this);
			break;

		case ("GuestGUI"):
			scene = logic.boundary.GuestGUI.createGuestGUI(this);
			break;

		case ("LibrarianGUI"):

			HomeLibrarianGUI homeLibrarianGUI = new HomeLibrarianGUI();
			homeLibrarianGUI.createRootLibrarian(this);
			scene = homeLibrarianGUI.createLibrarianGUI(this);
			break;

		case ("StudentGUI"):
			StudentSearchInsertGUI studentSearchInsertGUI = new StudentSearchInsertGUI();
			studentSearchInsertGUI.createRootStudentGUI(this);
			scene = studentSearchInsertGUI.createStudentSearchInsertGUI(this);
			break;

		case ("StudentNotifiedGUI"):
			StudentNotifiedGUI studentNotifiedGUI = new StudentNotifiedGUI();
			studentNotifiedGUI.createNotifiedRoot(this);
			scene = studentNotifiedGUI.createStudentNotifiedGUI(this);
			break;

		case ("StudentBannedGUI"):
			StudentBannedGUI studentBannedGUI = new StudentBannedGUI();
			studentBannedGUI.createBannedRoot(this);
			scene = studentBannedGUI.createStudentBannedGUI(this);
			break;

		default:
			break;
		}
		// install stage
		stage.setScene(scene);
		stage.setTitle("Stud.io");
		stage.show();
	}

	public Scene getScene() {
		return scene;
	}

}
