package logic.boundary;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import logic.constants.FxmlConstants;
import logic.control.SearchController;
import logic.entity.Student;

public class StudentFxmlGUI extends FxmlGUI{
	
	@FXML private Button btnSearchSeat;
	@FXML private Button btnMessages;
	@FXML private Button btnLogout;
	@FXML protected Button btnUserPic;
	@FXML protected ImageView ivBtnUserPic;
	private Student student;
	private SearchController searchController;
	//Dichiarazione messagesController
	
	public StudentFxmlGUI() {
	}
	
	public StudentFxmlGUI(Student student) {
		this.student = student;
	}
	
	/*
	 * Metodo associato al click sull'immagine utente nel pannello
	 */
	@FXML
	public void profileUserInfoButtonClicked() {
		// passa a vista profilo
	}
	
	/*
	 * Metodo associato al click su "Search Seat" nel pannello
	 */
	@FXML
	public void btnSearchSeatClicked(ActionEvent event) throws IOException {
		// passa a vista search
		searchController=new SearchController();
		guiLoader(FxmlConstants.STUDENT_SEARCH_GUI, new StudentSearchFxmlGUI(student, searchController), event);

	}
	
	/*
	 * Metodo associato al click su "Messages" nel pannello
	 */
	@FXML
	public void messagesButtonClicked() {
		// passa a vista messaggi
	}
	
	/*
	 * Metodo associato al click su "Logout" nel pannello
	 */
	@FXML
	public void logoutButtonClicked() {
		// logout
	}

	public SearchController getSearchController() {
		return searchController;
	}

	public void setSearchController(SearchController searchController) {
		this.searchController = searchController;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// default
	}

	

}
