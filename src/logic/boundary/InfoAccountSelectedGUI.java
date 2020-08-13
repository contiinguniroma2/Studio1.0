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
import javafx.scene.text.Font;
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
		Label nameField = new Label(studentBean.getName());
		Label surnameField = new Label(studentBean.getSurname());
		Label emailField = new Label(studentBean.getMail());
		Label usernameField = new Label(studentBean.getUsername());
		Label phoneField = new Label(studentBean.getPhone());
		Label banLabel = new Label();
		if(studentBean.isBanned()) {
			banLabel.setText("Utente bannato");
		}
		else {
			banLabel.setText("Utente attivo");
		}
		banLabel.setFont(new Font(22));
		HBox hBox = new HBox();
		hBox.getChildren().addAll(back, reportAccount);
	
		VBox content = createPanel(createLabel("Name:"), nameField, createLabel("Surname:"), surnameField, createLabel("Phone:"), phoneField, createLabel("Username:"),
				usernameField, createLabel("Email:"), emailField, banLabel, hBox);
		back.setOnAction((event -> {
			try {
				superviseGUI.getRoot().setCenter(superviseGUI.getGui());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
		
		return content;
	}
  
	
	public Label createLabel(String text) {
		Label name = new Label(text);
		name.setFont(new Font(22));
		return name;
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
