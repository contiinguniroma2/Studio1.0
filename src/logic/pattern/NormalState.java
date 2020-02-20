package logic.pattern;

public class NormalState extends AbstractState {
	private static NormalState instance = null;

	private NormalState() {
		state = "Normal";
	}

	// Singleton

	public static NormalState getInstance() {

		if (instance == null) {

			instance = new NormalState();

		}

		return instance;

	}

	@Override
	public void goNext(StateMachine stateMachine) {
		stateMachine.setState(NotifiedState.getInstance());
	}
}