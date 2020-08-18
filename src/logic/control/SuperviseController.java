package logic.control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.bean.MessageBean;
import logic.bean.StudentBean;
import logic.boundary.InfoAccountSelectedGUI;
import logic.boundary.SuperviseGUI;
import logic.dao.MessageDao;
import logic.dao.StudentDao;
import logic.entity.Message;
import logic.entity.Student;
import logic.pattern.BannedState;

public class SuperviseController implements StudentSuperviseController, LibrarianSuperviseController{
	private List<Student> listStudents;
	private List<StudentBean> listStudentBean;
	private StudentDao studentDao;
	private List<Message> listMessages;
	private MessageDao messageDao;
	private Student student;
	
	public SuperviseController() {
		this.studentDao = new StudentDao();
		this.messageDao = new MessageDao();
		this.listStudentBean = new ArrayList<>();
	}
	
	public SuperviseController(Student student) {
		this.studentDao = new StudentDao();
		this.messageDao = new MessageDao();
		this.listStudentBean = new ArrayList<>();
		this.student = student;
	}

	@Override
	public List<String> fillSupervisePage(String biblioId) {
		try {
			listStudents = studentDao.getStudentFromDb(biblioId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<String> list = new ArrayList<>();
		for (int i=0; i< listStudents.size(); i++) {
			 list.add(listStudents.get(i).getUsername());
		}
		return list;
	}

	@Override
	public void getInfoStudent(String username, SuperviseGUI superviseGUI) {
		int i;
	    for (i=0; i<listStudentBean.size(); i++) {
	    	if (listStudentBean.get(i).getUsername().equals(username)) {
	    		InfoAccountSelectedGUI infoAccountSelectedGUI = new InfoAccountSelectedGUI(superviseGUI, listStudentBean.get(i));
	    		superviseGUI.getRoot().setCenter(infoAccountSelectedGUI.createInfoAccountGUI());
	    	}
	    }
	    StudentBean studentBean = new StudentBean();
		for (i=0; i< listStudents.size(); i++) {
			if (listStudents.get(i).getUsername().equals(username)) {
				studentBean.setPhone(listStudents.get(i).getPhone());
				studentBean.fillUserBean(listStudents.get(i).getUsername(),listStudents.get(i).getMail(), "****", listStudents.get(i).getName(),listStudents.get(i).getPhone());
				studentBean.fillStudBean(listStudents.get(i).getSurname(), listStudents.get(i).isBanned(), listStudents.get(i).getReportCounter());
				listStudentBean.add(studentBean);
			}
			else {
				System.out.println("Errore: lo studente non è nella lista");
			}
		}
		InfoAccountSelectedGUI infoAccountSelectedGUI = new InfoAccountSelectedGUI(superviseGUI, studentBean);
		superviseGUI.getRoot().setCenter(infoAccountSelectedGUI.createInfoAccountGUI());		
	}
	

	@Override
	public void increaseReportingCounter(String studentId, String librarianId, String reason) {
		Student student = null;
		Message message = null;
		int i;
		for (i=0; i< listStudents.size(); i++) {
			if (listStudents.get(i).getMail().equals(studentId)) {
				student = listStudents.get(i);
			}
			else {
				System.out.println("Errore: lo studente non è nella lista");
			}
		}
		if (student.getStateMachine().getState().getState().equals("Notified")) {
			message = student.notifyStudent(reason);
		}
		else {
			if (student.getReportCounter() > 2) {
				student.getStateMachine().setState(new BannedState());
				message = student.notifyStudent(reason);
				student.setBanned(true);
			}
			if (student.getReportCounter() < 3) {
				student.increaseReportCounter();
				message = student.notifyStudent(reason);
				student.startCountdown();
				student.getStateMachine().goNext();			
			}
		}
		message.setLibrarianId(librarianId);
		message.setStudentId(studentId);
	
		for (i=0; i<listStudentBean.size(); i++) {
	    	if (listStudentBean.get(i).getMail().equals(studentId)) {
	    		listStudentBean.get(i).increaseReportingCounter();
	    		listStudentBean.get(i).setBanned(student.isBanned());	    		
	    	}
	    }
		studentDao.updateStudentState(student);
		message.setId(messageDao.insert(message));
	}
	
	
	@Override
	public List<MessageBean> getMessages(String idStud) {
		try {
			listMessages = messageDao.getMessagesFromDb(idStud);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<MessageBean> list = new ArrayList<>();
		for (int i=0; i< listMessages.size(); i++) {
			MessageBean messageBean = new MessageBean(listMessages.get(i).getId(), listMessages.get(i).getTitle(), listMessages.get(i).getText(), listMessages.get(i).getLibrarianId(), listMessages.get(i).getStudentId());
			list.add(messageBean);
		}
		return list;
	}

	@Override
	public void sendMessageInteraction(String studentId) {
		student.stopCountdown();
		studentDao.updateStudent(student);
	}

	@Override
	public void sendMessage(MessageBean messageBean) {
	    Message message = new Message(messageBean.getTitle(), messageBean.getText(), messageBean.getLibrarianId(), messageBean.getStudentId());
	    message.setId(messageDao.insert(message));
	}

	@Override
	public void deleteMessage(long messageId) {
		messageDao.delete(messageId);
		
	}


}
