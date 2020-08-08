package logic.control;

import logic.bean.LibrBean;
import logic.bean.StudentBean;
import logic.dao.LibraryDao;
import logic.dao.StudentDao;
import logic.entity.Library;
import logic.entity.Student;
import logic.pattern.BannedState;
import logic.pattern.NotifiedState;

import java.util.logging.Logger;
import java.sql.SQLException;
import java.util.List;

public class LoginController implements GenericController {
	private LibrBean librBean;
	private StudentBean studBean;
	private Library library;
	private LibraryDao loginL;
	private StudentDao loginS;
	private Student studInfo;
	static Logger myLogger = Logger.getLogger("logger");
	private static LoginController instance = null;

	protected LoginController() {
		this.librBean = new LibrBean();
		this.studBean = new StudentBean();
		this.library = new Library();
		this.studInfo = new Student();
		this.loginL = new LibraryDao();
		this.loginS = new StudentDao();
	}

	public static LoginController getLoginController() {
		if (LoginController.instance == null)
			LoginController.instance = new LoginController();
		return instance;
	}

	public char validateUser(String mail, String password) throws SQLException {

		List<Student> rsS = loginS.select(mail, password);
		for (byte i = 0; i < rsS.size();) {
			if ((rsS.get(i).getMail().equals(mail)) && (rsS.get(i).getPassword().equals(password))) {

				studInfo.fillUser(rsS.get(i).getUsername(), rsS.get(i).getMail(), rsS.get(i).getPassword(),
						rsS.get(i).getName(), rsS.get(i).getPhone());
				studInfo.fillStudent(rsS.get(i).getSurname(), rsS.get(i).isBanned(), rsS.get(i).getReportCounter());
				if ((studInfo.getReportCounter() > 2) && (!studInfo.isBanned()))
					studInfo.getStateMachine().setState(NotifiedState.getInstance());
				if (studInfo.isBanned())
					studInfo.getStateMachine().setState(BannedState.getInstance());
				studBean.fillUserBean(rsS.get(i).getUsername(), rsS.get(i).getMail(), rsS.get(i).getPassword(),
						rsS.get(i).getName(), rsS.get(i).getPhone());
				studBean.fillStudBean(rsS.get(i).getSurname(), rsS.get(i).isBanned(), rsS.get(i).getReportCounter());
				return 's';
			}
		}

		List<Library> rsL = loginL.select(mail, password);
		for (byte i = 0; i < rsL.size();) {
			if ((rsL.get(i).getMail().equals(mail)) && (rsL.get(i).getPassword().equals(password))) {

				librBean.fillUserBean(rsL.get(i).getUsername(), rsL.get(i).getMail(), rsL.get(i).getPassword(),
						rsL.get(i).getName(), rsL.get(i).getPhone());
				librBean.fillLibrBean(rsL.get(i).getIndirizzo(), rsL.get(i).getCity(), rsL.get(i).getCapacity(),
						rsL.get(i).getPostiOccupati());

				library.fillUser(rsL.get(i).getUsername(), rsL.get(i).getMail(), rsL.get(i).getPassword(),
						rsL.get(i).getName(), rsL.get(i).getPhone());
				library.fillLibrary(rsL.get(i).getIndirizzo(), rsL.get(i).getCity(), rsL.get(i).getCapacity(),
						rsL.get(i).getPostiOccupati());

				return 'l';
			}
		}

		return '0';
	}

	/*
	 * String username,String mail,String password,String name,String phone,String
	 * address,String city,String capacity,String postiOccupati
	 * 
	 */
	@Override
	public void fillBean(String... arg) {
		librBean.fillUserBean(arg[0], arg[1], arg[2], arg[3], arg[4]);
		librBean.fillLibrBean(arg[5], arg[6], Integer.valueOf(arg[7]), Integer.valueOf(arg[8]));
	}

	@Override
	public void fillEntity(String... arg) {
		library.fillUser(arg[0], arg[1], arg[2], arg[3], arg[4]);
		library.fillLibrary(arg[5], arg[6], Integer.valueOf(arg[7]), Integer.valueOf(arg[8]));
	}

	public LibrBean getLibrBean() {
		return librBean;
	}

	public void setLibrBean(LibrBean librBean) {
		this.librBean = librBean;
	}

	public StudentBean getStudBean() {
		return studBean;
	}

	public void setStudBean(StudentBean studBean) {
		this.studBean = studBean;
	}

	public Library getLibrary() {
		return library;
	}

	public void setLibrary(Library library) {
		this.library = library;
	}

	public Student getStudent() {
		return studInfo;
	}

	public void setStudent(Student student) {
		this.studInfo = student;
	}

}
