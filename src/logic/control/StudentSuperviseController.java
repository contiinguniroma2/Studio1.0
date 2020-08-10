package logic.control;

import java.util.List;
import logic.bean.MessageBean;
import logic.entity.Student;

public interface StudentSuperviseController {
	
	
	public void sendMessageInteraction(Student student);

	List<MessageBean> getMessages(String idBibl, String idStud);
}
