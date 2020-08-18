package logic.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;
import logic.bean.MessageBean;
import logic.bean.StudentBean;
import logic.control.StudentMainPageController;
import logic.control.StudentSuperviseController;
import logic.control.SuperviseController;

import java.util.ArrayList;
import java.util.List;

public class StudentNotifiedGUI extends GuiSUPER {
	private StudentSuperviseController superviseController;
	private List<MessageBean> messageBeanList;
	private List<Button> btnList;
	private StudentBean studentBean;
	private Button logOutStud;
    
	public StudentNotifiedGUI (StudentBean studentBean, StudentSuperviseController superviseController) {
		this.superviseController = superviseController;
		messageBeanList = superviseController.getMessages(studentBean.getMail());
		this.studentBean = studentBean;
		logOutStud = createBtn("Log out");
		btnList = new ArrayList<>();
	}
	public Scene createStudentNotifiedGUI(Main main) {
		ImageView studentHomeImg = createImg("src/resources/logo_button2.png");
		HBox topPanel = createTopPanel(studentHomeImg, studentBean.getUsername());

	    
		logOutStud.setOnAction((event -> {
			try {
				// alert conferma log out
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Log out");
				alert.setHeaderText("Warning!");
				alert.setContentText("Are you sure you want to log out?"
						+ "\nReply your messages");
				if (alert.showAndWait().get() == ButtonType.OK) {
					main.setNewStage(START);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}));
		
		VBox center = new VBox();                             //Contiene un titolo e la lista di messaggi
		Label title = new Label("Reported account");
		title.setStyle("-fx-font: " + 30 + " arial;");
        title.setAlignment(Pos.CENTER);
        center.getChildren().add(title);
        center.setSpacing(20);
        center.setPadding(new Insets(20));
        for (int i=0; i<messageBeanList.size(); i++) {
        	HBox hBox = new HBox();                         //Contiene un messaggio per lo studente
        	Label messageForm = new Label();
        	messageForm.setText(messageBeanList.get(i).getTitle() +"\n"+ messageBeanList.get(i).getText());
        	Label info = new Label();
        	info.setText("For explanation contact:\n" + messageBeanList.get(i).getLibrarianId());
        	info.setMinSize(220,50);
        	Button button = new Button("Ok");
            button.setAlignment(Pos.CENTER);
            btnList.add(button);
            Long id = messageBeanList.get(i).getId();
            btnList.get(i).setOnAction((event -> {
    			superviseController.deleteMessage(id);
    			superviseController.sendMessageInteraction(studentBean.getMail());
    			btnList.remove(button);
    			center.getChildren().remove(hBox);
    			if (btnList.isEmpty()) {
    				main.setNewStage(START);
    			}
            }));
    		
        	hBox.getChildren().addAll(messageForm, info, button);
        	hBox.setSpacing(25);
        	center.getChildren().add(hBox);
        }
        HBox bottom = new HBox(logOutStud);
        bottom.setPadding(new Insets(20));
        BorderPane root = new BorderPane(center, topPanel, null, bottom, null);
		return (new Scene(root, 800, 600));
	}

}
