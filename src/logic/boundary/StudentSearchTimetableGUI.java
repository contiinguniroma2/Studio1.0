package logic.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;

public class StudentSearchTimetableGUI extends StudentSearchSelectGUI {

	public StudentSearchTimetableGUI() {

		backBtn = createBtn("Back");

	}

	public void createStudentSearchTimetableGUI(Main main, int i) {

		Label titleTimeTableSearch = createLabel("Time table:", 24);
		HBox titlePagTimetable = new HBox();
		titlePagTimetable.getChildren().addAll(titleTimeTableSearch);
		titlePagTimetable.setAlignment(Pos.CENTER);
		titlePagTimetable.setPadding(new Insets(20, 20, 20, 20));

		HBox backPanel = new HBox();
		backPanel.getChildren().addAll(backBtn);
		backPanel.setAlignment(Pos.BOTTOM_CENTER);

		Label sunday = createLabel("Sunday: " + "CLOSED", 16);
		Label monday = createLabel("Monday: " + "08:00 / 20:00", 16);
		Label tuesday = createLabel("Tuesday: " + "08:00 / 13:00", 16);
		Label wednesday = createLabel("Wednesday: " + "08:00 / 21:00", 16);
		Label thursday = createLabel("Thursday: " + "08:00 / 23:00", 16);
		Label friday = createLabel("Friday: " + "08:00 / 24:00", 16);
		Label saturday = createLabel("Saturday: " + "08:00 / 15:00", 16);

		VBox contentTimetablePanel = new VBox();
		contentTimetablePanel.getChildren().addAll(titlePagTimetable, sunday, monday, tuesday, wednesday, thursday,
				friday, saturday, backPanel);
		contentTimetablePanel.setPadding(new Insets(0, 20, 0, 20));
		contentTimetablePanel.setAlignment(Pos.CENTER);

		backBtn.setOnAction((event -> {
			try {
				new StudentSearchLibPageGUI().createStudentSearchLibPageGUI(main, i);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		BorderPane root = (BorderPane) main.getScene().getRoot();
		root.setCenter(contentTimetablePanel);

	}
}
