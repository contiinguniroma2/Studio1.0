package logic.pattern;

public class NotifiedState extends AbstractState {

	public NotifiedState() {
		state = "Notified";
	}


	@Override
	public void goNext(StateMachine stateMachine) {
		stateMachine.setState(new BannedState());
	}


	@Override
	public void notifyStudent() {
		
		
	}
	
	
}
