package logic.boundary;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import logic.application.Main;
import logic.bean.LibrBean;
import logic.control.StudentMainPageController;
import logic.control.StudentSearchInsertController;

public class StudentSearchSelectGUI extends StudentSearchInsertGUI {
	List<Button> listBtn;
	Button backBtn;
	List<LibrBean> listLibrary;
	static Logger myLogger = Logger.getLogger("logger");

	/*
	 * This constructor needs the number of libraries in the searched city. create
	 * as many buttons as there are libraries in that city.
	 */
	public StudentSearchSelectGUI() {

		backBtn = createBtn("Back");
		listLibrary = StudentSearchInsertController.getStudentSearchInsertController().getLibrInfoB();
		createArray();

	}

	/*
	 * crea l'array contenente tanti bottoni quante sono le biblioteche nella
	 * citta'.
	 */
	public void createArray() {
		listBtn = new ArrayList<>(listLibrary.size());
		for (int i = 0; i < listLibrary.size(); i++) {
			Button btn = createBtn("");
			listBtn.add(btn);
		}

	}

	public void createStudentSearchSelectGUI(Main main) {

		Label titleRes = createLabel("Results:", 24);
		titleRes.setPadding(new Insets(0, 0, 0, 0));

		ScrollPane scroll = new ScrollPane();
		scroll.setMinWidth(340);

		VBox listLibr = new VBox();
		listLibr.setMinWidth(300);

		for (int i = 0; i < listLibrary.size(); i++) {
			HBox panel = new HBox();
			panel.setPrefWidth(300);
			Button btn = listBtn.get(i);
			btn.setText(listLibrary.get(i).getName());
			btn.setMinSize(145, 40);
			Label seats = new Label(
					"Free: " + (listLibrary.get(i).getCapacity() - listLibrary.get(i).getPostiOccupati()) + "/"
							+ listLibrary.get(i).getCapacity());
			seats.setMinSize(100, 40);

			panel.getChildren().addAll(btn, seats);
			listLibr.getChildren().add(panel);
		}

		scroll.setContent(listLibr);

		ImageView map = createImg("src/resources/guest.png");
		Pane mapPane = new Pane();
		mapPane.setMinWidth(340);
		VBox content = createPanel(titleRes, map, scroll, backBtn);
		content.setPadding(new Insets(20, 0, 0, 0));

		BorderPane root = (BorderPane) main.getScene().getRoot();
		root.setCenter(content);

		backBtn.setOnAction((event -> {
			try {
				main.setNewStage("StudentGUI");
				StudentSearchInsertController.getStudentSearchInsertController().getLibrInfo().clear();
				StudentSearchInsertController.getStudentSearchInsertController().getLibrInfoB().clear();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}));

		if (listBtn.size() != 0) {

			for (int i = 0; i < listLibrary.size(); i++) {
				final int j = i;
				listBtn.get(i).setOnAction((event -> {
					try {
						StudentMainPageController.getStudentMainPageController().setStudInfoB(studInfo);

						new StudentSearchLibPageGUI().createStudentSearchLibPageGUI(main, j);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}));
			}

		}

		else
			myLogger.info("Non c'e' il bottone");
	}

}
