package logic.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
	    back = createButton("Back");
	    reportAccount = createButton("reportAccount");
	}
	

	
	public VBox createInfoAccountGUI() {
		Label title = new Label("Settings:"); 
		title.setStyle("-fx-font: " + 25 + " arial;");
	    title.setPadding(new Insets(0, 0, 20, 0));
		
		Label name = new Label("Name:");
		TextField nameField = new TextField();
		Label surname = new Label("Surname:");
		TextField surnameField = new TextField();
		Label email = new Label("Email:");
		TextField emailField = new TextField();
		Label password = new Label("Password:");
		TextField passwordField = new TextField();
		Label username = new Label("Username:");
		TextField usernameField = new TextField();
		Label phone = new Label("Phone:");
		TextField phoneField = new TextField();
		HBox hBox = new HBox();
		hBox.getChildren().addAll(back, reportAccount);
		VBox content = createPanel(title, name, nameField, surname, surnameField, phone, phoneField, username,
				usernameField, email, emailField, password, passwordField, hBox);
		back.setOnAction((event -> {
			try {
				superviseGUI.getRoot().setCenter(superviseGUI.createSuperviseGUI());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
		
		return content;
	}
	
	public VBox createPanel(Node... nodes) {
		VBox panel = new VBox();
		for (Node next : nodes)
			panel.getChildren().add(next);
		panel.setAlignment(Pos.CENTER);
		panel.setMaxWidth(250);
		panel.setSpacing(10);
		return panel;
	}
	
	public Button createButton(String nameBtn) {
		Button btn = new Button(nameBtn);
		btn.setPrefWidth(100);
		btn.setPrefHeight(20);
		return btn;
	}
	
	
	


}
