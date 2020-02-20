package logic.boundary;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import logic.application.Main;

public class StudentBannedGUI extends StudentGUI {

	public Scene createStudentBannedGUI(Main main) {
		createBannedRoot(main);
		Label searchPanelTitle = createLabel(
				"This is a banned account, contacts\nthe administrator at stud_io@gmail.com", 40);

		root.setCenter(searchPanelTitle);
		return (new Scene(root, 800, 600));
	}

}
