package logic.control;

import java.util.List;

import logic.bean.MessageBean;
import logic.bean.StudentBean;

/*
 * Dichiarazione metodi di interazione del Librarian nel caso d'uso SuperviseStudent
 */
public interface LibrarianSuperviseController {
	public List<String> fillSupervisePage();
	public StudentBean getInfoStudent(String username);
	public void increaseReportingCounter(String username);
	public void sendMessage(MessageBean messageBean);
}
