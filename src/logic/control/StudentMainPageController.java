package logic.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import logic.bean.LibrBean;
import logic.bean.StudentBean;
import logic.dao.BookMarkDao;
import logic.dao.LibraryDao;
import logic.dao.PrenotazioneDao;
import logic.dao.StudentDao;
import logic.entity.BookMark;
import logic.entity.Library;
import logic.entity.Prenotazione;
import logic.entity.Student;
import logic.exceptions.StudentAlreadyBookedException;

public class StudentMainPageController extends MainPageController {
	private Student studInfo;
	private StudentBean studInfoB;
	private StudentDao studDao;
	private Prenotazione book;
	private List<BookMark> bookInfo;
	private BookMarkDao bookMarkDao;
	static Logger myLogger = Logger.getLogger("logger");
	private static StudentMainPageController instance = null;

	protected StudentMainPageController() {
		this.libraryInfoB = new LibrBean();
		this.libraryInfo = new Library();
		this.librDao = new LibraryDao();
		this.setBook(new Prenotazione());
		this.bookDao = new PrenotazioneDao();
		this.bookInfo = new ArrayList<>();
		this.bookMarkDao = new BookMarkDao();
		this.studInfo = new Student();
		this.studInfoB = new StudentBean();
		this.studDao = new StudentDao();
	}

	/*
	 * Metodo per richiedere l istanza signleton di controller
	 */

	public static StudentMainPageController getStudentMainPageController() {
		if (StudentMainPageController.instance == null)
			StudentMainPageController.instance = new StudentMainPageController();
		return instance;
	}

	/*
	 * Update delle info della bilioteca
	 */
	public void updateStudentInfo() throws SQLException {
		studInfo = studDao.select(studInfo.getMail(), studInfo.getPassword()).get(0);
	}

	public void getBookMarks() {
		try {
			bookInfo = bookMarkDao.select(studInfo.getMail());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * Prenotazione dello studente presso una biblioteca
	 */

	public void book() {
		try {
			if (bookDao.select(studInfo.getMail(), "mainS").isEmpty()) {
				bookDao.insert(libraryInfoB.getMail(), studInfo.getMail(), studInfo.getName());
			} else throw new StudentAlreadyBookedException("non puoi prenotarti due volte");
		} catch (StudentAlreadyBookedException e) {
			myLogger.info(e.toString());
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public Student getStudInfo() {
		return studInfo;
	}

	public void setStudInfo(Student studInfo) {
		this.studInfo = studInfo;
	}

	public StudentBean getStudInfoB() {
		return studInfoB;
	}

	public void setStudInfoB(StudentBean studInfoB) {
		this.studInfoB = studInfoB;
	}

	public List<BookMark> getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(List<BookMark> bookInfo) {
		this.bookInfo = bookInfo;
	}

	public BookMarkDao getBookMarkDao() {
		return bookMarkDao;
	}

	public void setBookMarkDao(BookMarkDao bookMarkDao) {
		this.bookMarkDao = bookMarkDao;
	}

	public Prenotazione getBook() {
		return book;
	}

	public void setBook(Prenotazione book) {
		this.book = book;
	}

}
