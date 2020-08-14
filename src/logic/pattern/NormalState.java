package logic.pattern;

import logic.entity.Message;

public class NormalState extends AbstractState {
    private String titleNormal = "Account notified";
    private String textNormal = "Your account has been reported, we ask you to modify your personal information and rewrite it using appropriate language";
    private String textFeedback = "Your account has been reported becouse your feedback was inappropriate";
	public NormalState() {
		state = "Normal";
	}

	@Override
	public void goNext(StateMachine stateMachine) {
		stateMachine.setState(new NotifiedState());
	}

	@Override
	public Message notifyStudent(String reason) {
		Message message = null;
		if (reason.equals("feedback")) {
			message = new Message(titleNormal,textFeedback);
		}
		if (reason.equals("infoAccount")) {
			message = new Message(titleNormal,textNormal);
		}
		return message;
	}
}