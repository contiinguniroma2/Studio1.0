package logic.boundary;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

public class ReportListElement extends Region{
	private Label title;
	private Label status;
	private Label user;
	private Button deleteButton;
	private Button openButton;
	private long reportId;
	
	public ReportListElement(String title, String status, String user, long reportId){
		this.title=new Label(title);
		this.status= new Label(status);
		this.user= new Label(user);
		deleteButton=new Button("Delete");
		openButton=new Button("Open");
		new HBox(this.user,this.title,this.status,this.openButton, this.deleteButton);
		deleteButton.setOnAction((ActionEvent event) -> {
			deleteClicked();
        });
		openButton.setOnAction((ActionEvent event) -> {
			openClicked();
        });
	}
	
	
	public long getReportId() {
		return reportId;
	}
	
	public void openClicked() {
		System.out.println("Il controller ora apre questo report cambiando la scena");
	}
	
	public void deleteClicked() {
		System.out.println("Il controller ora cancella toglie il riferimento di questa entry alla boundary che la aggrega");
	}
	
}