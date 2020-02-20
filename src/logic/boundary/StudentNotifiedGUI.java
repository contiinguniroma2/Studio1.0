package logic.boundary;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import logic.application.Main;

public class StudentNotifiedGUI extends StudentGUI {

	public Scene createStudentNotifiedGUI(Main main) {
		createNotifiedRoot(main);
		Label searchPanelTitle = createLabel("Open your messages and \nchange your reported settings", 40);

		root.setCenter(searchPanelTitle);
		return (new Scene(root, 800, 600));
	}

}
