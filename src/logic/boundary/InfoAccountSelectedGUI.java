package logic.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;
import logic.bean.StudentBean;

public class InfoAccountSelectedGUI {
	private SuperviseGUI superviseGUI;
	private StudentBean studentBean;
	private Button reportAccount;
	private Button back;
	private Button confermationBtn;
	
	
	
	public InfoAccountSelectedGUI (SuperviseGUI superviseGUI, StudentBean studentBean) {
		this.superviseGUI = superviseGUI;
		this.studentBean = studentBean;
	}
	
	public VBox createInfoAccountGUI() {
		
		back.setOnAction((event -> {
			try {
				superviseGUI.getRoot().setCenter(superviseGUI.createSuperviseGUI());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
		
		return content;
	}
	
	
	
	


}
