package logic.boundary;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import logic.application.Main;

public class InfoAccountSelectedGUI {
	private BorderPane root;
	private SuperviseGUI superviseGUI;
	private Button reportAccount;
	private Button back;
	private Button confermationBtn;
	
	
	public InfoAccountSelectedGUI (SuperviseGUI superviseGUI) {
		this.superviseGUI = superviseGUI;
		
	}
	
	public VBox infoAccountGUI(Main main) {
		
	}
	
	public void backMethod() {
		back.setOnAction((event -> {
			try {
				root = (BorderPane) main.getScene().getRoot();
				root.setCenter(backBox);
				main.getScene().setRoot(root);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
	}
	
	
	
	public void createInfoAccountSelectedGUI(Main main) {

		root = (BorderPane) main.getScene().getRoot();
		root.setCenter(infoAccountGUI(main));
		main.getScene().setRoot(root);

	}

}
