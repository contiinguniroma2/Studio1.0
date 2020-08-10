package logic.boundary;

import java.util.NoSuchElementException;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;
import logic.bean.LibrBean;
import logic.control.LibrarianScheduleController;
import logic.control.LibraryMainPageController;

public class LibrarianGUI extends GuiSUPER {
	protected BorderPane root;
	protected Button settingImageView;
	protected Button updateSeatsBtn;
	protected Button noticeBoard;
	protected Button timeTable;
	protected Button services;
	protected Button checkBehavior;
	protected Button statistics;
	protected Button logOut;
	protected Button refresh;
	protected LibrBean libInfoB;
	//protected LoginController loginController;

	protected LibrarianGUI() {
		settingImageView = new Button("", createImg("src/resources/guest.png"));
		updateSeatsBtn = createBtn("Update seats");
		noticeBoard = createBtn("Notice board");
		timeTable = createBtn("Time table");
		services = createBtn("Services");
		checkBehavior = createBtn("User behavior");
		statistics = createBtn("Statistics");
		logOut = createBtn("Log Out");
		refresh = new Button("", createImg("src/resources/icons8-aggiorna-30.png"));
		libInfoB = loginController.getLibrBean();

	}

	public void createRootLibrarian(Main main) {
		HBox topPanel = createLibrTopPanel();
		VBox leftLibrarian = createPanel(refresh, settingImageView, updateSeatsBtn, noticeBoard, timeTable, services,
				checkBehavior, statistics, logOut);
		leftPadding(leftLibrarian, 20);

		setOnClick(updateSeatsBtn, main, "LibrarianGUI");

		setOnActionRefresh(refresh, main);

		checkBehavior.setOnAction((event -> {
			try {

				new SuperviseGUI().createBehaviorCheckGUI(main);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		timeTable.setOnAction((event -> {
			try {

				LibrarianScheduleController.getLibrarianScheduleController().getScheduleFromDb();
				new LibrarianScheduleGUI().createLibrarianScheduleGUI(main);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		setOnActionServices(services, main);
		setOnActionNoticeBoard(noticeBoard, main);

		settingImageView.setOnAction((event -> {
			try {
				new LibrarianSettingsGUI().createLibrarianSettingsGUI(main);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		statistics.setOnAction((event -> {
			try {
				new LibrarianStatisticsGUI().createLibrarianStatisticsGUI(main);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		logOut.setOnAction((event -> {
			try {
				// alert conferma log out librarian
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Log out");
				alert.setHeaderText("Warning!");
				alert.setContentText("Are you sure you want to log out?");
				if (alert.showAndWait().get() == ButtonType.OK) {
					// TORNA A LOGIN GUI

					main.setNewStage(START);
				}
			} catch (NoSuchElementException e) {
				// if this exception is caught, no need to do anything
			} catch (Exception exc) {
				exc.printStackTrace();
			}

		}));

		root = new BorderPane(null, topPanel, null, null, leftLibrarian);

	}

	public void addOnAction(Button btn, Main main) {
		btn.setOnAction((e -> {
			try {
				if (LibraryMainPageController.getLibraryMainPageController().getLibrInfoB()
						.getPostiOccupati() < LibraryMainPageController.getLibraryMainPageController().getLibrInfoB()
								.getCapacity()) {
					LibraryMainPageController.getLibraryMainPageController().updateSeats("+");
					LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
					main.setNewStage(LIBRARIAN);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}));

	}

	public void delOnAction(Button btn, Main main) {
		btn.setOnAction((e -> {
			try {
				if (LibraryMainPageController.getLibraryMainPageController().getLibrInfoB().getPostiOccupati() > 0) {
					LibraryMainPageController.getLibraryMainPageController().updateSeats("-");
					LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
					main.setNewStage(LIBRARIAN);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}));
	}
}
