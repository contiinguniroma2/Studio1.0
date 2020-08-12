package logic.boundary;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.application.Main;
import logic.control.StudentMainPageController;
import logic.control.StudentSearchInsertController;

public class StudentSearchLibPageGUI extends StudentSearchSelectGUI {

	Button bookSeat;
	Button noticeBoard;
	Button timeTable;
	Button reportIssue;
	Button map;
	Button backToRes;

	public StudentSearchLibPageGUI() {
		bookSeat = createBtn("Book seat");
		noticeBoard = createBtn("Notice board");
		reportIssue = createBtn("Report Issue");
		map = createBtn("Map");
		timeTable = createBtn("Time table");
		backToRes = createBtn("Back");
	}

	public void createStudentSearchLibPageGUI(Main main, int i) {

		Alert alertBook = new Alert(AlertType.CONFIRMATION);

		VBox centerContent = new VBox();

		Label selectedTitle = createLabel("Info library:", 24);
		HBox titlePage = new HBox();
		titlePage.getChildren().addAll(selectedTitle);
		titlePage.setAlignment(Pos.CENTER);
		titlePage.setPadding(new Insets(20, 0, 20, 0));
		StudentMainPageController.getStudentMainPageController().setLibrInfoB(listLibrary.get(i));
		Label selectedLibrName = createLabel(listLibrary.get(i).getName(), 20);
		Label selectedLibrAddress = new Label(listLibrary.get(i).getAddress());
		Label selectedLibrPhone = new Label(listLibrary.get(i).getPhone());
		Label selectedLibrMail = new Label(listLibrary.get(i).getMail());
		Label selectedLibrFreeSeats = new Label(
				"Free seats: " + (listLibrary.get(i).getCapacity() - listLibrary.get(i).getPostiOccupati()) + " / "
						+ listLibrary.get(i).getCapacity());

		VBox infoLib = new VBox();
		infoLib.getChildren().addAll(selectedLibrName, selectedLibrAddress, selectedLibrPhone, selectedLibrMail,
				selectedLibrFreeSeats);
		infoLib.setAlignment(Pos.CENTER_LEFT);
		infoLib.setPrefHeight(400);
		infoLib.setSpacing(20);

		VBox buttonsLib = new VBox();
		buttonsLib.getChildren().addAll(bookSeat, reportIssue, timeTable, noticeBoard, map);
		buttonsLib.setAlignment(Pos.CENTER_RIGHT);
		buttonsLib.setPrefHeight(400);
		buttonsLib.setSpacing(20);

		// commmento per prova travis

		HBox infoPanel = new HBox();
		infoPanel.getChildren().addAll(infoLib, buttonsLib);
		infoPanel.setSpacing(100);
		infoPanel.setAlignment(Pos.CENTER);
		infoPanel.setPrefWidth(400);

		HBox backPanel = new HBox();
		backPanel.getChildren().addAll(backToRes);
		backPanel.setAlignment(Pos.CENTER);
		backPanel.setPadding(new Insets(20, 0, 0, 0));

		centerContent.getChildren().addAll(titlePage, infoPanel, backPanel);
		centerContent.setSpacing(20);
		centerContent.setPrefSize(400, 400);
		centerContent.setPadding(new Insets(20, 20, 20, 20));

		reportIssue.setOnAction((event -> {
			Parent issueBoundary = null;
			try {
				issueBoundary = FXMLLoader.load(getClass().getResource("/logic/fxml/IssueGUI.fxml"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			Scene issueBoundaryScene=new Scene(issueBoundary);
			Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(issueBoundaryScene);
			window.show();
		}));

		backToRes.setOnAction((event -> {
			try {
				StudentSearchInsertController.getStudentSearchInsertController().clearLibrary();
				StudentSearchInsertController.getStudentSearchInsertController().clearLibraryB();
				main.setNewStage(STUDENT);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		bookSeat.setOnAction((event -> {
			try {
				// deve prenotare il posto ed impedire nel caso lo studente abbia gia una
				// prenotaz attiva
				// in caso di riuscita manda solo alert di conferma
				alertBook.setTitle("Book seat");
				alertBook.setHeaderText("Booking:");
				alertBook.setContentText("Are you sure you want to book this seat?");
				if (alertBook.showAndWait().get() == ButtonType.OK) {
					StudentMainPageController.getStudentMainPageController().book();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		noticeBoard.setOnAction((event -> {
			try {
				// visualizza noticeboard
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		timeTable.setOnAction((event -> {
			try {
				new StudentSearchTimetableGUI().createStudentSearchTimetableGUI(main, i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		map.setOnAction((event -> {
			try {
				new StudentSearchMapGUI().createStudentSearchMapGUI(main, i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		BorderPane root = (BorderPane) main.getScene().getRoot();
		root.setCenter(centerContent);

	}

}
