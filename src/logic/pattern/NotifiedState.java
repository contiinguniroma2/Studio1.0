package logic.pattern;

import logic.entity.Message;

public class NotifiedState extends AbstractState {
    private String titleNotified = "Account notified";
    private String textNotified = "Here we go again, we ask you to modify your personal information and rewrite it using appropriate language";
    private String textFeedback = "Here we go again, your account has been reported becouse your feedback was inappropriate";
    
	public NotifiedState() {
		state = "Notified";
	}


	@Override
	public void goNext(StateMachine stateMachine) {
		stateMachine.setState(new BannedState());
	}


	@Override
	public Message notifyStudent(String reason) {
		Message message = null;
		if (reason.equals("feedback")) {
			message = new Message(titleNotified,textFeedback);
		}
		if (reason.equals("infoAccount")) {
			message = new Message(titleNotified,textNotified);
		}
		return message;
	}
	
	
}
