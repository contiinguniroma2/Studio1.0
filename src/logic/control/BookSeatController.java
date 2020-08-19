package logic.control;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import logic.bean.BookSeatBean;
import logic.dao.PrenotazioneDao;
import logic.entity.Library;
import logic.entity.Prenotazione;
import logic.entity.Student;
import logic.exceptions.StudentAlreadyBookedException;

public class BookSeatController {
	private Student student;
	private PrenotazioneDao prenotazioneDao;
	private BookSeatBean bookSeatBean;
	private Library library;
	private Prenotazione prenotazione;
	static Logger myLogger = Logger.getLogger("logger");
	
	public BookSeatController(Student student, Library library, BookSeatBean bookSeatBean) {
		this.student = student;
		this.library = library;
		this.bookSeatBean = bookSeatBean;
		this.prenotazioneDao = new PrenotazioneDao();
	}
	
	/*
	 * Metodo per prenotare posto
	 */
	public void bookSeat(Student student, Library library) {
		try {
			if (prenotazioneDao.select(student.getMail(), "mainS").isEmpty()) {
				prenotazioneDao.insert(library.getMail(), student.getMail(), student.getName());
				fillBookBean();
			} else {
				throw new StudentAlreadyBookedException("non puoi prenotarti due volte");
			}
		} catch (StudentAlreadyBookedException e) {
			myLogger.info(e.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * Metodo per caricare la prenotazione nella bean
	 */
	private void fillBookBean() throws SQLException {
		List<Prenotazione> bookResultSet = prenotazioneDao.select(student.getMail(), "mainS");
		bookSeatBean.setPrenotazione(bookResultSet.get(0));
	}

	/*
	 * Metodo per cancellare prenotazione
	 */
	public boolean deleteBook() {
		//se prenotazione esiste (sicuro) eliminala
		return true;
	}
	
	/*
	 * Metodo per validare prenotazione, true valida, false invalida
	 */
	public void validBook(Prenotazione prenotazione, Boolean confirm) {
		//Da fare
	}
	
	/*
	 * Timer book
	 */
	public void timerBook(Prenotazione prenotazione) {
		//while(timer < 15:00)
		//	do nothing
		//end while: validBook(prenotazione, false)
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}
}
