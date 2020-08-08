package logic.control;

import java.util.List;
import logic.bean.MessageBean;
import logic.entity.Student;

public interface StudentSuperviseController {
	public List<MessageBean> getMessages();
	public void sendMessageInteraction();
	void sendMessageInteraction(Student student);
}
