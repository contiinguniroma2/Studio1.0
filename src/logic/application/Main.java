package logic.application;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.boundary.GuestGUI;
import logic.boundary.HomeLibrarianGUI;
import logic.boundary.LoginGUI;
import logic.boundary.RegLibrarianSettingsGUI;
import logic.boundary.RegStudentSettingsGUI;
import logic.boundary.RegistrationGUI;
import logic.boundary.StartGUI;
import logic.boundary.StudentBannedGUI;
import logic.boundary.StudentNotifiedGUI;
import logic.boundary.StudentSearchInsertGUI;
import javafx.scene.Scene;

public class Main extends Application implements RequestNewStage {
	//prova
	public Stage stage;
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
			StartGUI startGUI = new StartGUI();
            scene = startGUI.createStart(this);
			break;

		case ("LoginGUI"):
			LoginGUI loginGUI = new LoginGUI();
            scene = loginGUI.createLogin(this);
			break;

		case ("RegistrationGUI"):
			RegistrationGUI registrationGUI = new RegistrationGUI();
            scene = registrationGUI.createRegistration(this);
			break;

		case ("RegStudentSettingsGUI"):
			RegStudentSettingsGUI regStudentSettingsGUI = new RegStudentSettingsGUI();
	        scene = regStudentSettingsGUI.createRegStudentSettings(this);
			break;

		case ("RegLibrarianSettingsGUI"):
			RegLibrarianSettingsGUI regLibrarianSettingsGUI = new RegLibrarianSettingsGUI();
		    scene = regLibrarianSettingsGUI.createRegLibrarianSettings(this);
		    break;

		case ("GuestGUI"):
			GuestGUI guestGUI = new GuestGUI();
			scene = guestGUI.createGuestGUI(this);
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

		/*case ("StudentNotifiedGUI"):
			StudentNotifiedGUI studentNotifiedGUI = new StudentNotifiedGUI();
			studentNotifiedGUI.createNotifiedRoot(this);
			scene = studentNotifiedGUI.createStudentNotifiedGUI(this);
			break;*/

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
