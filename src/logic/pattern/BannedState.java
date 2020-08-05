package logic.pattern;

public class BannedState extends AbstractState {


	public BannedState() {
		state = "Banned";
	}

	@Override
	public void goNext(StateMachine stateMachine) {
		stateMachine.setState(new NormalState());

	}

	@Override
	public void notifyStudent() {
		
		
	}
}
