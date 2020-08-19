package logic.boundary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import logic.application.Main;
import logic.bean.StudentBean;
import logic.control.StudentSuperviseController;

import java.util.ArrayList;
import java.util.List;

public class StudentNotifiedGUI extends StudentBannedGUI {
	private StudentSuperviseController superviseController;
	private List<Button> btnList;
	
	public StudentNotifiedGUI (StudentBean studentBean, StudentSuperviseController superviseController) {
		super(studentBean, superviseController);
		this.superviseController = superviseController;
		btnList = new ArrayList<>();
	}
	public Scene createStudentNotifiedGUI(Main main) {
		createBase(main);
        for (int i=0; i<messageBeanList.size(); i++) {
        	HBox hBox = new HBox();                         //Contiene un messaggio per lo studente
        	Label messageForm = new Label();
        	messageForm.setText(messageBeanList.get(i).getTitle() +"\n"+ messageBeanList.get(i).getText());
        	messageForm.setStyle(font + 19 + arial);
        	Label info = new Label();
        	info.setText("For explanation contact:\n" + messageBeanList.get(i).getLibrarianId());
        	info.setStyle(font + 19 + arial);
        	info.setMinSize(220,50);
        	messageForm.setPrefWidth(450);
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
