package logic.boundary;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import logic.application.Main;



public class IssueBoundary extends StudentGUI{
	
	private Button backButton;
	private ListView<ReportListElement> reports;
	private HBox buttonPanel;
	private HBox listPanel;
	private HBox titlePanel;
	private VBox contentPanel;
	private Label issueBoundaryTitle;

	public IssueBoundary(Main main, ListView<ReportListElement> reports) {
		backButton= new Button("Back");
		this.reports=reports;
		reports.setPlaceholder(new Label("No reports available"));
		issueBoundaryTitle= new Label("Your reports:");
		issueBoundaryTitle.setStyle("-fx-font: 24 arial;");
		buttonPanel=new HBox(backButton);
		listPanel= new HBox(reports);
		titlePanel= new HBox(issueBoundaryTitle);
		buttonPanel.setAlignment(Pos.BOTTOM_RIGHT);
		listPanel.setAlignment(Pos.CENTER);
		titlePanel.setAlignment(Pos.TOP_CENTER);
		buttonPanel.setPadding(new Insets(10,50,10,10));
		listPanel.setPadding(new Insets(10,10,10,10));
		titlePanel.setPadding(new Insets(10,10,10,10));
		contentPanel=new VBox(titlePanel,listPanel,buttonPanel);
		BorderPane root1 = (BorderPane) main.getScene().getRoot();
		root1.setCenter(contentPanel);
		//root.setCenter(contentFeedPanel);
	}
	
	//PROVA
	public IssueBoundary(Main main) {
		backButton= new Button("Back");
		this.reports=new ListView<>();
		reports.setPlaceholder(new Label("No reports available"));
		issueBoundaryTitle= new Label("Your reports");
		issueBoundaryTitle.setStyle("-fx-font: 24 arial;");
		backButton.setOnAction((ActionEvent event) -> {
			backClicked();
        });
		
		reports.getItems().add(new ReportListElement("titolo","bobbe","aperto",23));
		buttonPanel=new HBox(backButton);
		listPanel= new HBox(reports);
		titlePanel= new HBox(issueBoundaryTitle);
		buttonPanel.setAlignment(Pos.BOTTOM_RIGHT);
		listPanel.setAlignment(Pos.CENTER);
		titlePanel.setAlignment(Pos.TOP_CENTER);
		buttonPanel.setPadding(new Insets(10,10,10,10));
		listPanel.setPadding(new Insets(10,10,10,10));
		titlePanel.setPadding(new Insets(10,10,10,10));
		contentPanel=new VBox(titlePanel,listPanel,buttonPanel);
		//root.setCenter(contentPanel);	
		BorderPane root1 = (BorderPane) main.getScene().getRoot();
		root1.setCenter(contentPanel);
	}
	
	//PROVA
	
	public Scene createScene() {
		return new Scene(root,800,600);
	}
	
	public void addElement(ReportListElement report) {
		reports.getItems().add(report);
	}
	
	public void removeElement(ReportListElement report) {
		reports.getItems().remove(report);
	}
	
	public void backClicked() {
		
	}
	
	
}