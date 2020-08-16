package logic.boundary;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import logic.bean.BookSeatBean;
import logic.control.BookSeatController;
import logic.entity.Library;
import logic.entity.Prenotazione;
import logic.entity.Student;

public class StudentSearchResultFxmlGUI implements Initializable {
	
	@FXML private Button btnBookSeat;
	@FXML private Button btnReportIssue;
	@FXML private Button btnNoticeboard;
	@FXML private Button btnTimetable;
	@FXML private Button btnMap;
	@FXML private Button btnBack;
	@FXML private Text txNome;
	@FXML private Text txIndirizzo;
	@FXML private Text txTelefono;
	@FXML private Text txMail;
	@FXML private Text txPostiLiberi;
	private Student student;
	private Library library;
	private Prenotazione prenotazione;
	private BookSeatController bookSeatController;
	private BookSeatBean bookSeatBean;
	private StudentSearchFxmlGUI studentSearchFxmlGUI;
	static Logger myLogger = Logger.getLogger("logger");
	
	public StudentSearchResultFxmlGUI(Student student, Library library, StudentSearchFxmlGUI studentSearchFxmlGUI) {
		this.student = student;
		this.library = library;
		this.studentSearchFxmlGUI = studentSearchFxmlGUI;
		this.bookSeatBean = new BookSeatBean();
		this.bookSeatController = new BookSeatController(student, library, bookSeatBean);
	}

	
	@FXML
	private void reportIssue(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/logic/fxml/IssueListStudentGUI.fxml"));
		loader.setController(new IssueListStudentBoundary(this.student,this.library,this));
		BorderPane nextParent = null;
		try {
			nextParent = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
        Scene nextScene = new Scene(nextParent, 800, 600);
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
	}
	
	@FXML
	private void bookSeat(ActionEvent event) {
		myLogger.info("Book");
		bookSeatController.bookSeat(student, library);
		prenotazione = bookSeatBean.getPrenotazione();
		myLogger.info("Book: " + prenotazione.getNumero() + " - " + prenotazione.getOrarioPrenotazione() + " - " + prenotazione.getBiblioteca() + " - " + prenotazione.getUsernameStud());
	}
	
	@FXML
	private void noticeboard(ActionEvent event) {
		
	}
	
	@FXML
	private void timetable(ActionEvent event) {
		
	}
	
	@FXML
	private void map(ActionEvent event) {
		
	}
	
	@FXML
	private void backPressed(ActionEvent event) throws IOException {
		myLogger.info("Back");
		// passa a vista search
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/logic/fxml/StudentSearchGUI.fxml"));
		fxmlLoader.setController(studentSearchFxmlGUI);
		
		BorderPane nextParent = fxmlLoader.load();
        Scene nextScene = new Scene(nextParent, 800, 600);
		
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(nextScene);
        window.show();
				
	}
	
	/*
	 * Metodo per aggiornare i dati nella vista
	 */
	private void updateInfoView() {
		txNome.setText(library.getName());
		txIndirizzo.setText(library.getIndirizzo());
		txTelefono.setText(library.getPhone());
		txMail.setText(library.getMail());
		txPostiLiberi.setText(String.valueOf(library.getCapacity() - library.getPostiOccupati()));
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		updateInfoView();
	}

}
