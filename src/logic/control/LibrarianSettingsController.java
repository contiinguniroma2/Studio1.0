package logic.control;

import java.sql.SQLException;
import java.util.logging.Logger;

import logic.bean.LibrBean;
import logic.dao.LibraryDao;
//import logic.entity.Library;

public class LibrarianSettingsController {

//	private Library librInfo;
	private LibrBean librInfoB;
	private LibraryDao librDao;
	static Logger myLogger = Logger.getLogger("logger");
	private static LibrarianSettingsController instance = null;

	protected LibrarianSettingsController() {
		this.librInfoB = new LibrBean();
		//this.librInfo = LoginController.getLoginController().getLibrary();
		this.librDao = new LibraryDao();
	}

	/*
	 * Metodo per richiedere l istanza signleton di controller
	 */

	public static LibrarianSettingsController getLibrarianSettingsController() {
		if (LibrarianSettingsController.instance == null)
			LibrarianSettingsController.instance = new LibrarianSettingsController();
		return instance;
	}

	public void updateLibraryInfo(String LibrarianId) throws SQLException {
		if (!librInfoB.getMail().isEmpty())
			librDao.update("mailBiblioteca", librInfoB.getMail(), LibrarianId);
		if (!librInfoB.getPassword().isEmpty())
			librDao.update("passwordBiblioteca", librInfoB.getPassword(), LibrarianId);
		if (!librInfoB.getUsername().isEmpty())
			librDao.update("username", librInfoB.getUsername(), LibrarianId);
		if (!librInfoB.getName().isEmpty())
			librDao.update("nomeBiblioteca", librInfoB.getName(), LibrarianId);
		if (!librInfoB.getPhone().isEmpty())
			librDao.update("telefonoBiblioteca", librInfoB.getPhone(), LibrarianId);
		if (librInfoB.getCapacity() != 0)
			librDao.updatePosti(librInfoB.getCapacity(), LibrarianId, "posti");
		if (!librInfoB.getCity().isEmpty())
			librDao.update("citta", librInfoB.getCity(), LibrarianId);
		if (!librInfoB.getAddress().isEmpty())
			librDao.update("indirizzo", librInfoB.getAddress(), LibrarianId);
	}

/*	public Library getLibrInfo() {
		return librInfo;
	}

	public void setLibrInfo(Library librInfo) {
		this.librInfo = librInfo;
	}
*/
	public LibrBean getLibrInfoB() {
		return librInfoB;
	}

	public void setLibrInfoB(LibrBean librInfoB) {
		this.librInfoB = librInfoB;
	}

	public LibraryDao getLibrDao() {
		return librDao;
	}

	public void setLibrDao(LibraryDao librDao) {
		this.librDao = librDao;
	}

}
