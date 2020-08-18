package logic.pattern;

import logic.entity.Message;

public class NormalState extends AbstractState {
	private String titleNormal = "Your info account was reported";
    private String titleFeedNormal = "Your feedback was reported";
    private String textNormal = "Your account has been reported, we ask you to modify\nyour personal information and rewrite it using appropriate language";
    private String textFeedback = "Your account has been reported\nbecouse your feedback was inappropriate";
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
			message = new Message(titleFeedNormal,textFeedback);
		}
		if (reason.equals("infoAccount")) {
			message = new Message(titleNormal,textNormal);
		}
		return message;
	}
}