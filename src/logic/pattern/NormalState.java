package logic.pattern;

public class NormalState extends AbstractState {

	public NormalState() {
		state = "Normal";
	}

	@Override
	public void goNext(StateMachine stateMachine) {
		stateMachine.setState(new NotifiedState());
	}

	@Override
	public void notifyStudent() {
		
	}
}