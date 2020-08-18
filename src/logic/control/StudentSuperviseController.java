package logic.control;

import java.util.List;
import logic.bean.MessageBean;
import logic.entity.Student;

public interface StudentSuperviseController {
	
	
	public void sendMessageInteraction(String studentId);

	List<MessageBean> getMessages(String idStud);

	public void deleteMessage(long id);
}
