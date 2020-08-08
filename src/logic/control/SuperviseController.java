package logic.control;

import java.util.ArrayList;
import java.util.List;

import logic.bean.MessageBean;
import logic.bean.StudentBean;
import logic.dao.MessageDao;
import logic.dao.StudentDao;
import logic.entity.Message;
import logic.entity.Student;

public class SuperviseController implements StudentSuperviseController, LibrarianSuperviseController{
	private List<Student> listStudents;
	private List<StudentBean> listStudentBean;
	private StudentDao studentDao;
	private MessageBean messageBean;
	private List<Message> listMessages;
	private MessageDao messageDao;
	
	public SuperviseController() {
		this.studentDao = new StudentDao();
		this.messageDao = new MessageDao();
	}

	@Override
	public List<String> fillSupervisePage() {
		listStudents = studentDao.getStudentFromDb();
		List<String> list = new ArrayList<>();
		for (int i=0; i< listStudents.size(); i++) {
			 list.add(listStudents.get(i).getUsername());
		}
		return list;
	}

	@Override
	public StudentBean getInfoStudent(String username) {
		int i;
	    for (i=0; i<listStudentBean.size(); i++) {
	    	if (listStudentBean.get(i).getUsername().equals(username)) {
	    		return listStudentBean.get(i);
	    	}
	    }
	    StudentBean studentBean = new StudentBean();
		for (i=0; i< listStudents.size(); i++) {
			if (listStudents.get(i).getUsername().equals(username)) {
				studentBean.fillUserBean(listStudents.get(i).getUsername(),listStudents.get(i).getMail(), "****", listStudents.get(i).getName(),listStudents.get(i).getPhone());
				studentBean.fillStudBean(listStudents.get(i).getSurname(), listStudents.get(i).isBanned(), listStudents.get(i).getReportCounter());
				listStudentBean.add(studentBean);
			}
			else {
				System.out.println("Errore: lo studente non è nella lista");
			}
		}
		return studentBean;
	}
	

	@Override
	public void increaseReportingCounter(String username) {
		Student student = null;
		for (int i=0; i< listStudents.size(); i++) {
			if (listStudents.get(i).getUsername().equals(username)) {
				student = listStudents.get(i);
			}
			else {
				System.out.println("Errore: lo studente non è nella lista");
			}
		}
		student.increaseReportCounter();
		if (student.getReportCounter() > 2) {
			student.setBanned(true);
		}
	}
	

	@Override
	public List<MessageBean> getMessages() {
		listMessages = messageDao.getMessagesFromDb();
		List<MessageBean> list = new ArrayList<>();
		for (int i=0; i< listMessages.size(); i++) {
			 MessageBean messageBean = new MessageBean(listMessages.get(i).getId(), listMessages.get(i).getTitle(), listMessages.get(i).getText(), listMessages.get(i).getLibrarianId(), listMessages.get(i).getStudentId());
			 list.add(messageBean);
		}
		return list;
	}

	@Override
	public void sendMessageInteraction(Student student) {
		student.stopCountdown();
		studentDao.updateStudent(student);
	}

	@Override
	public void sendMessage() {
		// TODO Auto-generated method stub
		
	}
}
