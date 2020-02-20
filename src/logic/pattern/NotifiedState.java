package logic.pattern;

public class NotifiedState extends AbstractState {

	private static NotifiedState instance = null;

	private NotifiedState() {
		state = "Notified";
	}

	// Singleton

	public static NotifiedState getInstance() {

		if (instance == null) {

			instance = new NotifiedState();

		}

		return instance;

	}

	@Override
	public void goNext(StateMachine stateMachine) {
		stateMachine.setState(BannedState.getInstance());
	}
}
