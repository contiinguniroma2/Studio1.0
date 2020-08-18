package logic.boundary;

import java.util.NoSuchElementException;

import javafx.scene.Scene;
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
	protected Button supervisePage;
	protected Button statistics;
	protected Button logOut;
	protected Button refresh;
	
	

	protected LibrarianGUI() {
		settingImageView = new Button("", createImg("src/resources/guest.png"));
		updateSeatsBtn = createBtn("Update seats");
		noticeBoard = createBtn("Notice board");
		timeTable = createBtn("Time table");
		services = createBtn("Services");
		supervisePage = createBtn("Students");
		statistics = createBtn("Statistics");
		logOut = createBtn("Log Out");
		refresh = new Button("", createImg("src/resources/icons8-aggiorna-30.png"));
		

	}
	
	protected LibrarianGUI(LibrBean libraryBean) {
		super(libraryBean);
		settingImageView = new Button("", createImg("src/resources/guest.png"));
		updateSeatsBtn = createBtn("Update seats");
		noticeBoard = createBtn("Notice board");
		timeTable = createBtn("Time table");
		services = createBtn("Services");
		supervisePage = createBtn("Students");
		statistics = createBtn("Statistics");
		logOut = createBtn("Log Out");
		refresh = new Button("", createImg("src/resources/icons8-aggiorna-30.png"));
		

	}

	public void createRootLibrarian(Main main) {
		HBox topPanel = createLibrTopPanel();
		VBox leftLibrarian = createPanel(refresh, settingImageView, updateSeatsBtn, noticeBoard, timeTable, services,
				supervisePage, statistics, logOut);
		leftPadding(leftLibrarian, 20);

		updateSeatsBtn.setOnAction((event -> {
			try {

				HomeLibrarianGUI homeLibrarianGUI = new HomeLibrarianGUI(libraryBean);
				homeLibrarianGUI.createRootLibrarian(main);
				Scene scene = homeLibrarianGUI.createLibrarianGUI(main);
				main.stage.setScene(scene);
				main.stage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		setOnActionRefresh(refresh, main);

		supervisePage.setOnAction((event -> {
			try {
				SuperviseGUI superviseGUI = new SuperviseGUI(libraryBean);
				superviseGUI.setRoot(root);
				root.setCenter(superviseGUI.createSuperviseGUI());	 
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
		}));

		timeTable.setOnAction((event -> {
			try {

				LibrarianScheduleController.getLibrarianScheduleController().getScheduleFromDb();
				root.setCenter(new LibrarianScheduleGUI().createLibrarianScheduleGUI(root));

			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
		
		
	    services.setOnAction((event -> {
			try {

				root.setCenter(new LibrarianServicesGUI().createLibrarianServicesGUI());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
	  

		
		noticeBoard.setOnAction((event -> {
			try {
				LibrarianNoticeboardGUI librarianNoticeboardGUI = new LibrarianNoticeboardGUI();
				root.setCenter(librarianNoticeboardGUI.createLibrarianNoticeboardGUI());	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		settingImageView.setOnAction((event -> {
			try {
				LibrarianSettingsGUI librarianSettingsGUI = new LibrarianSettingsGUI(libraryBean);
				root.setCenter(librarianSettingsGUI.createLibrarianSettingsGUI(main));	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		statistics.setOnAction((event -> {
			try {
				LibrarianStatisticsGUI librarianStatisticsGUI = new LibrarianStatisticsGUI();
				root.setCenter(librarianStatisticsGUI.createLibrarianStatisticsGUI());
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
				if (libraryBean.getPostiOccupati() < libraryBean.getCapacity()) {
					libraryBean.increaseCapacity();
					LibraryMainPageController.getLibraryMainPageController().updateSeats("+");
					LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
					HomeLibrarianGUI homeLibrarianGUI = new HomeLibrarianGUI(libraryBean);
					homeLibrarianGUI.createRootLibrarian(main);
					Scene scene = homeLibrarianGUI.createLibrarianGUI(main);
					main.stage.setScene(scene);
					main.stage.show();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}));

	}

	public void delOnAction(Button btn, Main main) {
		btn.setOnAction((e -> {
			try {
				if (libraryBean.getPostiOccupati() > 0) {
					libraryBean.decreaseCapacity();
					LibraryMainPageController.getLibraryMainPageController().updateSeats("-");
					LibraryMainPageController.getLibraryMainPageController().updateLibraryMainPage();
					HomeLibrarianGUI homeLibrarianGUI = new HomeLibrarianGUI(libraryBean);
					homeLibrarianGUI.createRootLibrarian(main);
					Scene scene = homeLibrarianGUI.createLibrarianGUI(main);
					main.stage.setScene(scene);
					main.stage.show();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}));
	}
	
	public BorderPane getRoot() {
		return root;
		
	}
	
	public void setRoot(BorderPane root) {
		this.root = root;
	}
}
