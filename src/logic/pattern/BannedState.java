package logic.pattern;

public class BannedState extends AbstractState {

	private static BannedState instance = null;

	private BannedState() {
		state = "Banned";
	}

	// Singleton

	public static BannedState getInstance() {

		if (instance == null) {

			instance = new BannedState();

		}

		return instance;

	}

	@Override
	public void goNext(StateMachine stateMachine) {
		stateMachine.setState(NormalState.getInstance());

	}
}
