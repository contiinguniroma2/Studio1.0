package logic.boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.bean.SearchBean;
import logic.control.SearchController;
import logic.entity.Library;
import logic.entity.Student;

public class StudentSearchFxmlGUI implements Initializable {
	
	@FXML private TextField tfSearchSeat;
	@FXML private Button btnSearchSeat;
	@FXML private Button btnBack;
	@FXML private Button btnNext;
	@FXML private ListView<String> lvSearchSeatResults;
	private Student student;
	private SearchController searchController;
	private SearchBean searchBean;
	private List<Library> librariesResult;
	private int selectListViewIndex;
	private StudentSearchResultFxmlGUI studentSearchResultFxmlGUI;
	static Logger myLogger = Logger.getLogger("logger");
	
	public StudentSearchFxmlGUI() {
		this.searchBean = searchController.getSearchBean();
		this.lvSearchSeatResults = new ListView<String>();
		this.librariesResult = new ArrayList<Library>();
	}
	
	public StudentSearchFxmlGUI(Student student, SearchController searchController) {
		this.student = student;
		this.searchController = searchController;
		this.searchBean = searchController.getSearchBean();
		this.lvSearchSeatResults = new ListView<String>();
		this.librariesResult = new ArrayList<Library>();
	}

	/*
	 * Metodo associato al click su "Search"
	 */
	@FXML
	public void searchSeat() {
		myLogger.info("Digit: " + tfSearchSeat.getText().toString());
		searchLibrariesFromCity(tfSearchSeat.getText().toString());	//chiamo metodo controller
		librariesResult = searchBean.getResultLibraries();
		updateListView();
	}

	/*
	 * Metodo per aggiornare la listView
	 */
	private void updateListView() {
		for(int i=0; i<librariesResult.size(); i++) {
			lvSearchSeatResults.getItems().add(librariesResult.get(i).getName() + " - Posti liberi: " + (librariesResult.get(i).getCapacity() - librariesResult.get(i).getPostiOccupati()));
		}
	}
	
	/*
	 * Metodo per la selezione della biblioteca nella listView
	 */
	@FXML
	public void selectLibraryFromResults() {
		selectListViewIndex = lvSearchSeatResults.getSelectionModel().getSelectedIndex();
	}
	
	/*
	 * Metodo per tornare indietro
	 */
	@FXML
	public void back(ActionEvent event) throws IOException {
		// passa a vista student
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/logic/fxml/StudentGUI.fxml"));
		StudentFxmlGUI studentFxmlGui = new StudentFxmlGUI(student);
		fxmlLoader.setController(studentFxmlGui);
		
		BorderPane nextParent = fxmlLoader.load();
        Scene nextScene = new Scene(nextParent, 800, 600);
		
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(nextScene);
        window.show();
	}
	
	/*
	 * Metodo associato al click su "Next" per aprire la pagina sulle informazioni della biblioteca selezionata
	 */
	@FXML
	public void next(ActionEvent event) throws IOException {
		// passa a vista student
		
		//DBG
		myLogger.info("Next");
		if(selectListViewIndex != -1) myLogger.info(librariesResult.get(selectListViewIndex).getName().toString());
		else myLogger.info(String.valueOf(selectListViewIndex));
		//END DBG
		
		// passa a vista risultato
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/logic/fxml/StudentSearchResultGUI.fxml"));
		studentSearchResultFxmlGUI = new StudentSearchResultFxmlGUI(student, librariesResult.get(selectListViewIndex), this);
		fxmlLoader.setController(studentSearchResultFxmlGUI);	
		BorderPane nextParent = fxmlLoader.load();
        Scene nextScene = new Scene(nextParent, 800, 600);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.selectListViewIndex = -1;
		this.tfSearchSeat.setText("");
	}
	
	/////////////////////
	//	TO CONTROLLER  //
	/////////////////////
	
	/*
	 * Metodo per controller
	 */
	private void searchLibrariesFromCity(String city) {
		searchController.searchLibraryFromCity(city);
	}

}
